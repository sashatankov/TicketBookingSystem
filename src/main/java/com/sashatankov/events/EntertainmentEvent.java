package com.sashatankov.events;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * the interface represent an abstract entertainment Event
 */
public interface EntertainmentEvent {

    /**
     *
     * @return the date of the event
     */
    LocalDate getEventDate();

    /**
     *
     * @return the time of the event
     */
    LocalTime getStartTime();

    /**
     *
     * @return the duration if the event in hours
     */
    double getDurationInHours();

    /**
     *
     * @return the name of the event
     */
    String getName();
}
