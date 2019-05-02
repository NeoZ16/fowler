package dhbw.fowler;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieTest {
    private final static String testTitle = "TestTitle";
    private final static int testPriceCode = Movie.REGULAR;
    private final static int testPriceCodeUpdated = Movie.NEW_RELEASE;

    @Test
    public void getAndSetPriceCodeTests() {
        Movie movie = new Movie(testTitle, testPriceCode);
        assertEquals(testPriceCode, movie.getPriceCode());
        movie.setPriceCode(testPriceCodeUpdated);
        assertEquals(testPriceCodeUpdated, movie.getPriceCode());
    }

    @Test
    public void getTitle(){
        Movie movie = new Movie(testTitle, testPriceCode);
        assertEquals(testTitle, movie.getTitle());
    }
}
