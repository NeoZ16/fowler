package dhbw.fowler;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {
    private final String testCustomerName = "Momo";

    @Test
    public void getNameTest() {
        Customer customer = new Customer(testCustomerName);
        assertEquals(testCustomerName, customer.getName());
    }

    @Test
    public void addRentalTest(){
        Customer customer = new Customer(testCustomerName);
        Rental mockRental = mock(Rental.class);
        customer.addRental(mockRental);

    }

    @Test
    public void testRegularMovieRental(){
        List<MockDataStructure> mockDataList = new ArrayList<MockDataStructure>();
        mockDataList.add(new MockDataStructure("RegularMock", Movie.REGULAR, 1, 2.0, 1));
        mockDataList.add(new MockDataStructure("RegularMock2", Movie.REGULAR, 3, 3.5, 1));


        Customer customer = new Customer(testCustomerName);
        addRentals(customer, mockDataList);
        checkStatement(customer.statement(), mockDataList);
        verifyRentalsAndMovies(mockDataList);

    }

    @Test
    public void testChildrensMovieRental(){
        List<MockDataStructure> mockDataList = new ArrayList<MockDataStructure>();
        mockDataList.add(new MockDataStructure("ChildMock", Movie.CHILDRENS, 1, 1.5, 1));
        mockDataList.add(new MockDataStructure("ChildMock 2", Movie.CHILDRENS, 3, 1.5, 1));
        mockDataList.add(new MockDataStructure("ChildMock 3", Movie.CHILDRENS, 10, 12, 1));


        Customer customer = new Customer(testCustomerName);
        addRentals(customer, mockDataList);
        checkStatement(customer.statement(), mockDataList);
        verifyRentalsAndMovies(mockDataList);

    }

    @Test
    public void testNewReleaseMovieRental(){
        List<MockDataStructure> mockDataList = new ArrayList<MockDataStructure>();
        mockDataList.add(new MockDataStructure("NEW MOCK", Movie.NEW_RELEASE, 1, 3.0, 1));
        mockDataList.add(new MockDataStructure("New Mock 2", Movie.NEW_RELEASE, 3, 9.0, 2));

        Customer customer = new Customer(testCustomerName);
        addRentals(customer, mockDataList);
        checkStatement(customer.statement(), mockDataList);
        verifyRentalsAndMovies(mockDataList);
    }

    private void addRentals(Customer customer, List<MockDataStructure> mockDataList){
        for(MockDataStructure mockData : mockDataList){
            Movie movie = new Movie(mockData.movieTitle, mockData.releaseType);
            Rental rental = new Rental(movie, mockData.getDaysRented());
            mockData.setMockMovie(movie);
            mockData.setMockRental(rental);
            customer.addRental(rental);
        }
    }

    /*private void addMockRentals(Customer customer, List<MockDataStructure> mockDataList){
        for(MockDataStructure mockData : mockDataList) {
            Rental mockRental = mock(Rental.class);
            Movie mockMovie = mock(Movie.class);
            when(mockRental.getMovie()).thenReturn(mockMovie);
            when(mockRental.getDaysRented()).thenReturn(mockData.getDaysRented());
            when(mockMovie.getTitle()).thenReturn(mockData.getMovieTitle());
            when(mockMovie.getPriceCode()).thenReturn(mockData.getReleaseType());
            mockData.setMockMovie(mockMovie);
            mockData.setMockRental(mockRental);
            customer.addRental(mockRental);
        }
    }*/

    private void checkStatement(String statement, List<MockDataStructure> mockDataList){
        StringBuilder sb = new StringBuilder();
        int totalFrequentRenterPoints = 0;
        double totalAmount = 0;
        sb.append("Rental Record for "+testCustomerName+"\n\tTitle\t\tDays\tAmount\n");
        for(MockDataStructure mockData : mockDataList) {
            sb.append("\t" + mockData.getMovieTitle() + "\t" + "\t" + mockData.getDaysRented() +
                      "\t"+ mockData.getAmountOwed() +"\n");
            totalFrequentRenterPoints += mockData.getFrequentRenterPoints();
            totalAmount += mockData.getAmountOwed();
        }

        sb.append("Amount owed is "+totalAmount+"\nYou earned "+totalFrequentRenterPoints+" frequent renter points");

        assertEquals(sb.toString(), statement);
    }

    private void verifyRentalsAndMovies (List<MockDataStructure> mockDataList){
        for(MockDataStructure mockData : mockDataList){
            assertEquals(mockData.getMovieTitle(), mockData.getMockMovie().getTitle());
            assertEquals(mockData.getReleaseType(), mockData.getMockMovie().getPriceCode());
            assertEquals(mockData.getDaysRented(), mockData.getMockRental().getDaysRented());
            assertEquals(mockData.getMockMovie(), mockData.getMockRental().getMovie());
        }
    }

    /*private void checkMockRentals(List<MockDataStructure> mockDataList){
        for(MockDataStructure mockData : mockDataList){
            verify(mockData.getMockRental(), atLeastOnce()).getMovie();
            verify(mockData.getMockRental(), atLeastOnce()).getDaysRented();
            verify(mockData.getMockMovie(), atLeastOnce()).getTitle();
            verify(mockData.getMockMovie(), atLeastOnce()).getPriceCode();
        }
<<<<<<< HEAD
    }*/

    private class MockDataStructure {

        private String movieTitle;
        private int releaseType, daysRented, frequentRenterPoints;
        private double amountOwed;
        private Movie mockMovie;
        private Rental mockRental;

        MockDataStructure(String movieTitle, int releaseType, int daysRented, double amountOwed, int frequentRenterPoints){
            this.movieTitle = movieTitle;
            this.releaseType = releaseType;
            this.daysRented = daysRented;
            this.frequentRenterPoints = frequentRenterPoints;
            this.amountOwed = amountOwed;
        }

        public Movie getMockMovie() {
            return mockMovie;
        }

        public void setMockMovie(Movie mockMovie) {
            this.mockMovie = mockMovie;
        }

        public Rental getMockRental() {
            return mockRental;
        }

        public void setMockRental(Rental mockRental) {
            this.mockRental = mockRental;
        }

        public String getMovieTitle() {
            return movieTitle;
        }

        public int getReleaseType() {
            return releaseType;
        }

        public int getDaysRented() {
            return daysRented;
        }

        public int getFrequentRenterPoints() {
            return frequentRenterPoints;
        }

        public double getAmountOwed() {
            return amountOwed;
        }
    }
}
