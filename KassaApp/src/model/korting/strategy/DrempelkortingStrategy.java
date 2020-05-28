package model.korting.strategy;
import model.Artikel;
import java.util.ArrayList;

/**
 * @Author We hebben alles samen gedaan
 **/

public class DrempelkortingStrategy implements KortingInterface {

    private double prijs = 100;
    private double percentage = 0.05;

    @Override
    public double berekenKorting(ArrayList<Artikel> artikels) {

        double totaalPrijs = 0;

        for (Artikel a: artikels){
            totaalPrijs += a.getPrijs();
        }

        if (totaalPrijs > prijs){
            return totaalPrijs * percentage;
        }
        return 0;
    }

    @Override
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    @Override
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
