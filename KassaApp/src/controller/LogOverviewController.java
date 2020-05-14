package controller;
import model.Artikel;
import model.Winkelkar;
import model.observer.Observer;
import view.panels.LogOverviewPane;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class LogOverviewController implements Observer {

    private Winkelkar winkelkar;
    private LogOverviewPane view;

    public LogOverviewController(Winkelkar winkelkar){
        this.winkelkar = winkelkar;
        winkelkar.createObserver(this);
    }

    @Override
    public void update(ArrayList<Artikel> artikels) {
        if (winkelkar.getCurrentState() == winkelkar.getAfsluit()){
            LocalDateTime datum = LocalDateTime.now();
            double totaalBedrag = winkelkar.getTotaalPrijs();
            double korting = winkelkar.getKortingInterface().berekenKorting(artikels);
            double betaalBedrag = totaalBedrag - korting;
            view.setLblLog(datum.toString() + ": Totaal bedrag: " + totaalBedrag + ", gekregen korting: " + korting + ", effectief te betalen bedrag: " + betaalBedrag);
        }
    }

    public void setView(LogOverviewPane view) {
        this.view = view;
    }
}
