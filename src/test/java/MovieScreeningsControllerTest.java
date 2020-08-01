import com.sashatankov.events.Movie;
import com.sashatankov.events.MovieScreening;
import com.sashatankov.events.MovieScreeningsController;
import com.sashatankov.events.exceptions.IllegalMovieDurationException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;


public class MovieScreeningsControllerTest {


    @Test
    public void addScreeningTest() {

        try {

            MovieScreeningsController controller = new MovieScreeningsController();
            Movie m1 = new Movie("Avatar", "Action", 150);
            assertTrue(controller.addScreening(m1, "2011-12-12", "12:12:12"));

        } catch(Exception e){}

    }

    @Test
    public void removeScreeningTest() {

        try {

            MovieScreeningsController controller = new MovieScreeningsController();
            Movie m1 = new Movie("Avatar", "Action", 150);
            assertTrue(controller.addScreening(m1, "2011-12-12", "12:12:12"));
            assertTrue(controller.removeScreening(m1, "2011-12-12", "12:12:12"));

        } catch(Exception e) {}
    }

    @Test
    public void addMovieTest() {

        try {

            MovieScreeningsController controller = new MovieScreeningsController();
            assertTrue(controller.addMovie("Avatar", "Action", 150));

        } catch(Exception e){}
    }

    @Test
    public void addMovieIllegalDurationArgumentsTest() {

        assertThrows(IllegalMovieDurationException.class, () -> {
            MovieScreeningsController controller = new MovieScreeningsController();
            controller.addMovie("Avatar", "Action", -150);

        });
    }

    @Test
    public void removeMovieTest() {

        try {

            MovieScreeningsController controller = new MovieScreeningsController();
            assertTrue(controller.addMovie("Avatar", "Action", 150));
            assertFalse(controller.removeMovie("Avatar"));

        } catch(Exception e) {}

    }

    @Test
    public void getScreeningByMovieNameTest() {

        try {

            MovieScreeningsController controller = new MovieScreeningsController();
            Movie m1 = new Movie("Avatar", "Action", 150);
            Movie m2 = new Movie("Thor", "Action", 110);
            Movie m3 = new Movie("Gravity", "Scifi", 90);

            assertTrue(controller.addScreening(m1, "2020-12-12", "18:45:30"));
            assertTrue(controller.addScreening(m2, "2019-12-21", "19:00:00"));
            assertTrue(controller.addScreening(m3, "2018-10-23", "20:30:00"));
            assertTrue(controller.addScreening(m1, "2020-03-03", "21:15:00"));
            assertTrue(controller.addScreening(m1, "2010-12-12", "18:45:30"));
            assertTrue(controller.addScreening(m2, "2015-12-21", "19:00:00"));
            assertTrue(controller.addScreening(m3, "2018-10-23", "20:30:00"));
            assertTrue(controller.addScreening(m1, "2020-04-03", "21:15:00"));

            List<MovieScreening> screeningsByName = controller.getScreeningsByMovieName("Avatar");
            assertEquals(4, screeningsByName.size());
            for(MovieScreening screening: screeningsByName)
                assertArrayEquals(screening.getMovieName().toCharArray(), "Avatar".toCharArray());

        } catch(Exception e) {}
    }

    @Test
    public void getMovieScreeningsByDate() {

        try {

            MovieScreeningsController controller = new MovieScreeningsController();
            Movie m1 = new Movie("Avatar", "Action", 150);
            Movie m2 = new Movie("Thor", "Action", 110);
            Movie m3 = new Movie("Gravity", "Scifi", 90);

            assertTrue(controller.addScreening(m1, "2020-12-12", "18:45:30"));
            assertTrue(controller.addScreening(m2, "2019-12-21", "19:00:00"));
            assertTrue(controller.addScreening(m3, "2018-10-23", "20:30:00"));
            assertTrue(controller.addScreening(m1, "2020-03-03", "21:15:00"));
            assertTrue(controller.addScreening(m1, "2018-10-23", "18:45:30"));
            assertTrue(controller.addScreening(m2, "2015-12-21", "19:00:00"));
            assertTrue(controller.addScreening(m3, "2018-10-23", "20:30:00"));
            assertTrue(controller.addScreening(m1, "2020-04-03", "21:15:00"));

            LocalDate date;
            List<MovieScreening> screeningsByName = controller.getMovieScreeningsByDate("2018-10-23");
            assertEquals(3, screeningsByName.size());
            for(MovieScreening screening: screeningsByName) {
                date = LocalDate.of(2018, 10, 23);
                assertTrue(screening.getEventDate().isEqual(date));
            }

        } catch(Exception e) {}
    }
}
