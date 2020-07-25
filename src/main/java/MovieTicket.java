


public class MovieTicket implements Ticket {

    private double price;
    private MovieScreening screening;

    private long auditoriumNumber;
    private int rowNumber;
    private int seatNumber;

    public MovieTicket(MovieScreening screening, long auditoriumNumber, int row, int seatInRow, double price) {

        this.screening = screening;
        this.auditoriumNumber = auditoriumNumber;
        this.rowNumber = row;
        this.seatNumber = seatInRow;
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }

    public EntertainmentEvent getEvent() {
        return this.screening;
    }

    @Override
    public String getEventDetails() {
        return this.screening.getDescription(); // TODO to add description of seats
    }

}
