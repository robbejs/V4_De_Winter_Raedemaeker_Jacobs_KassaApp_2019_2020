package model.state;
import model.Winkelkar;

public class Afsluit implements StateInterface {

    private Winkelkar winkelkar;

    public Afsluit(Winkelkar winkelkar){
        this.winkelkar = winkelkar;
    }

    @Override
    public void open() {
        this.winkelkar.setCurrentState(winkelkar.getActief());
    }

    @Override
    public void betaald() {
        this.winkelkar.setCurrentState(winkelkar.getBetaald());
        System.out.println(winkelkar.getBetaald());
    }

    @Override
    public void annuleerd() {
        this.winkelkar.setCurrentState(winkelkar.getActief());
    }
}
