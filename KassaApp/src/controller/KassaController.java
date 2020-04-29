package controller;


import model.Artikel;
import model.Observer;
import model.Winkelkar;
import view.panels.KassaOverviewPane;

import java.util.ArrayList;

public class KassaController implements Observer {

    private KassaOverviewPane view;

    public KassaController(Winkelkar model) {
        model.createObserver(this);
    }

    // called by the view
    public void setView(KassaOverviewPane view) {
        this.view = view;
    }

    @Override
    public void update(ArrayList<Artikel> artikels) {
        System.out.println(artikels.get(0));
        view.setArraylist(artikels);
    }
}
