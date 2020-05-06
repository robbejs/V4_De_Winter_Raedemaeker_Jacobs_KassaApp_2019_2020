package controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Artikel;
import model.observer.Observer;
import model.Winkelkar;
import view.panels.KassaOverviewPane;
import java.util.ArrayList;

public class KassaOverviewController implements Observer {

    private KassaOverviewPane view;
    private Winkelkar winkelkar;
    private Winkelkar onHoldKar;

    public KassaOverviewController(Winkelkar winkelkar) {
        winkelkar.createObserver(this);
        this.winkelkar = winkelkar;
        this.onHoldKar = new Winkelkar();
    }

    // called by the view
    public void setView(KassaOverviewPane view) {
        this.view = view;
    }

    public void setOnhold(Winkelkar winkelkar){
        this.onHoldKar = winkelkar;
    }

    @Override
    public void update(ArrayList<Artikel> artikels) {
        view.setlijst(artikels);
        view.setLblTotaalPrijs(Double.toString(winkelkar.getTotaalPrijs()));
        view.setButtons();
    }
}