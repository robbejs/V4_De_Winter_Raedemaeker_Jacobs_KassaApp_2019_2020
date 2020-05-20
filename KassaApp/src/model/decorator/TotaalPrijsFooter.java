package model.decorator;
import model.Winkelkar;


public class TotaalPrijsFooter extends TicketDecorator {

    public Ticket ticket;
    private Winkelkar winkelkar;

    public TotaalPrijsFooter(Ticket ticket, Winkelkar winkelkar){
        this.ticket = ticket;
        this.winkelkar = winkelkar;
    }

    @Override
    public String getTekst() {
        return ticket.getTekst() + "************************************\nTotaalPrijs: " + winkelkar.getTotaalPrijs() + "\n************************************\nKorting: " +winkelkar.getKortingInterface().berekenKorting(winkelkar.getWinkelwagen());
    }
}
