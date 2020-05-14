package controller;
import model.Artikel;
import model.Winkelkar;
import model.observer.Observer;
import view.panels.KlantMainPane;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class KlantViewController implements Observer {

    private Map<Artikel,Integer> artikelMap;
    private KlantMainPane view;
    private Winkelkar winkelkar;

    public KlantViewController(Winkelkar winkelkar){
        artikelMap = new LinkedHashMap<>();
        winkelkar.createObserver(this);
        this.winkelkar = winkelkar;
    }

    @Override
    public void update(ArrayList<Artikel> artikels) {
        artikelMap.clear();
        double prijs = 0;
        for (Artikel a:artikels){
            if (!artikelMap.containsKey(a)){
                artikelMap.put(a,1);
                prijs+= a.getPrijs();
            }else{
                artikelMap.put(a,artikelMap.get(a)+1);
                prijs+= a.getPrijs();
            }
        }
        view.setTable(artikelMap);
        view.setLblTootaalPrijs((Double.toString(prijs)));
        view.setLblKorting((Double.toString(winkelkar.getKortingInterface().berekenKorting(artikels))));
        view.setLblBetaalPrijs((Double.toString(prijs - winkelkar.getKortingInterface().berekenKorting(artikels))));
    }

    public void setView(KlantMainPane view) {
        this.view = view;
    }

}
