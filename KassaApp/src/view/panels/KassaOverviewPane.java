package view.panels;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Artikel;
import model.Winkel;

import java.util.ArrayList;
import java.util.Optional;

public class KassaOverviewPane extends GridPane {

    private TableView<Artikel> table = new TableView<Artikel>();
    public Label lblTotaalPrijs;
    private Button btnOffHold;
    private Button btnOnHold;
    private Button btnVerkoop;
    private Winkel winkel;

    public KassaOverviewPane(Winkel winkel){
        this.winkel = winkel;
        lblTotaalPrijs = new Label("TotaalPrijs");
        Label lblFout = new Label("");
        TextField txtInputId = new TextField();
        txtInputId.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER){
                for(Artikel a: winkel.getArtikelDB().getArtikels()){
                    if(a.getId().equalsIgnoreCase(txtInputId.getText())){
                        winkel.getWinkelkar().addArtikel(a);
                        winkel.getWinkelkar().notifyObserver();
                        lblFout.setText("");
                        break;
                    }else{
                        lblFout.setText("Dit artikel is niet beschikbaar");
                    }
                }
                txtInputId.clear();
            }
        });

        table.setRowFactory(tv -> {
            TableRow<Artikel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Verwijderen");
                    alert.setHeaderText("Zeker dat u dit artikel wilt verwijderen?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        int intId = row.getIndex();
                        winkel.getWinkelkar().removeArtikel(intId);
                    }
                }
            });
            return row ;
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

        btnOnHold = new Button("Zet huidig winkelwagentje on hold");
        btnOnHold.setOnAction(event -> {
            winkel.setOnHold();
        });
        btnOffHold = new Button("Haal vorig winkelwagentje terug");
        btnOffHold.setOnAction(event -> {
            winkel.setOffHold();
        });

        btnOffHold.setVisible(winkel.isOnHold());

        btnVerkoop = new Button("Reken winkelwagen af");
        btnVerkoop.setOnAction(event -> {
            winkel.verkoop();
        });

        VBox v1 = new VBox();
        v1.getChildren().addAll(txtInputId, lblTotaalPrijs, lblFout, btnOnHold, btnOffHold, btnVerkoop);

        HBox h1 = new HBox(10);
        h1.getChildren().addAll(table, v1);

        table.getColumns().setAll(colNaam,  colPrijs);
        this.add(new Label("Products:"), 0, 0, 1, 1);

        this.getChildren().addAll(h1);
    }

    public void setlijst(ArrayList<Artikel> artikels){
        table.setItems(FXCollections.observableArrayList(artikels ));
    }

    public void setLblTotaalPrijs(String tekst){
        lblTotaalPrijs.setText(tekst);
    }

    public void setButtons(){
        btnOffHold.setVisible(winkel.isOnHold());
        btnOnHold.setVisible(!winkel.isOnHold());
    }
}
