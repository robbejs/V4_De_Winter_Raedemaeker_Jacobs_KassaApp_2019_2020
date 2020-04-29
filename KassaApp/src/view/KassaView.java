package view;
import controller.KassaController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.LoadSaveProperties;
import model.Winkelkar;
import model.database.ArtikelDB;
import view.panels.KassaOverviewPane;

public class KassaView {
	private Stage stage = new Stage();		
		
	public KassaView(ArtikelDB artikelDB){
		stage.setTitle("KASSA VIEW");
		stage.setResizable(false);		
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 750, 500);



		BorderPane borderPane = new KassaMainPane(artikelDB);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
