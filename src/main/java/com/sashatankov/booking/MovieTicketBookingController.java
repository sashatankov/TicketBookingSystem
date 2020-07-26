package com.sashatankov.booking;

import com.sashatankov.events.Auditorium;
import com.sashatankov.events.MovieScreening;
import com.sashatankov.events.MovieScreeningsController;

import java.util.HashMap;
import java.util.Map;

public class MovieTicketBookingController {


    private MovieScreeningsController screenings;
    private Map<MovieScreening, Auditorium> screeningSeating;
    private PaymentController ticketPayment;  // TODO to figure out what to do with pay-controller

    public MovieTicketBookingController(MovieScreeningsController screeningsController) {
        this.screenings = screeningsController;
        this.screeningSeating = new HashMap<>();
    }


    public Ticket bookTicket(MovieScreening screening, int row, int seatInRow) {

        if(this.screeningSeating.containsKey(screening)) {
            Auditorium auditorium = this.screeningSeating.get(screening);
            if(auditorium.isSeatEmpty(row, seatInRow)){
                auditorium.bookSeat(row, seatInRow);
                return new MovieTicket(screening,
                        auditorium.getId(),
                        row, seatInRow);
            }
        }
        return null; // TODO to throw an exception instead of returning null;
    }





}
