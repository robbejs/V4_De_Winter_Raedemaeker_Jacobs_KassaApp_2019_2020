package view.panels;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import model.Artikel;
import java.util.Map;

public class KlantMainPane extends GridPane {

    private TableView<Map.Entry<Artikel, Integer>> table;
    private Label lblTootaalPrijs;
    private Label lblKorting;
    private Label lblBetaalPrijs;

    public KlantMainPane(){

        table = new TableView<>();

        this.add(new Label("Products:"), 0, 0, 1, 1);

        TableColumn<Map.Entry<Artikel, Integer>, String> column1 = new TableColumn<>("Naam");
        column1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Artikel, Integer>, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Artikel, Integer>, String> p) {
                return new SimpleStringProperty(p.getValue().getKey().getNaam());
            }
        });

        TableColumn<Map.Entry<Artikel, Integer>, String> column2 = new TableColumn<>("Aantal");
        column2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Artikel, Integer>, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Artikel, Integer>, String> p) {
                return new SimpleStringProperty(String.valueOf(p.getValue().getValue()));
            }
        });

        lblTootaalPrijs = new Label("Totaal te betalen");
        lblKorting = new Label("Korting");
        lblBetaalPrijs = new Label("Te betalen bedrag");

        table.getColumns().add(column1);
        table.getColumns().add(column2);


        this.add(table,0,0);

        VBox v1 = new VBox(8);
        v1.getChildren().addAll(lblTootaalPrijs, lblKorting, lblBetaalPrijs);

        this.add(v1,1,0);
    }

    public void setTable(Map<Artikel, Integer> table) {
        ObservableList<Map.Entry<Artikel,Integer>> test = FXCollections.observableArrayList(table.entrySet());
        this.table.setItems(test);
    }

    public void setLblTootaalPrijs(String lblTootaalPrijs) {
        this.lblTootaalPrijs.setText(lblTootaalPrijs);
    }

    public void setLblKorting(String lblKorting) {
        this.lblKorting.setText(lblKorting);
    }

    public void setLblBetaalPrijs(String lblBetaalPrijs) {
        this.lblBetaalPrijs.setText(lblBetaalPrijs);
    }
}
