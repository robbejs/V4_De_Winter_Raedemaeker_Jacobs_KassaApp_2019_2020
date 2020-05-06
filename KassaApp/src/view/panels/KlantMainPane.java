package view.panels;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import model.Artikel;
import java.util.Map;

public class KlantMainPane extends GridPane {

    private TableView<Map.Entry<Artikel, Integer>> table;
    public Label lblBedrag;

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

        lblBedrag = new Label("Totaal te betalen");

        table.getColumns().add(column1);
        table.getColumns().add(column2);

        this.add(table,0,0);
        this.add(lblBedrag,1,0);
    }

    public void setTable(Map<Artikel, Integer> table) {
        ObservableList<Map.Entry<Artikel,Integer>> test = FXCollections.observableArrayList(table.entrySet());
        this.table.setItems(test);
    }
}
