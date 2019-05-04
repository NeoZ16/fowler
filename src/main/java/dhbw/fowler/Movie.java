package dhbw.fowler;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private Price price;
    public Movie(String newTitle, int newPriceCode) {
        title = newTitle;
        setPriceCode(newPriceCode);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch(arg) {
            case REGULAR:
                this.price = new RegularPrice();
                break;
            case NEW_RELEASE:
                this.price = new NewReleasePrice();
                break;
            case CHILDRENS:
                this.price = new ChildrensPrice();
                break;
        }
    }

    public String getTitle (){
        return title;
    };

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}