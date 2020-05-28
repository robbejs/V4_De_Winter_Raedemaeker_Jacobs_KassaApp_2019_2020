package model.decorator;
import java.time.LocalDateTime;

/**
 * @Author We hebben alles samen gedaan
 **/

public class DatumEnTijdHeader extends TicketDecorator {

    public Ticket ticket;

    public DatumEnTijdHeader(Ticket ticket){
        this.ticket = ticket;
    }

    @Override
    public String getTekst() {
        return LocalDateTime.now().toString() + "\n************************************\n" + ticket.getTekst();
    }
}
