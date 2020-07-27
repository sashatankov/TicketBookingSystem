package com.sashatankov.booking;

import com.sashatankov.events.EntertainmentEvent;
import com.sashatankov.events.MovieScreening;

/**
 * a movie ticket for a student
 */
public class StudentMovieTicket implements Ticket {

    private Ticket ticket;

    /**
     * a constructor that creates a movie ticket for a student
     * @param screening a movie screening the ticket is for
     * @param auditoriumNumber the number of the auditorium of the movie screening
     * @param row the number of row in the auditorium
     * @param seatInRow the seat number in the row
     */
    public StudentMovieTicket(MovieScreening screening, long auditoriumNumber, int row, int seatInRow) {
        this.ticket = new MovieTicket(screening, auditoriumNumber, row, seatInRow);

    }

    /**
     *
     * @return the price of a ticket for a student
     */
    @Override
    public double getPrice() {
        return PaymentModel.STUDENT_TICKET_PRICE_USD;
    }

    /**
     *
     * @return the movie screening the ticket is for
     */
    @Override
    public EntertainmentEvent getEvent() {
        return this.ticket.getEvent();
    }

    /**
     *
     * @return a string containing the details of the movie screening
     */
    @Override
    public String getEventDetails() {
        return this.ticket.getEventDetails();
    }
}
