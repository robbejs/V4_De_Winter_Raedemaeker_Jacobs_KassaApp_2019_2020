package model.state;
import model.Winkelkar;

/**
 * @Author We hebben alles samen gedaan
 **/

public class OnHold implements StateInterface {

    private Winkelkar winkelkar;

        public OnHold(Winkelkar winkelkar){
            this.winkelkar=winkelkar;
        }

    @Override
    public void offHold() {
        this.winkelkar.setCurrentState(this.winkelkar.getActief());
    }
}
