import com.sashatankov.events.*;
import com.sashatankov.schedulers.VenueScheduler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class VenueSchedulerTest {


    @Test
    public void addVenueTest() {

        VenueScheduler vs = new VenueScheduler();
        assertTrue(vs.addVenue(4));

    }

    @Test
    public void addEventTest() {

        try {

            VenueScheduler vs = new VenueScheduler();
            EventVenue venue = new Auditorium(5, 5, 5);
            Movie movie = new Movie("Avatar", "Action", 130);
            EntertainmentEvent event = new MovieScreening("09-09-09", "09:09", movie);

            vs.addVenueToEvent(event, venue);
            assertTrue(vs.venueExist(event));

        } catch (Exception e) {}

    }

    @Test
    public void removeEventTest() {

        try {

            VenueScheduler vs = new VenueScheduler();
            EventVenue venue = new Auditorium(5, 5, 5);
            Movie movie = new Movie("Avatar", "Action", 130);
            EntertainmentEvent event = new MovieScreening("09-09-09", "09:09", movie);

            vs.addVenueToEvent(event, venue);
            assertTrue(vs.venueExist(event));
            vs.removeVenueFromEvent(event, venue);
            assertFalse(vs.venueExist(event));

        } catch (Exception e) {}

    }

    @Test
    public void addSameVenueTwiceTest() {

        VenueScheduler vs = new VenueScheduler();
        assertTrue(vs.addVenue(4));
        assertFalse(vs.addVenue(4));
    }

    @Test
    public void venueExistWithDifferentReferenceTest() {

        try {

            VenueScheduler vs = new VenueScheduler();
            EventVenue venue = new Auditorium(5, 5, 5);
            Movie movie = new Movie("Avatar", "Action", 130);
            EntertainmentEvent event = new MovieScreening("09-09-09", "09:09", movie);
            EntertainmentEvent event2 = new MovieScreening("09-09-09", "09:09", movie);

            vs.addVenueToEvent(event, venue);
            assertTrue(vs.venueExist(event));
            assertTrue(vs.venueExist(event2));

        } catch (Exception e) {}

    }

    @Test
    public void removeEventWithDifferentReferenceTest() {

        try {

            VenueScheduler vs = new VenueScheduler();
            EventVenue venue = new Auditorium(5, 5, 5);
            Movie movie = new Movie("Avatar", "Action", 130);
            EntertainmentEvent event = new MovieScreening("09-09-09", "09:09", movie);
            EntertainmentEvent event2 = new MovieScreening("09-09-09", "09:09", movie);

            vs.addVenueToEvent(event, venue);
            assertTrue(vs.venueExist(event));
            vs.removeVenueFromEvent(event2, venue);
            assertTrue(vs.venueExist(event));

        } catch (Exception e) {}
    }

    @Test
    public void getVenueTest() {

        try {

            VenueScheduler vs = new VenueScheduler();
            EventVenue expectedVenue = new Auditorium(5, 5, 5);
            Movie movie = new Movie("Avatar", "Action", 130);
            EntertainmentEvent event = new MovieScreening("09-09-09", "09:09", movie);


            vs.addVenueToEvent(event, expectedVenue);
            assertTrue(vs.venueExist(event));
            EventVenue actualVenue = vs.getVenue(event);
            assertEquals(expectedVenue, actualVenue);

        } catch (Exception e) {}

    }

}
