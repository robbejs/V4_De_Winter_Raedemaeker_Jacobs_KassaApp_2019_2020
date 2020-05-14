package model.strategy;
import model.Artikel;
import java.util.ArrayList;

public class DuurstekortingStrategy implements KortingInterface {

    private double percentage = 0.25;

    @Override
    public double berekenKorting(ArrayList<Artikel> artikels) {
        Artikel duursteArtikel = artikels.get(0);

        for (Artikel a: artikels){
            if (a.getPrijs() > duursteArtikel.getPrijs()){
                duursteArtikel = a;
            }
        }

        return duursteArtikel.getPrijs() * percentage;
    }

    @Override
    public void setPrijs(double prijs) {

    }

    @Override
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }


}
