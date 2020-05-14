package model.state;
import model.Artikel;
import model.Winkelkar;

public class Actief implements StateInterface {

    private Winkelkar winkelkar;

    public Actief(Winkelkar winkelkar){
        this.winkelkar = winkelkar;
    }

    @Override
    public void sluitAf() {
        this.winkelkar.setCurrentState(this.winkelkar.getAfsluit());
    }

    @Override
    public void onHold() {
        this.winkelkar.setCurrentState(this.winkelkar.getOnHold());
    }

    @Override
    public void voegArtikelToe(Artikel artikel) {
        this.winkelkar.getWinkelwagen().add(artikel);
        this.winkelkar.setTotaalPrijs(this.winkelkar.getTotaalPrijs() + artikel.getPrijs());
    }

    @Override
    public void verwijderArtikel(int id) {
        this.winkelkar.setTotaalPrijs(this.winkelkar.getTotaalPrijs() - this.winkelkar.getWinkelwagen().get(id).getPrijs());
        this.winkelkar.getWinkelwagen().remove(id);
    }
}
