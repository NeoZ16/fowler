package dhbw.fowler;

abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);
}
