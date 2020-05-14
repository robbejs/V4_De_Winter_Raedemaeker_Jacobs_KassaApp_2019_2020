package model.strategy;
import model.Artikel;
import java.util.ArrayList;

public class GroepskortingStrategy implements KortingInterface {

    private double percentage = 0.05;

    @Override
    public double berekenKorting(ArrayList<Artikel> artikels) {

        double totaalKorting = 0;

        for (Artikel a: artikels){
            if (a.getGroep().equalsIgnoreCase("gr1")){
                totaalKorting += a.getPrijs() * percentage;
            }
        }

        return totaalKorting;
    }

    @Override
    public void setPrijs(double prijs) {

    }

    @Override
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }


}
