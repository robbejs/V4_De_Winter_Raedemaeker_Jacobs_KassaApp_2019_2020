package controller;
import model.Artikel;
import model.Winkel;
import model.Winkelkar;
import model.observer.Observer;
import view.panels.ProductOverviewPane;
import java.util.ArrayList;

public class ProductOverviewController implements Observer {

    private Winkel winkel;
    private Winkelkar winkelkar;
    private ProductOverviewPane view;

    public ProductOverviewController(Winkelkar winkelkar, Winkel winkel){
        this.winkelkar = winkelkar;
        this.winkel = winkel;
        winkelkar.createObserver(this);
    }


    @Override
    public void update(ArrayList<Artikel> artikels) {
        if (winkelkar.getCurrentState() == winkelkar.getAfsluit()) {
            for (Artikel a : artikels) {
                int test = Integer.parseInt(winkel.getArtikelDB().getArtikel(a).getVoorraad());
                winkel.getArtikelDB().getArtikel(a).setVoorraad(Integer.toString(test - 1));
                System.out.println(winkel.getArtikelDB().getArtikel(a).getVoorraad());
            }
            view.setlijst(winkel.getArtikelDB().getArtikels());
            winkel.getLoadSaveInterface().Save(winkel.getArtikelDB());
        }
    }

    public void setView(ProductOverviewPane view) {
        this.view = view;
    }
}
