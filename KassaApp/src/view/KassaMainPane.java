package view;
import controller.KassaOverviewController;
import controller.LogOverviewController;
import controller.ProductOverviewController;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import model.Winkel;
import view.panels.InstellingOverviewPane;
import view.panels.KassaOverviewPane;
import view.panels.LogOverviewPane;
import view.panels.ProductOverviewPane;

public class KassaMainPane extends BorderPane {

	public KassaMainPane(Winkel winkel){
        KassaOverviewController kassa  = new KassaOverviewController(winkel.getWinkelkar());
        LogOverviewController log = new LogOverviewController(winkel.getWinkelkar());
        ProductOverviewController product = new ProductOverviewController(winkel.getWinkelkar(), winkel);
	    TabPane tabPane = new TabPane();
        KassaOverviewPane kassaOverviewPane = new KassaOverviewPane(winkel);
        kassa.setView(kassaOverviewPane);
        Tab kassaTab = new Tab("Kassa", kassaOverviewPane);
        ProductOverviewPane productOverviewPane = new ProductOverviewPane(winkel.getArtikelDB());
        product.setView(productOverviewPane);
        Tab artikelTab = new Tab("Artikelen",productOverviewPane);
        InstellingOverviewPane instellingOverviewPane = new InstellingOverviewPane(winkel);
        Tab instellingTab = new Tab("Instellingen", instellingOverviewPane);
        LogOverviewPane logOverviewPane = new LogOverviewPane();
        Tab logTab = new Tab("Log", logOverviewPane);
        log.setView(logOverviewPane);
        tabPane.getTabs().addAll(kassaTab, artikelTab, instellingTab, logTab);
	    this.setCenter(tabPane);
	}
}
