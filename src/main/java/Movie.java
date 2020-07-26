import java.util.Objects;

/**
 * A class represent a movie in a movie theater
 */
public class Movie {

    private String name;
    private String genre;
    private long durationInMinutes;

    /**
     * The constructor of the class, stores the date about the movie
     * @param name name of the movie
     * @param genre genre of the movie
     * @param durationInMinutes the duration of the movie in minutes
     */
    public Movie(String name, String genre, long durationInMinutes) {

        this.name = name;
        this.genre = genre;
        this.durationInMinutes = durationInMinutes;

    }

    /**
     *
     * @return the name of the movie
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the genre of the movie
     */
    public String getGenre() {
        return genre;
    }

    /**
     *
     * @return the duration of the movie in minutes
     */
    public long getDurationInMinutes() {
        return durationInMinutes;
    }

    @Override
    public String toString() {
        return "Movie Name: " + this.getName() + "\n" +
                "Genre: " + this.getGenre() + "\n" +
                "Duration: " + this.getDurationInMinutes() + " minutes\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return durationInMinutes == movie.durationInMinutes &&
                Objects.equals(name, movie.name) &&
                Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre, durationInMinutes);
    }
}
