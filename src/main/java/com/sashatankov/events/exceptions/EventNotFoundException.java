package com.sashatankov.events.exceptions;

public class EventNotFoundException extends Exception {

    public EventNotFoundException(String message) {
        System.err.println(message);
    }
}
