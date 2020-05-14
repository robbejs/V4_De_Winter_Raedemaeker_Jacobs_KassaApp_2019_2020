package view.panels.instellingen;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Winkel;

public class KortingPane extends GridPane {

    public KortingPane(Winkel winkel){
        ToggleGroup tg2 = new ToggleGroup();

        RadioButton btnGroepsKorting = new RadioButton("groepskorting");
        RadioButton btnDrempelKorting = new RadioButton("drempelkorting");
        RadioButton btnDuursteKorting = new RadioButton("duurstekorting");

        btnGroepsKorting.setToggleGroup(tg2);
        btnDrempelKorting.setToggleGroup(tg2);
        btnDuursteKorting.setToggleGroup(tg2);

        Label lblPercentage = new Label("Kortings percentage:");
        TextField txtPercentage = new TextField();
        Label lblPrijs = new Label("Prijs te overschrijden:");
        lblPrijs.setVisible(false);
        TextField txtPrijs = new TextField();
        txtPrijs.setVisible(false);

        btnDrempelKorting.setOnAction(event -> {
            lblPrijs.setVisible(true);
            txtPrijs.setVisible(true);
        });

        btnDuursteKorting.setOnAction(event -> {
            lblPrijs.setVisible(false);
            txtPrijs.setVisible(false);
        });

        btnGroepsKorting.setOnAction(event -> {
            lblPrijs.setVisible(false);
            txtPrijs.setVisible(false);
        });

        VBox v1 = new VBox(8);
        v1.getChildren().addAll(lblPercentage, txtPercentage, lblPrijs, txtPrijs);

        Button btnSave = new Button("Save");
        btnSave.setOnAction(event -> {
            RadioButton rb2 = (RadioButton)tg2.getSelectedToggle();
            winkel.getKortingProperties().Save("KORTING", rb2.getText(), winkel.getProperties());
            if (!txtPrijs.getText().isEmpty()){
                winkel.getKortingProperties().Save("PRIJS", txtPrijs.getText(), winkel.getProperties());
            }
            if (!txtPercentage.getText().isEmpty()){
                winkel.getKortingProperties().Save("PERCENTAGE", txtPercentage.getText(), winkel.getProperties());
            }

        });

        VBox v2 = new VBox(8);
        v2.getChildren().addAll(btnGroepsKorting,btnDuursteKorting,btnDrempelKorting,btnSave);

        HBox h1 = new HBox(8);
        h1.getChildren().addAll(v2,v1);

        this.getChildren().addAll(h1);
    }
}
