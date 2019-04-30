package dhbw.fowler;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieTest {
    private final static String testTitle = "TestTitle";
    private final static int testPrice = 100;
    private final static int testPriceUpdated = 200;

    @Test
    public void getPriceCodeTests() {
        Movie movie = new Movie(testTitle, testPrice);
        assertEquals(testPrice, movie.getPriceCode());
        movie.setPriceCode(testPriceUpdated);
        assertEquals(testPriceUpdated, movie.getPriceCode());
    }

    @Test
    public void getTitle(){
        Movie movie = new Movie(testTitle, testPrice);
        assertEquals(testTitle, movie.getTitle());
    }
}
