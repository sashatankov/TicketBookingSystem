

public class Movie {

    private String name;
    private String genre;
    private String durationInMinutes;

    public Movie(String name, String genre, String durationInMinutes) {

        this.name = name;
        this.genre = genre;
        this.durationInMinutes = durationInMinutes;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getDurationInMinutes() {
        return durationInMinutes;
    }

    @Override
    public String toString() {
        return null;
    }
}
