package view;
import controller.KassaOverviewController;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import model.Winkel;
import model.Winkelkar;
import model.database.ArtikelDB;
import view.panels.InstellingOverviewPane;
import view.panels.KassaOverviewPane;
import view.panels.LogOverviewPane;
import view.panels.ProductOverviewPane;

public class KassaMainPane extends BorderPane {

	public KassaMainPane(Winkel winkel){
        KassaOverviewController kassa  = new KassaOverviewController(winkel.getWinkelkar());
	    TabPane tabPane = new TabPane();
        KassaOverviewPane kassaOverviewPane = new KassaOverviewPane(winkel);
        kassa.setView(kassaOverviewPane);
        Tab kassaTab = new Tab("Kassa", kassaOverviewPane);
        ProductOverviewPane productOverviewPane = new ProductOverviewPane(winkel.getArtikelDB());
        Tab artikelTab = new Tab("Artikelen",productOverviewPane);
        InstellingOverviewPane instellingOverviewPane = new InstellingOverviewPane();
        Tab instellingTab = new Tab("Instellingen", instellingOverviewPane);
        LogOverviewPane logOverviewPane = new LogOverviewPane();
        Tab logTab = new Tab("Log", logOverviewPane);
        tabPane.getTabs().addAll(kassaTab, artikelTab, instellingTab, logTab);
	    this.setCenter(tabPane);
	}
}
