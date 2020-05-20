package application;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Winkel;
import view.KassaView;
import view.KlantView;

public class KassaAppMain extends Application {
	private Winkel winkel;

	@Override
	public void start(Stage primaryStage){
		this.winkel = new Winkel();
		KassaView kassaView = new KassaView(winkel);
		KlantView klantView = new KlantView(winkel);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
