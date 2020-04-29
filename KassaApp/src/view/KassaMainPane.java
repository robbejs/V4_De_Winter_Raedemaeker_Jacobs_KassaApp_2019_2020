package view;
import controller.KassaController;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import model.Winkelkar;
import model.database.ArtikelDB;
import view.panels.InstellingOverviewPane;
import view.panels.KassaOverviewPane;
import view.panels.LogOverviewPane;
import view.panels.ProductOverviewPane;

public class KassaMainPane extends BorderPane {

    private Winkelkar winkelkar;

	public KassaMainPane(ArtikelDB artikelDB){
        winkelkar = new Winkelkar();
        KassaController kassa  = new KassaController(winkelkar);
	    TabPane tabPane = new TabPane();
        KassaOverviewPane kassaOverviewPane = new KassaOverviewPane(artikelDB, winkelkar);
        Tab kassaTab = new Tab("Kassa", kassaOverviewPane);
        ProductOverviewPane productOverviewPane = new ProductOverviewPane(artikelDB);
        Tab artikelTab = new Tab("Artikelen",productOverviewPane);
        InstellingOverviewPane instellingOverviewPane = new InstellingOverviewPane();
        Tab instellingTab = new Tab("Instellingen", instellingOverviewPane);
        LogOverviewPane logOverviewPane = new LogOverviewPane();
        Tab logTab = new Tab("Log", logOverviewPane);
        tabPane.getTabs().addAll(kassaTab, artikelTab, instellingTab, logTab);
	    this.setCenter(tabPane);
	}
}
