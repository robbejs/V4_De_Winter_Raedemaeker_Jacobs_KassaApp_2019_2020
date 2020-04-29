package view.panels;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.LoadSaveProperties;

import javax.swing.*;

public class InstellingOverviewPane extends GridPane {
    private LoadSaveProperties properties = new LoadSaveProperties();

    public InstellingOverviewPane(){

        ToggleGroup tg = new ToggleGroup();

        RadioButton btnExcel = new RadioButton("xls");
        RadioButton btnTextFile = new RadioButton("txt");

        btnExcel.setToggleGroup(tg);
        btnTextFile.setToggleGroup(tg);

        Button btnSave = new Button("Save");
        btnSave.setOnAction(event -> {
            RadioButton rb = (RadioButton)tg.getSelectedToggle();
            properties.Save(rb.getText());
        });

        VBox v1 = new VBox();

        v1.getChildren().addAll(btnExcel,btnTextFile, btnSave);
        this.getChildren().addAll(v1);
    }
}
