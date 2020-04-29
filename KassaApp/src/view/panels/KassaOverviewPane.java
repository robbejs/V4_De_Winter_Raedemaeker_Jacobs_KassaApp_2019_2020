package view.panels;

import controller.KassaController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import model.Artikel;
import model.Winkelkar;
import model.database.ArtikelDB;

import java.util.ArrayList;

public class KassaOverviewPane extends GridPane {

    private TableView<Artikel> table = new TableView<Artikel>();


    public KassaOverviewPane(ArtikelDB artikelDB, Winkelkar karretje){

        TextField txtInputId = new TextField();
        txtInputId.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER){
                for(Artikel a: artikelDB.getArtikels()){
                    if(a.getId().equalsIgnoreCase(txtInputId.getText())){
                        karretje.addArtikel(a);
                        karretje.notifyObserver();
                    }
                }
            }
        });

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);


        table.setEditable(true);

        this.getChildren().addAll(txtInputId);
    }

    public void setArraylist(ArrayList<Artikel> artikels){
        System.out.println(artikels);
        table.setItems(FXCollections.observableArrayList(artikels ));
    }

}
