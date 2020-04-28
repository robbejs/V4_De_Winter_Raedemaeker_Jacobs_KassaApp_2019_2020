package view.panels;

import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import model.Artikel;
import model.database.ArtikelDB;

public class KassaOverviewPane extends GridPane {

    private TableView<Artikel> table = new TableView<Artikel>();

    public KassaOverviewPane(ArtikelDB artikelDB){


    }
}
