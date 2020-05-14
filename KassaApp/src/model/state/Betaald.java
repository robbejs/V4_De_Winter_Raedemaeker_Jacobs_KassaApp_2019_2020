package model.state;
import model.Artikel;
import model.Winkelkar;

public class Betaald implements StateInterface {

    private Winkelkar winkelkar;

    public Betaald(Winkelkar winkelkar){
        this.winkelkar = winkelkar;
    }

    @Override
    public void voegArtikelToe(Artikel artikel) {
        this.winkelkar.setCurrentState(this.winkelkar.getActief());
        this.winkelkar.getWinkelwagen().add(artikel);
        this.winkelkar.setTotaalPrijs(this.winkelkar.getTotaalPrijs() + artikel.getPrijs());
    }

    @Override
    public void onHold() {
        this.winkelkar.setCurrentState(this.winkelkar.getOnHold());
    }

    @Override
    public void offHold() {
        this.winkelkar.setCurrentState(this.winkelkar.getActief());
    }
}
