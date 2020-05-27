package view.panels.instellingen;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Winkel;

public class TicketPane extends GridPane{

    private Label lblAlgemeneHeader;
    private Label lblAlgemeneFooter;
    private TextField txtAlgemeneHeader;
    private TextField txtAlgemeneFooter;
    private Label lblDatumEnTijd;
    private Label lblTotalePrijs;
    private Label lblBTW;
    private RadioButton rdbDatumEnTijd;
    private RadioButton rdbTotalePrijs;
    private RadioButton rdbBTW;
    private Label lblTitle;
    private Button btnSave;

    public TicketPane(Winkel winkel){
        lblTitle = new Label("Kies hier welke headers of footers u wilt gebruiken");
        lblTitle.setStyle("-fx-font: 24 arial;");
        HBox htitle = new HBox();
        htitle.setAlignment(Pos.CENTER);
        htitle.getChildren().add(lblTitle);

        HBox h1 = new HBox(18);
        lblAlgemeneHeader = new Label("Algemene header ingeven:");
        txtAlgemeneHeader = new TextField();
        h1.getChildren().addAll(lblAlgemeneHeader, txtAlgemeneHeader);

        HBox h2 = new HBox(18);
        lblDatumEnTijd = new Label("Datum en tijd dat bon is afgedrukt");
        rdbDatumEnTijd = new RadioButton();
        h2.getChildren().addAll(lblDatumEnTijd, rdbDatumEnTijd);

        HBox h3 = new HBox(18);
        lblAlgemeneFooter = new Label("Algemene footer ingeven:");
        txtAlgemeneFooter = new TextField();
        h3.getChildren().addAll(lblAlgemeneFooter, txtAlgemeneFooter);

        HBox h4 = new HBox(18);
        lblTotalePrijs = new Label("De totale prijs");
        rdbTotalePrijs = new RadioButton();
        h4.getChildren().addAll(lblTotalePrijs, rdbTotalePrijs);

        HBox h5 = new HBox(18);
        lblBTW = new Label("De totale BTW");
        rdbBTW = new RadioButton();
        h5.getChildren().addAll(lblBTW, rdbBTW);

        btnSave = new Button("Save");

        VBox v1 = new VBox(35);
        v1.setMargin(htitle, new Insets(10, 0, 0, 20));
        v1.setMargin(h1, new Insets(0, 0, 0, 20));
        v1.setMargin(h2, new Insets(0, 0, 0, 20));
        v1.setMargin(h3, new Insets(0, 0, 0, 20));
        v1.setMargin(h4, new Insets(0, 0, 0, 20));
        v1.setMargin(h5, new Insets(0, 0, 0, 20));
        v1.setMargin(btnSave, new Insets(0, 0, 0, 20));
        v1.getChildren().addAll(htitle, h1,h2,h3,h4,h5, btnSave);

        btnSave.setOnAction(event -> {
            if(!txtAlgemeneHeader.getText().trim().isEmpty()){
                winkel.getKortingProperties().Save("ALGEMENEHEADER",txtAlgemeneHeader.getText(), winkel.getProperties());
            }else{
                winkel.getKortingProperties().Save("ALGEMENEHEADER","", winkel.getProperties());
            }

            if(!txtAlgemeneFooter.getText().trim().isEmpty()){
                winkel.getKortingProperties().Save("ALGEMENEFOOTER",txtAlgemeneFooter.getText(), winkel.getProperties());
            }else{
                winkel.getKortingProperties().Save("ALGEMENEFOOTER","", winkel.getProperties());
            }

            if(rdbTotalePrijs.isSelected()){
                winkel.getKortingProperties().Save("TOTAALPRIJSFOOTER","true", winkel.getProperties());
            }else{
                winkel.getKortingProperties().Save("TOTAALPRIJSFOOTER","false", winkel.getProperties());
            }

            if(rdbBTW.isSelected()){
                winkel.getKortingProperties().Save("FOOTERBTW","true", winkel.getProperties());
            }else{
                winkel.getKortingProperties().Save("FOOTERBTW","false", winkel.getProperties());
            }

            if(rdbDatumEnTijd.isSelected()){
                winkel.getKortingProperties().Save("DATUMENTIJDHEADER","true", winkel.getProperties());
            }else{
                winkel.getKortingProperties().Save("DATUMENTIJDHEADER","false", winkel.getProperties());
            }
        });

        this.getChildren().addAll(v1);
    }
}
