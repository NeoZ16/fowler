package dhbw.fowler;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class RentalTest {
    private final static int testDaysRented = 10;
    private Movie mockedMovie;

    @Before
    public void setUp(){
        mockedMovie = mock(Movie.class);
    }

    @Test
    public void testDaysRented(){
        Rental rental = new Rental(mockedMovie, testDaysRented);
        assertEquals(testDaysRented, rental.getDaysRented());
    }

    @Test
    public void testGetMovie(){
        Rental rental = new Rental(mockedMovie, testDaysRented);
        assertEquals(mockedMovie, rental.getMovie());
    }
}
