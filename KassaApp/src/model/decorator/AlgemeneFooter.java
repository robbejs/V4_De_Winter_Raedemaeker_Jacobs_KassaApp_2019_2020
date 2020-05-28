package model.decorator;

/**
 * @Author We hebben alles samen gedaan
 **/

public class AlgemeneFooter extends TicketDecorator {

    private String tekst;
    private Ticket ticket;

    public AlgemeneFooter(Ticket ticket, String tekst){
        this.ticket = ticket;
        this.tekst = tekst;
    }

    @Override
    public String getTekst() {
        return ticket.getTekst() + "\n************************************\n" + tekst;
    }
}
