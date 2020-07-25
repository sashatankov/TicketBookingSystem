import java.time.LocalDate;
import java.time.LocalTime;

public class MovieScreening implements EntertainmentEvent {

    private LocalDate date;
    private LocalTime time;
    private Movie movie;

    public MovieScreening(String date, String time, Movie movie) {
        this.date = LocalDate.parse(date);
        this.time = LocalTime.parse(time);
        this.movie = movie;
    }

    @Override
    public LocalDate getEventDate() {
        return this.date;
    }

    @Override
    public LocalTime getStartTime() {
        return this.time;
    }

    @Override
    public double getDurationInHours() {
        String durationInMinutesStr = this.movie.getDurationInMinutes();
        int durationInMinutes = Integer.parseInt(durationInMinutesStr);
        return (double)durationInMinutes / 60;
    }

    @Override
    public String getDescription() {
        return this.movie.toString(); // TODO to add description of date and time
    }

    public boolean isSeatAvailableAt(int row, int seatNumber) {
        // TODO
        return false;
    }
}
