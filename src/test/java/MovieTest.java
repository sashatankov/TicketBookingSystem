import com.sashatankov.events.Movie;
import static org.junit.jupiter.api.Assertions.*;

import com.sashatankov.events.exceptions.IllegalMovieDurationException;
import org.junit.jupiter.api.Test;

public class MovieTest {

    @Test
    public void movieNameTest() {

        try {
            Movie m = new Movie("Avatar", "Action", 150);
            assertArrayEquals(m.getName().toCharArray(), "Avatar".toCharArray());
        } catch(Exception e) {}
    }

    @Test
    public void emptyMovieNameTest() {
        try {
            Movie m = new Movie("", "Action", 150);
            assertArrayEquals(m.getName().toCharArray(), "".toCharArray());
        } catch(Exception e) {}
    }

    @Test
    public void movieGenreTest() {
        try {
            Movie m = new Movie("Avatar", "Action", 150);
            assertArrayEquals(m.getGenre().toCharArray(), "Action".toCharArray());
        } catch(Exception e) {}
    }

    @Test
    public void emptyMovieGenreTest() {
        try {
            Movie m = new Movie("Avatar", "", 150);
            assertArrayEquals(m.getGenre().toCharArray(), "".toCharArray());
        } catch(Exception e) {}
    }

    @Test
    public void movieDurationTest() {
        try {

            Movie m = new Movie("Avatar", "", 150);
            Movie m1 = new Movie("Avater", "Action", 0);

            assertEquals(m.getDurationInMinutes(), 150);
            assertEquals(m.getDurationInMinutes(), 0);

        } catch(Exception e) {}
    }

    @Test
    public void illegalMovieDurationTest() {

        assertThrows(IllegalMovieDurationException.class, () -> {
            Movie m = new Movie("Avatar", "Action", -8);
        });

    }


}
