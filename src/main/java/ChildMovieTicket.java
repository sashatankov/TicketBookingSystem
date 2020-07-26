/**
 * class representing a movie ticket for a child
 */
public class ChildMovieTicket implements Ticket {

    private Ticket ticket;

    /**
     * a Constructor of the class
     * @param screening a movie screening, the ticket is for
     * @param auditoriumNumber number of the auditorium of the screening
     * @param row number of the row in the auditorium
     * @param seatInRow number of seat in the row
     */
    public ChildMovieTicket(MovieScreening screening, long auditoriumNumber, int row, int seatInRow) {
        this.ticket = new MovieTicket(screening, auditoriumNumber, row, seatInRow);
    }

    /**
     *
     * @return the price of a ticket for a child
     */
    @Override
    public double getPrice() {
        return PaymentModel.CHILD_TICKET_PRICE_USD;
    }

    /**
     *
     * @return an event object, the ticket is for
     */
    @Override
    public EntertainmentEvent getEvent() {
        return this.ticket.getEvent();
    }

    /**
     *
     * @return a string that contains the details of the event
     */
    @Override
    public String getEventDetails() {
        return this.ticket.getEventDetails();
    }
}
