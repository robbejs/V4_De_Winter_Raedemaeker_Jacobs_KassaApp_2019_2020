package model;

import model.database.ArtikelDB;
import model.database.LoadSaveInterface;
import model.database.LoadSaveProperties;
import model.database.factory.BestandSoortFactory;

public class Winkel {
    private Winkelkar winkelkar, winkelkarOnHold;
    private ArtikelDB artikelDB;
    private LoadSaveProperties properties = new LoadSaveProperties();
    private LoadSaveInterface loadSaveInterface = BestandSoortFactory.createSoort(properties.Load());
    private int teller = 0;
    private boolean onHold = false;

    public Winkel(){
        winkelkar = new Winkelkar();
        winkelkarOnHold = new Winkelkar();
        artikelDB = new ArtikelDB();
        loadSaveInterface.Load(artikelDB);
    }

    public void stop(){
        loadSaveInterface.Save(artikelDB);
    }


    public void setOnHold(){
        if (!winkelkar.getWinkelwagen().isEmpty()){
            for (Artikel a:winkelkar.getWinkelwagen()){
                winkelkarOnHold.addArtikel(a);
            }
            winkelkar.clear();
            onHold = true;
            winkelkar.notifyObserver();
            teller = 0;
        }

    }

    public void setOffHold(){

        if (winkelkar.getWinkelwagen().isEmpty()){
            for (Artikel a:winkelkarOnHold.getWinkelwagen()){
                winkelkar.addArtikel(a);
            }
            winkelkarOnHold.clear();
            onHold = false;
            winkelkar.notifyObserver();
        }
    }

    public void verkoop(){
        if (onHold){
            teller ++;
            if (teller == 3){
                winkelkarOnHold.clear();
                teller = 0;
                onHold = false;
            }
        }
        winkelkar.clear();
    }

    public void setWinkelkar(Winkelkar winkelkar) {
        this.winkelkar = winkelkar;
    }

    public void setWinkelkarOnHold(Winkelkar winkelkarOnHold) {
        this.winkelkarOnHold = winkelkarOnHold;
    }

    public void setArtikelDB(ArtikelDB artikelDB) {
        this.artikelDB = artikelDB;
    }

    public Winkelkar getWinkelkar() {
        return winkelkar;
    }

    public Winkelkar getWinkelkarOnHold() {
        return winkelkarOnHold;
    }

    public ArtikelDB getArtikelDB() {
        return artikelDB;
    }

    public boolean isOnHold() {
        return onHold;
    }
}
