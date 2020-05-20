package model;
import javafx.scene.control.Alert;
import model.database.ArtikelDB;
import model.database.strategy.LoadSaveInterface;
import model.database.LoadSaveProperties;
import model.database.factory.BestandSoortFactory;
import model.decorator.*;
import model.factory.KortingFactory;
import model.strategy.KortingInterface;

import java.util.Properties;

public class Winkel {
    private Properties properties = new Properties();
    private Winkelkar winkelkar, winkelkarOnHold;
    private ArtikelDB artikelDB;
    private LoadSaveProperties loadSaveProperties = new LoadSaveProperties();
    private KortingProperties kortingProperties = new KortingProperties();
    private LoadSaveInterface loadSaveInterface = BestandSoortFactory.createSoort(loadSaveProperties.Load(properties));
    private KortingInterface kortingInterface = KortingFactory.createKorting(kortingProperties.Load("KORTING"));
    private int teller = 0;

    public Winkel(){
        winkelkar = new Winkelkar();
        winkelkar.setKortingInterface(kortingInterface);
        winkelkarOnHold = new Winkelkar();
        artikelDB = new ArtikelDB();
        loadSaveInterface.Load(artikelDB);

    }

    public void setOnHold(){
        teller = 0;
        for (Artikel a:winkelkar.getWinkelwagen()){
            winkelkarOnHold.addArtikel(a);
        }
        winkelkarOnHold.onHold();
        winkelkar.setCurrentState(winkelkar.getBetaald());
        this.winkelkar.clear();
    }

    public void setOffHold(){
        winkelkarOnHold.offHold();
        for (Artikel a:winkelkarOnHold.getWinkelwagen()){
            winkelkar.addArtikel(a);
        }
        winkelkarOnHold.clear();
    }

    public void betaal(){
        Ticket ticket = new TicketSetter(winkelkar);
        String totaalPrijsFooter = kortingProperties.Load("TOTAALPRIJSFOOTER");
        String footerBTW = kortingProperties.Load("FOOTERBTW");
        String datumHeader = kortingProperties.Load("DATUMENTIJDHEADER");
        String algemeneHeader = kortingProperties.Load("ALGEMENEHEADER");
        String algemeneFooter = kortingProperties.Load("ALGEMENEFOOTER");

        if (totaalPrijsFooter.equalsIgnoreCase("true")){
            ticket = new TotaalPrijsFooter(ticket, winkelkar);
        }

        if (footerBTW.equalsIgnoreCase("true")){
            ticket = new BetaalPrijsFooterBTW(ticket, winkelkar.getWinkelwagen());
        }

        if (datumHeader.equalsIgnoreCase("true")){
            ticket = new DatumEnTijdHeader(ticket);
        }

        if (!algemeneFooter.isEmpty()){
            ticket = new AlgemeneFooter(ticket, algemeneFooter);
        }

        if (!algemeneHeader.isEmpty()){
            ticket = new AlgemeneHeader(ticket, algemeneHeader);
        }

        System.out.println(ticket.getTekst());
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText((ticket.getTekst()));
        a.show();

        if (winkelkarOnHold.getCurrentState() == winkelkarOnHold.getOnHold()){
            teller ++;
            if (teller == 3){
                teller = 0;
                winkelkarOnHold.offHold();
                winkelkarOnHold.clear();
            }
        }
        winkelkar.betaald();
        winkelkar.clear();
    }

    public void verkoop(){
        winkelkar.sluitAf();
    }

    public void open(){
        winkelkar.setCurrentState(winkelkar.getActief());
    }

    public void annuleer() {
        winkelkar.setCurrentState(winkelkar.getActief());
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

    public KortingProperties getKortingProperties() {
        return kortingProperties;
    }

    public LoadSaveProperties getLoadSaveProperties() {
        return loadSaveProperties;
    }

    public Properties getProperties() {
        return properties;
    }

    public LoadSaveInterface getLoadSaveInterface() {
        return loadSaveInterface;
    }

    public KortingInterface getKortingInterface() {
        return kortingInterface;
    }

    public int getTeller() {
        return teller;
    }
}
