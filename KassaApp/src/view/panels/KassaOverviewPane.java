package view.panels;

import controller.KassaController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Artikel;
import model.Winkelkar;
import model.database.ArtikelDB;

import java.util.ArrayList;

public class KassaOverviewPane extends GridPane {

    private TableView<Artikel> table = new TableView<Artikel>();


    public KassaOverviewPane(ArtikelDB artikelDB, Winkelkar karretje){
        Label lblFout = new Label("");
        Label lblTotaalPrijs = new Label("TotaalPrijs");
        TextField txtInputId = new TextField();
        txtInputId.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER){
                for(Artikel a: artikelDB.getArtikels()){
                    if(a.getId().equalsIgnoreCase(txtInputId.getText())){
                        karretje.addArtikel(a);
                        karretje.notifyObserver();
                        lblFout.setText("");
                        lblTotaalPrijs.setText(Double.toString(karretje.getTotaalPrijs()));
                        break;
                    }else{
                        lblFout.setText("Dit artikel is niet beschikbaar");
                    }
                }
                txtInputId.clear();
            }
        });



        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        table.setEditable(true);

        TableColumn<Artikel, String> colNaam = new TableColumn<Artikel, String>("naam");
        colNaam.setMinWidth(170);
        colNaam.setCellValueFactory(new PropertyValueFactory<Artikel, String>("naam"));

        TableColumn<Artikel, String> colPrijs = new TableColumn<Artikel, String>("prijs");
        colPrijs.setMinWidth(170);
        colPrijs.setCellValueFactory(new PropertyValueFactory<Artikel, String >("prijs"));


        VBox v1 = new VBox();
        v1.getChildren().addAll(txtInputId, lblTotaalPrijs, lblFout);

        HBox h1 = new HBox(10);
        h1.getChildren().addAll(table, v1);

        table.getColumns().setAll(colNaam,  colPrijs);
        this.add(new Label("Products:"), 0, 0, 1, 1);

        this.getChildren().addAll(h1);
    }

    public void setlijst(ArrayList<Artikel> artikels){
        table.setItems(FXCollections.observableArrayList(artikels ));
    }

}
