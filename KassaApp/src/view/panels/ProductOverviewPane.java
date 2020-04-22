package view.panels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.Artikel;
import model.database.ArtikelDB;


public class ProductOverviewPane extends GridPane {
	//private TableView<Product> table;
	private TableView<Artikel> table = new TableView<Artikel>();

	public ProductOverviewPane(ArtikelDB artikelDB) {
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

		table.setItems(FXCollections.observableArrayList(artikelDB.getArtikels()));
		table.setEditable(true);

		TableColumn<Artikel, String> colId = new TableColumn<Artikel, String>("id");
		colId.setMinWidth(50);
		colId.setCellValueFactory(new PropertyValueFactory<Artikel, String>("id"));

		TableColumn<Artikel, String> colNaam = new TableColumn<Artikel, String>("naam");
		colNaam.setMinWidth(170);
		colNaam.setCellValueFactory(new PropertyValueFactory<Artikel, String>("naam"));

		TableColumn<Artikel, String> colGroep = new TableColumn<Artikel, String>("groep");
		colGroep.setMinWidth(170);
		colGroep.setCellValueFactory(new PropertyValueFactory<Artikel, String>("groep"));

		TableColumn<Artikel, String> colPrijs = new TableColumn<Artikel, String>("prijs");
		colPrijs.setMinWidth(170);
		colPrijs.setCellValueFactory(new PropertyValueFactory<Artikel, String >("prijs"));

		TableColumn<Artikel, String> colVoorraad = new TableColumn<Artikel, String>("voorraad");
		colVoorraad.setMinWidth(170);
		colVoorraad.setCellValueFactory(new PropertyValueFactory<Artikel, String>("voorraad"));

		table.getColumns().setAll(colId, colNaam, colGroep, colPrijs, colVoorraad);
		this.add(new Label("Products:"), 0, 0, 1, 1);
		this.getChildren().addAll(table);
	}



}
