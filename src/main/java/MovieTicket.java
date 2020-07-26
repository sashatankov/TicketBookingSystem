


public class MovieTicket implements Ticket {

    private MovieScreening screening;

    private long auditoriumNumber;
    private int rowNumber;
    private int seatNumber;

    public MovieTicket(MovieScreening screening, long auditoriumNumber, int row, int seatInRow) {

        this.screening = screening;
        this.auditoriumNumber = auditoriumNumber;
        this.rowNumber = row;
        this.seatNumber = seatInRow;

    }

    @Override
    public double getPrice() {
        return PaymentModel.ADULT_TICKET_PRICE_USD;
    }

    @Override
    public EntertainmentEvent getEvent() {
        return this.screening;
    }

    @Override
    public String getEventDetails() {
        return this.screening.toString(); // TODO to add description of seats
    }

}
