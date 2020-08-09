import com.sashatankov.events.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MovieAuditoriumControllerTest {


    @Test
    public void addAuditoriumTest() {

        MovieAuditoriumController mc = new MovieAuditoriumController();
        assertTrue(mc.addAuditorium(4));

    }

    @Test
    public void addAuditoriumToScreeningTest() {

        try {

            MovieAuditoriumController mc = new MovieAuditoriumController();
            Auditorium venue = new Auditorium(5, 5, 5);
            Movie movie = new Movie("Avatar", "Action", 130);
            MovieScreening event = new MovieScreening("09-09-09", "09:09", movie);

            mc.addAuditoriumToScreening(event, venue);
            assertTrue(mc.auditoriumExist(event));

        } catch (Exception e) {}
    }

    @Test
    public void removeAuditoriumFromScreeningTest() {

        try {

            MovieAuditoriumController mc = new MovieAuditoriumController();
            Auditorium venue = new Auditorium(5, 5, 5);
            Movie movie = new Movie("Avatar", "Action", 130);
            MovieScreening event = new MovieScreening("09-09-09", "09:09", movie);

            mc.addAuditoriumToScreening(event, venue);
            assertTrue(mc.auditoriumExist(event));
            mc.removeAuditoriumFromScreening(event, venue);
            assertTrue(mc.auditoriumExist(event));

        } catch (Exception e) {}

    }

    @Test
    public void addSameAuditoriumTwiceTest() {

        MovieAuditoriumController vs = new MovieAuditoriumController();
        assertTrue(vs.addAuditorium(4));
        assertFalse(vs.addAuditorium(4));

    }

    @Test
    public void auditoriumExistWithDifferentReferenceTest() {

        try {

            MovieAuditoriumController vs = new MovieAuditoriumController();
            Auditorium venue = new Auditorium(5, 5, 5);
            Movie movie = new Movie("Avatar", "Action", 130);
            MovieScreening event = new MovieScreening("09-09-09", "09:09", movie);
            MovieScreening event2 = new MovieScreening("09-09-09", "09:09", movie);

            vs.addAuditoriumToScreening(event, venue);
            assertTrue(vs.auditoriumExist(event));
            assertTrue(vs.auditoriumExist(event2));

        } catch (Exception e) {}
    }

    @Test
    public void removeScreeningWithDifferentReferenceTest() {

        try {

            MovieAuditoriumController vs = new MovieAuditoriumController();
            Auditorium venue = new Auditorium(5, 5, 5);
            Movie movie = new Movie("Avatar", "Action", 130);
            MovieScreening event = new MovieScreening("09-09-09", "09:09", movie);
            MovieScreening event2 = new MovieScreening("09-09-09", "09:09", movie);

            vs.addAuditoriumToScreening(event, venue);
            assertTrue(vs.auditoriumExist(event));
            vs.removeAuditoriumFromScreening(event2, venue);
            assertTrue(vs.auditoriumExist(event));

        } catch (Exception e) {}

    }

    @Test
    public void getAuditoriumTest() {

        try {

            MovieAuditoriumController vs = new MovieAuditoriumController();
            Auditorium expectedVenue = new Auditorium(5, 5, 5);
            Movie movie = new Movie("Avatar", "Action", 130);
            MovieScreening event = new MovieScreening("09-09-09", "09:09", movie);


            vs.addAuditoriumToScreening(event, expectedVenue);
            assertTrue(vs.auditoriumExist(event));
            EventVenue actualVenue = vs.getAuditorium(event);
            assertEquals(expectedVenue, actualVenue);

        } catch (Exception e) {}
    }





}
