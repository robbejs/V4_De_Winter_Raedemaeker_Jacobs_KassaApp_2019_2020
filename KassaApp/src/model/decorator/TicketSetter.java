package model.decorator;

import model.Artikel;
import model.Winkelkar;

import java.util.ArrayList;

public class TicketSetter extends Ticket{

    private ArrayList<Artikel>artikels;
    private String result = "";

    public TicketSetter(Winkelkar winkelkar) {
        this.artikels = winkelkar.getWinkelwagen();
        int teller = 0;
        double prijs = 0;
        result = "Omschrijving\t\tAantal\tPrijs\n************************************\n";
        for (Artikel a1: artikels){
            if (!result.contains(a1.getNaam())){
                for (Artikel a: artikels){
                    if (a.getNaam() == a1.getNaam()){
                        teller ++;
                        prijs += a.getPrijs();
                    }
                }
                result += a1.getNaam() + "\t\t\t" + teller +"\t\t" + prijs + "\n";
                teller = 0;
                prijs = 0;
            }
        }
        result += "************************************\nBetaald (inclusief korting): €" + (winkelkar.getTotaalPrijs() - winkelkar.getKortingInterface().berekenKorting(winkelkar.getWinkelwagen())) + "\n";
    }

    public String getTekst(){
        return result;
    }
}
