package view.panels;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import model.KortingProperties;
import model.Winkel;
import model.database.LoadSaveProperties;
import view.panels.instellingen.BestandPane;
import view.panels.instellingen.KortingPane;

public class InstellingOverviewPane extends BorderPane {
    private LoadSaveProperties properties = new LoadSaveProperties();
    private KortingProperties kortingProperties = new KortingProperties();

    public InstellingOverviewPane(Winkel winkel){
        TabPane tabPane = new TabPane();
        BestandPane db = new BestandPane(winkel);
        Tab dbT = new Tab("Database", db);
        KortingPane kortingPane = new KortingPane(winkel);
        Tab kortingT = new Tab("Kortingen", kortingPane);
        tabPane.getTabs().add(dbT);
        tabPane.getTabs().add(kortingT);

        this.setCenter(tabPane);
    }
}
