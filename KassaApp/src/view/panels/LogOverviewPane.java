package view.panels;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class LogOverviewPane extends GridPane {
    private Label lblLog;

    public LogOverviewPane(){
        lblLog = new Label();

        this.getChildren().addAll(lblLog);
    }

    public void setLblLog(String lblLog) {
        this.lblLog.setText(this.lblLog.getText() + "\n" + lblLog);
    }
}
