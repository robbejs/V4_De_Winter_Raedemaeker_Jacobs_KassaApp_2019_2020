package view;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import model.database.ArtikelDB;
import view.panels.ProductOverviewPane;

public class KassaMainPane extends BorderPane {

	public KassaMainPane(ArtikelDB artikelDB){
	    TabPane tabPane = new TabPane(); 	    
        Tab kassaTab = new Tab("Kassa");
        ProductOverviewPane productOverviewPane = new ProductOverviewPane(artikelDB);
        Tab artikelTab = new Tab("Artikelen",productOverviewPane);
        Tab instellingTab = new Tab("Instellingen");
        Tab logTab = new Tab("Log");
        tabPane.getTabs().addAll(kassaTab, artikelTab, instellingTab, logTab);
	    this.setCenter(tabPane);
	}
}
