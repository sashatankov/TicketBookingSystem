import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieTicketBookingController {


    private MovieScreeningsController screenings;
    private Map<MovieScreening, Auditorium> screeningSeating;
    private static final double DEFAULT_TICKET_PRICE = 50;

    public MovieTicketBookingController(MovieScreeningsController screeningsController) {
        this.screenings = screeningsController;
        this.screeningSeating = new HashMap<>();
    }


    public Ticket bookTicket(MovieScreening screening, int row, int seatInRow) {


        Auditorium auditorium = this.screeningSeating.get(screening);

        if(auditorium.isSeatEmpty(row, seatInRow)){
            auditorium.bookSeat(row, seatInRow);
        }

        return new MovieTicket(screening,
                auditorium.getAuditoriumnumber(),
                row, seatInRow, DEFAULT_TICKET_PRICE);

    }





}
