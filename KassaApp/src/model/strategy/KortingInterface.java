package model.strategy;
import model.Artikel;
import java.util.ArrayList;

public interface KortingInterface {
    public double berekenKorting(ArrayList<Artikel> artikels);
    public void setPrijs(double prijs);
    public void setPercentage(double percentage);
}
