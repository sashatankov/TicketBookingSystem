package com.sashatankov.events;

import com.sashatankov.events.exceptions.IllegalAuditoriumConstrains;
import com.sashatankov.events.exceptions.SeatIsBookedException;
import com.sashatankov.events.exceptions.SeatOutOfBoundsException;

import java.util.*;

/**
 * a Class representing a seating in am auditorium for a
 * particular event.
 */
public class Auditorium implements EventVenue {

    private static final String ILLEGAL_AUDITORIUM_NUMBER_MESSAGE = "Auditorium number must be positive, got ";
    private static final String ILLEGAL_NUMBER_OF_ROWS_MESSAGE = "Number of rows in auditorium must be positive, got ";
    private static final String ILLEGAL_NUMBER_OF_SEATS_IN_ROW = "Number of seats in row must be positive, got ";
    private static final String SEATS_ARRAY_IS_NULL = "SeatInRow array must not be null";

    private List<List<Boolean>> seats;
    private long auditoriumNumber;
    public static Set<Long> auditoriumNumbers = new HashSet<>();

    /**
     * A Constructor of the class that build an empty seating
     * in a particular auditorium. This constructor assumes that
     * all rows in the auditorium have the same number of seats
     *
     * @param auditoriumNumber an id of a particular auditorium
     * @param rows the number of rows in the auditorium
     * @param seatsInRow a number of seats in each row
     */
    public Auditorium(long auditoriumNumber, int rows, int seatsInRow) throws IllegalAuditoriumConstrains {

        this.verifyConstructorArguments(auditoriumNumber, rows, seatsInRow);
        auditoriumNumbers.add(auditoriumNumber);
        this.auditoriumNumber = auditoriumNumber;
        this.seats = new ArrayList<>();

        for(int i = 0; i < rows; ++i) {
            this.seats.add(new ArrayList<>());
            for(int j = 0; j < seatsInRow; ++j) {
                this.seats.get(i).add(false);
            }
        }

    }

    /**
     * a Constrouctor of the class that builds an empty seating
     * in a particular auditorium. This constructor is for auditoriums
     * where all rows do not have the same number of seats.
     * @param auditoriumNumber an id of a particular auditorium
     * @param seatsInRows an array on integer, the size of the array
     *                    is the number of rows. Each element of the
     *                    array represents the number of seats in that row.
     */
    public Auditorium(long auditoriumNumber, int[] seatsInRows) throws IllegalAuditoriumConstrains{

        this.verifyConstructorArguments(auditoriumNumber, seatsInRows);

        this.auditoriumNumber = auditoriumNumber;
        this.seats = new ArrayList<>();

        for(int i = 0; i < seatsInRows.length; ++i) {
            this.seats.add(new ArrayList<>());
            for(int j = 0; j < seatsInRows[i]; ++j) {
                this.seats.get(i).add(false);
            }
        }
    }

    /**
     *
     * @return the number of seats in the auditorium
     */
    @Override
    public long capacity() {

        int sum = 0;
        for(List<Boolean> row: seats)
            sum += row.size();
        return sum;

    }

    /**
     * check if a particular seat is empty in a seating
     * @param row row number
     * @param seatInRow number of seat in the row
     * @return true, if the seat is empty. false, otherwise
     */
    public boolean isSeatEmpty(int row, int seatInRow) throws SeatOutOfBoundsException {
        if(row <= 0 || row > this.seats.size() || seatInRow <= 0 || seatInRow > this.seats.get(row - 1).size())
            throw new SeatOutOfBoundsException();
        return !this.seats.get(row - 1).get(seatInRow - 1);

    }

    /**
     * reserves a seat in an auditorium, by marking it as occupied
     * @param row row number
     * @param seatInRow number of seat in a row
     * @throws SeatOutOfBoundsException if the row number and/or the seat number
     * do not match the constrains of the auditorium
     * @throws SeatIsBookedException if the seat is already booked.
     */
    public void bookSeat(int row, int seatInRow) throws SeatOutOfBoundsException, SeatIsBookedException {
        if(!this.isSeatEmpty(row, seatInRow))
            throw new SeatIsBookedException();
        this.seats.get(row - 1).remove(seatInRow - 1);
        this.seats.get(row - 1).add(seatInRow - 1, true);

    }

    /**
     *
     * @return the id of the auditorium
     */
    @Override
    public long getId(){
        return this.auditoriumNumber;
    }

    /**
     *
     * @return all ids of the auditoriums
     */
    public static Set<Long> getAllAuditoriumNumbers(){
        return auditoriumNumbers;
    }

    /**
     *
     * @return the name of the auditorium
     */
    @Override
    public String getName() {
        return "Auditorium " + this.getId();
    }

    /**
     * verifies the argumements are legal.
     *  - The auditorium number is a positive number.
     *  - the seatsInRow is an array of positive length and contains positive elements
     * @param auditoriumNumber
     * @param seatsInRows
     * @throws IllegalAuditoriumConstrains if one of the arguments violates one the constraines above
     */
    private void verifyConstructorArguments(long auditoriumNumber, int[] seatsInRows) throws IllegalAuditoriumConstrains {

        if(seatsInRows == null)
            throw new IllegalAuditoriumConstrains(SEATS_ARRAY_IS_NULL);
        if(auditoriumNumber <= 0)
            throw new IllegalAuditoriumConstrains(ILLEGAL_AUDITORIUM_NUMBER_MESSAGE + auditoriumNumber);
        if(seatsInRows.length == 0)
            throw new IllegalAuditoriumConstrains(ILLEGAL_NUMBER_OF_ROWS_MESSAGE + 0);

        for(int j = 0; j < seatsInRows.length; ++j)
            if(seatsInRows[j] <= 0)
                throw new IllegalAuditoriumConstrains(ILLEGAL_NUMBER_OF_SEATS_IN_ROW + seatsInRows[j]);

    }

    /**
     * verifies the argumements are legal.
     *  - The auditorium number is a positive.
     *  - The number of rows is a positive number
     *  - the number of seats in row in positive
     * @param auditoriumNumber
     * @param rows
     * @param seatInRow
     * @throws IllegalAuditoriumConstrains if one of the arguments violates one the constraines above
     */
    private void verifyConstructorArguments(long auditoriumNumber, int rows, int seatInRow)
            throws IllegalAuditoriumConstrains {

        if(auditoriumNumber <= 0)
            throw new IllegalAuditoriumConstrains(ILLEGAL_AUDITORIUM_NUMBER_MESSAGE + auditoriumNumber);
        if(rows <= 0)
            throw new IllegalAuditoriumConstrains(ILLEGAL_NUMBER_OF_ROWS_MESSAGE + rows);
        if(seatInRow <= 0)
            throw new IllegalAuditoriumConstrains(ILLEGAL_NUMBER_OF_SEATS_IN_ROW + seatInRow);

    }



}
