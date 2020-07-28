package com.sashatankov.events.exceptions;

/**
 * an Exception that is thrown when a user request a seat
 * that does not exist in the auditorium. Whether the number of the row
 * is illegal, or the number of seat in the row is illegal.
 */
public class SeatOutOfBoundsException extends Exception {

    public SeatOutOfBoundsException() {

    }
}
