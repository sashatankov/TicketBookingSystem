import java.time.LocalDate;
import java.time.LocalTime;

public interface EntertainmentEvent {

    LocalDate getEventDate();
    LocalTime getStartTime();
    double getDurationInHours();
    String getDescription();
}
