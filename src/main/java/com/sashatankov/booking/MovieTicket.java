package com.sashatankov.booking;

import com.sashatankov.events.EntertainmentEvent;
import com.sashatankov.events.MovieScreening;

/**
 * A movie Ticket in a movie theater
 */
public class MovieTicket implements Ticket {

    private MovieScreening screening;
    private long auditoriumNumber;
    private int rowNumber;
    private int seatNumber;

    /**
     * a constructor that creates a movie ticket for a specified movie screening
     * @param screening a movie screening
     * @param auditoriumNumber the number of the auditorium of the screening
     * @param row the row number in the auditorium
     * @param seatInRow the number of the seat in the row
     */
    public MovieTicket(MovieScreening screening, long auditoriumNumber, int row, int seatInRow) {

        this.screening = screening;
        this.auditoriumNumber = auditoriumNumber;
        this.rowNumber = row;
        this.seatNumber = seatInRow;

    }

    /**
     *
     * @return the price of the ticket
     */
    @Override
    public double getPrice() {
        return PaymentModel.ADULT_TICKET_PRICE_USD;
    }

    /**
     *
     * @return the movie screening the ticket is for
     */
    @Override
    public EntertainmentEvent getEvent() {
        return this.screening;
    }

    /**
     *
     * @return the details of the movie screening
     */
    @Override
    public String getEventDetails() {
        return this.screening.toString(); // TODO to add description of seats
    }

}
