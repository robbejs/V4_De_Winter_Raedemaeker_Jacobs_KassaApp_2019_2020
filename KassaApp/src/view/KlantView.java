package view;
import controller.KlantViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Winkel;
import model.Winkelkar;
import view.panels.KlantMainPane;

public class KlantView {
	private Stage stage = new Stage();		
	private KlantViewController klantViewController;

	public KlantView(Winkel winkel){

		this.klantViewController = new KlantViewController(winkel.getWinkelkar());
		stage.setTitle("KLANT VIEW");
		stage.setResizable(false);		
		stage.setX(775);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		KlantMainPane klantMainPane = new KlantMainPane();
		klantViewController.setView(klantMainPane);
		root.getChildren().add(klantMainPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
