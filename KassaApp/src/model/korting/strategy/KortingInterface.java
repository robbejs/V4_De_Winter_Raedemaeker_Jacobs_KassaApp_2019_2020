package model.korting.strategy;
import model.Artikel;
import java.util.ArrayList;

/**
 * @Author We hebben alles samen gedaan
 **/

public interface KortingInterface {
    public double berekenKorting(ArrayList<Artikel> artikels);
    public void setPrijs(double prijs);
    public void setPercentage(double percentage);
}
