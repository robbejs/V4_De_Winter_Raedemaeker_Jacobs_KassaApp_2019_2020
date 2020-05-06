package application;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Winkel;
import model.Winkelkar;
import model.database.factory.BestandSoortFactory;
import model.database.LoadSaveInterface;
import model.database.LoadSaveProperties;
import model.database.ArtikelDB;
import view.KassaView;
import view.KlantView;

public class KassaAppMain extends Application {
	private Winkel winkel;

	@Override
	public void start(Stage primaryStage){
		this.winkel = new Winkel();
		KassaView kassaView = new KassaView(winkel);
		KlantView klantView = new KlantView(winkel);
		System.out.println(winkel.getArtikelDB().getArtikelsString());
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void stop() {
		winkel.stop();
	}
}
