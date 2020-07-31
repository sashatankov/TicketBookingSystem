package com.sashatankov.events.exceptions;

public class IllegalMovieDurationException extends Exception {

    public IllegalMovieDurationException(String message) {
        System.err.println(message);
    }
}
