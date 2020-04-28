package application;
import javafx.application.Application;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;
import model.BestandSoortEnum;
import model.BestandSoortFactory;
import model.LoadSaveInterface;
import model.database.ArtikelDB;
import view.KassaView;
import view.KlantView;
import java.io.File;
import java.io.IOException;

public class KassaAppMain extends Application {
	ArtikelDB  artikelDB = new ArtikelDB();
	private File file = new File("src/bestanden/artikel.xls");

 private LoadSaveInterface loadSaveInterface = BestandSoortFactory.createSoort("EXCEL");

	@Override
	public void start(Stage primaryStage) throws IOException, BiffException {
		loadSaveInterface.Load(file, artikelDB);
		KassaView kassaView = new KassaView(artikelDB);
		KlantView klantView = new KlantView();
		System.out.println(artikelDB.getArtikelsString());
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	/*@Override
	public void stop(){
		loadSaveInterface.Save(file,artikelDB);
	}*/
}
