package model.decorator;

import model.Artikel;

import java.util.ArrayList;

public class BetaalPrijsFooterBTW extends TicketDecorator {

    private ArrayList<Artikel> artikels;
    private Ticket ticket;

    public BetaalPrijsFooterBTW(Ticket ticket, ArrayList<Artikel> artikels){
        this.ticket = ticket;
        this.artikels = artikels;
    }

    @Override
    public String getTekst() {
        int btw = 0;
        int prijs = 0;
        for (Artikel a:artikels){
            btw += a.getPrijs()*0.06;
            prijs += a.getPrijs();
        }
        return ticket.getTekst() + "\n************************************\n" + "exclusief btw: €" + prijs + "\ninclusief btw: €" + (prijs + btw);
    }
}
