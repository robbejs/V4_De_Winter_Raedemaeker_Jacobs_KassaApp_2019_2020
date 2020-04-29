package view.panels;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Artikel;
import model.Winkelkar;
import model.database.ArtikelDB;

public class KassaOverviewPane extends GridPane {

    private TableView<Artikel> table = new TableView<Artikel>();


    public KassaOverviewPane(ArtikelDB artikelDB){

        TextField txtInputId = new TextField();

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        table.setItems(FXCollections.observableArrayList(  ));
        table.setEditable(true);
    }
}
