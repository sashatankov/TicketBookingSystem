import com.sashatankov.events.Auditorium;
import static org.junit.jupiter.api.Assertions.*;

import com.sashatankov.events.exceptions.IllegalAuditoriumConstrains;
import com.sashatankov.events.exceptions.SeatOutOfBoundsException;
import org.junit.jupiter.api.Test;


public class AuditoriumTest {

    @Test
    public void auditoriumNumberTest() {
        try {
            Auditorium a = new Auditorium(1, 10, 10);
            assertEquals(1, a.getId());
        } catch(Exception e) {}

    }

    @Test
    public void capacityFixedSeatsInRowTest() {
        try {
            Auditorium a = new Auditorium(1, 10, 10);
            assertEquals(100, a.capacity());
        } catch(Exception e) {}
    }

    @Test
    public void capacityVariousSeatsInRowTest() {
        try {
            int[] seatsInRow = {10, 20, 56, 31};
            Auditorium a = new Auditorium(3, seatsInRow);
            assertEquals(117, a.capacity());
        } catch(Exception e){}

    }

    @Test
    public void isSeatEmptyTest() {
        try {
            Auditorium a = new Auditorium(1, 10, 10);
            assertTrue(a.isSeatEmpty(5,5));
        } catch(Exception e) {}

    }

    @Test
    public void isSeatNotEmptyAfterBookTest() {
        try { // we assume that exception will not throwa
            Auditorium a = new Auditorium(1, 10, 10);
            a.bookSeat(5,5);
            assertFalse(a.isSeatEmpty(5,5));
        } catch (Exception e) {}

    }

    @Test
    public void isSeatEmptyNumberOutOfBoundsTest() {
        try {
            Auditorium a = new Auditorium(1, 10, 10);

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.isSeatEmpty(-3, 4);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.isSeatEmpty(-3, -3);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.isSeatEmpty(4, -4);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.isSeatEmpty(12, 4);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.isSeatEmpty(3, 25);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.isSeatEmpty(25, 25);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.isSeatEmpty(25, -3);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.isSeatEmpty(-3, 25);
            });


        } catch (Exception e) {}
    }

    @Test
    public void bookSeatNumberOutOgBoundsTest() {
        try {
            Auditorium a = new Auditorium(1, 10, 10);

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.bookSeat(-3, 4);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.bookSeat(-3, -3);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.bookSeat(4, -4);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.bookSeat(12, 4);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.bookSeat(3, 25);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.bookSeat(25, 25);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.bookSeat(25, -3);
            });

            assertThrows(SeatOutOfBoundsException.class, () -> {
                a.bookSeat(-3, 25);
            });


        } catch (Exception e) {}
    }

    @Test
    public void auditoriumNumberOutOfBoundsTest() {

        assertThrows(IllegalAuditoriumConstrains.class, () -> {
            Auditorium a = new Auditorium(-4, 10, 10);
        });

        assertThrows(IllegalAuditoriumConstrains.class, () -> {
            Auditorium a = new Auditorium(0, 10, 20);
        });

        assertThrows(IllegalAuditoriumConstrains.class, () -> {
            int[] seats = {3, 4, 5, 6};
            Auditorium a = new Auditorium(0, seats);
        });

        assertThrows(IllegalAuditoriumConstrains.class, () -> {
            int[] seats = {3, 4, 5, 6};
            Auditorium a = new Auditorium(-3, seats);
        });


    }

    @Test
    public void numberOfRowsInAuditoriumIsOutOfBounds() {

        assertThrows(IllegalAuditoriumConstrains.class, () -> {
            Auditorium a = new Auditorium(3, -5, 4);
        });

        assertThrows(IllegalAuditoriumConstrains.class, () -> {
           Auditorium a  = new Auditorium(5, 0, 8);
        });


        assertThrows(IllegalAuditoriumConstrains.class, () -> {
            int seats[] = {};
            Auditorium a  = new Auditorium(6, seats);
        });


    }

    @Test
    public void numberOfSeatsInRowIsOutOfBounds() {

        assertThrows(IllegalAuditoriumConstrains.class, () -> {
            Auditorium a = new Auditorium(3, 4, 0);
        });

        assertThrows(IllegalAuditoriumConstrains.class, () -> {
            Auditorium a = new Auditorium(3, 5, -6);
        });

        assertThrows(IllegalAuditoriumConstrains.class, () -> {
            int[] seats = {7, 5, 10, -3};
            Auditorium a = new Auditorium(3, seats);
        });

        assertThrows(IllegalAuditoriumConstrains.class, () -> {
            int[] seats = {9, 7, 3, 0};
            Auditorium a = new Auditorium(5, seats);
        });
    }


}
