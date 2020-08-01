package com.sashatankov.events;

import com.sashatankov.events.exceptions.IllegalMovieDurationException;

import java.time.LocalDate;
import java.util.*;

/**
 * a Controller class to manage the screenings of movies in a movie theater
 */
public class MovieScreeningsController {

    private EventScheduler screeningsScheduler;
    private List<MovieScreening> movieScreenings;
    private Set<Movie> movies;

    /**
     * a default constructor for the class, with no screenings and no movies
     */
    public MovieScreeningsController() {
        this.screeningsScheduler = new EventScheduler();
        this.movieScreenings = new ArrayList<>();
        this.movies = new HashSet<>(); //TODO as a feature, to call a movie database
    }

    /**
     * a constructor for at the class with no screenings,
     * and initial set of movies
     * @param movies initial collection of movies to screen
     */
    public MovieScreeningsController(Collection<Movie> movies) {
        this.screeningsScheduler = new EventScheduler();
        this.movieScreenings = new ArrayList<>();
        this.movies = new HashSet<>();
        this.movies.addAll(movies);
    }

    /**
     * adds screening to the schedule
     * @param movie a movie to add, a com.sashatankov.events.Movie object
     * @param date date of the screening
     * @param time time of the screening
     * @return true, if screening added successfully, false otherwise
     */
    public boolean addScreening(Movie movie, String date, String time){

        MovieScreening screeningToAdd = new MovieScreening(date, time, movie);
        movieScreenings.add(screeningToAdd);
        return screeningsScheduler.addEvent(screeningToAdd);
    }

    /**
     * removes screening from schedule
     * @param movie the movie, whose screening to remove
     * @param date the date of the screening to remove
     * @param time the time of the screening to remove
     * @return true, if removed successfully. false, otherwise.
     */
    public boolean removeScreening(Movie movie, String date, String time) {

        MovieScreening screeningToRemove = new MovieScreening(date, time, movie);
        movieScreenings.remove(screeningToRemove);
        return screeningsScheduler.removeEvent(screeningToRemove);

    }

    /**
     * add a movie to the collection of the on-screening movies
     * @param movieName the name of the movie
     * @param genre the genre of the movie
     * @param durationInMinutes the duration of the movie in minutes
     * @return true, if movie added successfully to the collection. false, otherwise
     */
    public boolean addMovie(String movieName, String genre, long durationInMinutes) throws IllegalMovieDurationException {

        Movie movie = new Movie(movieName, genre, durationInMinutes);
        this.movies.add(movie);
        return true;
    }

    /**
     * removes movie from the collection of the on-screening movies
     * @param movieName the name of the movie
     * @return true, if removed successfully. false, otherwise.
     */
    public boolean removeMovie(String movieName) {

        Movie current;
        Iterator<Movie> iterator = this.movies.iterator();
        while (iterator.hasNext()) {
            current = iterator.next();
            if(current.getName().equals(movieName)) {
                this.movies.remove(current);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param movieName a name of a movie
     * @return a list of screenings of a given movie
     */
    public List<MovieScreening> getScreeningsByMovieName(String movieName) {

        List<MovieScreening> screeningsByName = new ArrayList<>();
        for(MovieScreening movieScreening: this.movieScreenings) {
            if(movieScreening.getMovieName().equals(movieName)) {
                screeningsByName.add(movieScreening);
            }
        }

        return screeningsByName;
    }

    /**
     *
     * @param date a date
     * @return a list of screenings in a given date
     */
    public List<MovieScreening> getMovieScreeningsByDate(String date) {


        List<MovieScreening> screeningsByDate = new ArrayList<>();
        LocalDate d = LocalDate.parse(date);
        for(MovieScreening movieScreening: this.movieScreenings) {
            if(movieScreening.getEventDate().isEqual(d)) {
                screeningsByDate.add(movieScreening);
            }
        }
        return screeningsByDate;
    }
}
