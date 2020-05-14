package view.panels.instellingen;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Winkel;

public class BestandPane extends GridPane {

    public BestandPane(Winkel winkel){
        ToggleGroup tg1 = new ToggleGroup();

        RadioButton btnExcel = new RadioButton("xls");
        RadioButton btnTextFile = new RadioButton("txt");

        btnExcel.setToggleGroup(tg1);
        btnExcel.setSelected(winkel.getLoadSaveProperties().isXls());
        btnTextFile.setToggleGroup(tg1);
        btnTextFile.setSelected(winkel.getLoadSaveProperties().isTxt());



        Button btnSave = new Button("Save");
        btnSave.setOnAction(event -> {
            RadioButton rb1 = (RadioButton)tg1.getSelectedToggle();
            winkel.getLoadSaveProperties().Save(rb1.getText(), winkel.getProperties());
        });

        VBox v1 = new VBox();
        v1.getChildren().addAll(btnTextFile, btnExcel, btnSave);

        this.getChildren().addAll(v1);
    }

}
