package com.sashatankov.events.exceptions;

public class IllegalAuditoriumConstrains extends Exception {

    public IllegalAuditoriumConstrains(String message) {
        System.err.println(message);
    }
}
