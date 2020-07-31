
import static org.junit.jupiter.api.Assertions.*;

import com.sashatankov.events.Movie;
import com.sashatankov.events.MovieScreening;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieScreeningTest {


    @Test
    public void screeningDateTest() {
        try {
            Movie m = new Movie("Avengers", "Action", 150);
            MovieScreening ms = new MovieScreening("2012-05-05", "05:05:00", m);

            boolean isSame = ms.getEventDate().isEqual(LocalDate.parse("2012-05-05"));
            assertTrue(isSame);
        } catch (Exception e) {}
    }

    @Test
    public void screeningTimeTest() {
        try {
            Movie m = new Movie("Avengers", "Action", 150);
            MovieScreening ms = new MovieScreening("2012-05-05", "05:05:00", m);

            boolean isSame = ms.getStartTime().equals(LocalTime.parse("05:05:00"));
            assertTrue(isSame);
        } catch (Exception e) {}
    }

    @Test
    public void durationInHoursTEst() {
        try {
            Movie m = new Movie("Avengers", "Action", 150);
            MovieScreening ms = new MovieScreening("2012-05-05", "05:05:00", m);
            assertEquals(ms.getDurationInHours(), 2.5, 0.1);
        } catch (Exception e) {}
    }

    @Test
    public void movieNameTest() {
        try {
            Movie m = new Movie("Avengers", "Action", 150);
            MovieScreening ms = new MovieScreening("2012-05-05", "05:05:00", m);
            assertArrayEquals(ms.getMovieName().toCharArray(), "Avengers".toCharArray());
        } catch(Exception e) {}
    }
}
