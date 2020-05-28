package model.state;
import model.Winkelkar;

/**
 * @Author We hebben alles samen gedaan
 **/

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
    }

    @Override
    public void annuleerd() {
        this.winkelkar.setCurrentState(winkelkar.getActief());
    }
}
