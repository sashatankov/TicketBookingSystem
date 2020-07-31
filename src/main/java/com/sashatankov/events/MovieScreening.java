package com.sashatankov.events;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * a class representing a movie screening in a movie theater
 */
public class MovieScreening implements EntertainmentEvent {

    private LocalDate date;
    private LocalTime time;
    private Movie movie;

    /**
     * a constructor that creates a movie screening
     * @param date the date of the screening in <YYYY-MM-DD> format
     * @param time the time of the screening in <HH:MM:SS> format
     * @param movie the movie to screen, a Movie object
     */
    public MovieScreening(String date, String time, Movie movie) {
        this.date = LocalDate.parse(date);
        this.time = LocalTime.parse(time);
        this.movie = movie;
    }

    /**
     *
     * @return the date of the event
     */
    @Override
    public LocalDate getEventDate() {
        return this.date;
    }

    /**
     *
     * @return the start time of the screening
     */
    @Override
    public LocalTime getStartTime() {
        return this.time;
    }

    /**
     *
     * @return the duration of the movie in hours
     */
    @Override
    public double getDurationInHours() {
        long durationInMinutes = this.movie.getDurationInMinutes();
        return (double)durationInMinutes / 60;
    }

    /**
     *
     * @return the name of the movie
     */
    @Override
    public String getName() {
        return this.movie.getName(); // TODO to add description of date and time
    }

    /**
     *
     * @return the name of the maovie
     *
     */
    public String getMovieName() {
        return this.movie.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieScreening that = (MovieScreening) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(time, that.time) &&
                Objects.equals(movie, that.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, time, movie);
    }

    @Override
    public String toString() {
        return this.movie.getName() + "\n" +
                "Date: " + this.getEventDate() + "\n" +
                "Time: " + this.getStartTime() + "\n";
    }
}
