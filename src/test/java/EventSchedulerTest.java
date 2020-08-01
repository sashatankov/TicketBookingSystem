import com.sashatankov.events.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class EventSchedulerTest {


    @Test
    public void addEventTest() {

        try {

            EventScheduler e = new EventScheduler();
            Movie m = new Movie("Avatar", "Action", 150);
            EntertainmentEvent event = new MovieScreening("2009-12-12", "05:05:05", m);
            assertTrue(e.addEvent(event));

        } catch(Exception e) {}

    }

    @Test
    public void removeEventTest() {

        try {

            EventScheduler e = new EventScheduler();
            Movie m = new Movie("Avatar", "Action", 150);
            EntertainmentEvent event = new MovieScreening("2009-12-12", "05:05:05", m);
            assertTrue(e.addEvent(event));
            assertTrue(e.removeEvent(event));

        } catch(Exception e) {}

    }

    @Test
    public void addVenueTest() {

        try {

            EventScheduler e = new EventScheduler();
            EventVenue venue = new Auditorium(3, 5, 6);
            assertTrue(e.addVenue(venue));

        } catch(Exception e) {}
    }

    @Test
    public void addSameEventTwice() {

        try {

            EventScheduler e = new EventScheduler();
            Movie m = new Movie("Avatar", "Action", 150);
            EntertainmentEvent event = new MovieScreening("2009-12-12", "05:05:05", m);

            assertTrue(e.addEvent(event));
            assertFalse(e.addEvent(event));

        } catch(Exception e) {}

    }

    @Test
    public void removeSameEventTwice() {

        try {

            EventScheduler e = new EventScheduler();
            Movie m = new Movie("Avatar", "Action", 150);
            EntertainmentEvent event = new MovieScreening("2009-12-12", "05:05:05", m);

            assertTrue(e.addEvent(event));
            assertTrue(e.removeEvent(event));
            assertFalse(e.removeEvent(event));

        } catch(Exception e) {}
    }

    @Test
    public void addSameVenueTwice() {

        try {

            EventScheduler e = new EventScheduler();
            EventVenue venue = new Auditorium(3, 5, 6);
            assertTrue(e.addVenue(venue));
            assertFalse(e.addVenue(venue));

        } catch(Exception e) {}
    }

    @Test
    public void addSameVenueTwiceDifferentReferenceTest() {

        try {

            EventScheduler e = new EventScheduler();
            EventVenue venue = new Auditorium(3, 5, 6);
            EventVenue venue2 = new Auditorium(3, 5, 6);

            assertTrue(e.addVenue(venue));
            assertFalse(e.addVenue(venue2));

        } catch(Exception e) {}

    }

    @Test
    public void addSameEventTwiceDifferentObjectsTest() {

        try {

            EventScheduler e = new EventScheduler();
            Movie m = new Movie("Avatar", "Action", 150);
            Movie m2 = new Movie("Avatar", "Action", 150);
            EntertainmentEvent event = new MovieScreening("2009-12-12", "05:05:05", m);
            EntertainmentEvent event2 = new MovieScreening("2009-12-12", "05:05:05", m2);

            assertTrue(e.addEvent(event));
            assertFalse(e.addEvent(event2));

        } catch(Exception e) {}

    }

    @Test
    public void removeEventDifferentReferenceTest() {

        try {

            EventScheduler e = new EventScheduler();
            Movie m = new Movie("Avatar", "Action", 150);
            Movie m2 = new Movie("Avatar", "Action", 150);
            EntertainmentEvent event = new MovieScreening("2009-12-12", "05:05:05", m);
            EntertainmentEvent event2 = new MovieScreening("2009-12-12", "05:05:05", m2);

            assertTrue(e.addEvent(event));
            assertTrue(e.addEvent(event2));

        } catch(Exception e) {}

    }

    @Test
    public void addConflictingEventAfterEventTest() {

        try {

            EventScheduler e = new EventScheduler();
            EventVenue venue = new Auditorium(3,5,6);
            e.addVenue(venue);

            Movie m1 = new Movie("Avatar", "Action", 150);
            Movie m2 = new Movie("Thor", "Action", 100);
            Movie m3 = new Movie("Gravity", "scifi", 90);

            EntertainmentEvent ms1 = new MovieScreening("2009-12-12", "06:06:06", m1);
            EntertainmentEvent ms2 = new MovieScreening("2009-12-12", "07:00:00", m2);


            assertTrue(e.addEvent(ms1));
            assertFalse(e.addEvent(ms2));


        } catch(Exception e) {}
    }

    @Test
    public void addConflictingEventBetweenEventsTest() {

        try {

            EventScheduler e = new EventScheduler();
            EventVenue venue = new Auditorium(3,5,6);
            e.addVenue(venue);

            Movie m1 = new Movie("Avatar", "Action", 150);
            Movie m2 = new Movie("Thor", "Action", 100);
            Movie m3 = new Movie("Gravity", "scifi", 90);

            EntertainmentEvent ms1 = new MovieScreening("2009-12-12", "06:06:06", m1);
            EntertainmentEvent ms2 = new MovieScreening("2009-12-12", "07:00:00", m2);
            EntertainmentEvent ms3 = new MovieScreening("2009-12-12", "10:00:00", m3);
            EntertainmentEvent ms4 = new MovieScreening("2009-12-12", "09:00:00", m3);

            assertTrue(e.addEvent(ms1));
            assertTrue(e.addEvent(ms3));
            assertFalse(e.addEvent(ms2));
            assertFalse(e.addEvent(ms4));


        } catch(Exception e) {}

    }

    @Test
    public void addConflictingEventBeforeEventTest() {

        try {

            EventScheduler e = new EventScheduler();
            EventVenue venue = new Auditorium(3,5,6);
            e.addVenue(venue);

            Movie m1 = new Movie("Avatar", "Action", 150);
            Movie m2 = new Movie("Thor", "Action", 100);
            Movie m3 = new Movie("Gravity", "scifi", 90);

            EntertainmentEvent ms1 = new MovieScreening("2009-12-12", "06:06:06", m1);
            EntertainmentEvent ms2 = new MovieScreening("2009-12-12", "07:00:00", m2);
            EntertainmentEvent ms3 = new MovieScreening("2009-12-12", "10:00:00", m3);

            assertTrue(e.addEvent(ms2));
            assertTrue(e.addEvent(ms3));
            assertFalse(e.addEvent(ms1));


        } catch(Exception e) {}

    }




}
