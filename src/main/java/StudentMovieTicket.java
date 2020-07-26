

public class StudentMovieTicket implements Ticket {

    private Ticket ticket;

    public StudentMovieTicket(MovieScreening screening, long auditoriumNumber, int row, int seatInRow) {
        this.ticket = new MovieTicket(screening, auditoriumNumber, row, seatInRow);

    }

    @Override
    public double getPrice() {
        return PaymentModel.STUDENT_TICKET_PRICE_USD;
    }

    @Override
    public EntertainmentEvent getEvent() {
        return this.ticket.getEvent();
    }

    @Override
    public String getEventDetails() {
        return this.ticket.getEventDetails();
    }
}
