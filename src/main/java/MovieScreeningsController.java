import java.util.List;
import java.util.Set;

public class MovieScreeningsController {

    private EventScheduler screeningsScheduler;
    private List<MovieScreening> movieScreenings;
    private Set<Movie> movies;

    public MovieScreeningsController() {

    }

    public boolean addScreening(Movie movie, String date, String time){
        // TODO
        return false;
    }

    public boolean removeScreening(Movie movie, String date, String time) {
        // TODO
        return false;
    }

    public boolean addMovie(String movieName, String genre, String durationInMinutes) {
        // TODO
        return false;
    }

    public boolean removeMovie(String movieName) {
        // TODO
        return false;
    }

    public List<MovieScreening> getScreeningsByMovieName(String movieName) {
        // TODO
        return null;
    }

    public List<MovieScreening> getMovieScreeningsByDate(String date) {
        // TODO
        return null;
    }
}
