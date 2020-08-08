package com.sashatankov.events.exceptions;

public class VenueNotFoundException extends Exception {

    public VenueNotFoundException(String message) {
        System.err.println(message);
    }
}
