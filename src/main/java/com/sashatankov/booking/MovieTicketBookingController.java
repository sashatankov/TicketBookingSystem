package com.sashatankov.booking;

import com.sashatankov.events.Auditorium;
import com.sashatankov.events.MovieAuditoriumController;
import com.sashatankov.events.MovieScreening;
import com.sashatankov.events.MovieScreeningsController;
import com.sashatankov.events.exceptions.SeatIsBookedException;
import com.sashatankov.events.exceptions.SeatOutOfBoundsException;
import com.sashatankov.events.exceptions.VenueNotFoundException;



/**
 * a controller class that books tickets for movies screenings
 */
public class MovieTicketBookingController {

    private static final String MOVIE_SCREENING_VENUE_NOT_FOUND_MEGGAGE = "Venue not found for Movie Screening: ";

    private MovieScreeningsController screenings;
    private MovieAuditoriumController seatings;
    private PaymentController ticketPayment;  // TODO to figure out what to do with pay-controller, maybe put in MovieTheaterModel

    /**
     * a constructor for the class
     * @param screeningsController a controller that holds and schedules the movie screenings
     */
    public MovieTicketBookingController(MovieScreeningsController screeningsController) {

        this.screenings = screeningsController;
        this.seatings = new MovieAuditoriumController();

    }

    /**
     * books a ticket for a specified movie screening
     * @param screening a movie screening to book the ticket to
     * @param row a row in the auditorium to book the ticket for
     * @param seatInRow a seat in a row in the auditorium to book the ticket for
     * @return a ticket
     */
    public Ticket bookTicket(MovieScreening screening, int row, int seatInRow) throws SeatIsBookedException,
                                                                                      SeatOutOfBoundsException,
                                                                                      VenueNotFoundException {

        if(!this.seatings.auditoriumExist(screening))
            throw new VenueNotFoundException(MOVIE_SCREENING_VENUE_NOT_FOUND_MEGGAGE + screening.getName());

        Auditorium auditorium = this.seatings.getAuditorium(screening);
        auditorium.bookSeat(row, seatInRow);
        return new MovieTicket(screening, auditorium.getId(), row, seatInRow);

    }





}
