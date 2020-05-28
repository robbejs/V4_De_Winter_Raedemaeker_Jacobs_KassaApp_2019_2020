package model.decorator;

/**
 * @Author We hebben alles samen gedaan
 **/

public class AlgemeneHeader extends TicketDecorator {
    private String tekst;
    private Ticket ticket;

    public AlgemeneHeader(Ticket ticket, String teskt){
        this.tekst = teskt;
        this.ticket = ticket;
    }

    @Override
    public String getTekst() {
        return tekst + "\n************************************\n" + ticket.getTekst() ;
    }
}
