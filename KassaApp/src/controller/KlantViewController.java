package controller;

import javafx.scene.control.TableView;
import model.Artikel;
import model.Winkelkar;
import model.observer.Observable;
import model.observer.Observer;
import view.panels.KlantMainPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class KlantViewController implements Observer {

    private Map<Artikel,Integer> artikelMap;
    private KlantMainPane view;

    public KlantViewController(Winkelkar winkelkar){
        artikelMap = new LinkedHashMap<>();
        winkelkar.createObserver(this);
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
        view.lblBedrag.setText(Double.toString(prijs));
    }

    public void setView(KlantMainPane view) {
        this.view = view;
    }
}
