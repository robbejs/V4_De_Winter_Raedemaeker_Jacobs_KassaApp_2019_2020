package model.observer;
import model.Artikel;
import java.util.ArrayList;

/**
 * @Author We hebben alles samen gedaan
 **/

public interface Observer {
    public void update(ArrayList<Artikel> artikels);
}
