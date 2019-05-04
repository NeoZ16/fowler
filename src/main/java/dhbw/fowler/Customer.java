package dhbw.fowler;

import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer (String newname){
        name = newname;
    };

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };

    public String getName (){
        return name;
    };

    public String statement() {
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement(){
        Enumeration enum_rentals = rentals.elements();
        String result = "<h1>Rental Record for <em>" +getName()+"</em></h1>\n<table>\n";

        while(enum_rentals.hasMoreElements()){
            Rental each = (Rental) enum_rentals.nextElement();
            result += "\t<tr><td>"+each.getMovie().getTitle()+"</td>"+
                    "<td>"+each.getDaysRented()+"</td>" +
                    "<td>"+each.getCharge()+"</td>" +
                    "</tr>\n";
        }

        result += "</table>\n<p>You owe "+getTotalCharge()+"</p>\n"+
                  "<p>On this rental you've earned "+getTotalFrequentRenterPoints()+" frequent renter points</p>";


        return result;
    }

    private double getTotalCharge(){
        double result = 0;
        Enumeration enum_rentals = rentals.elements();
        while(enum_rentals.hasMoreElements()){
            Rental each  = (Rental) enum_rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration enum_rentals = rentals.elements();
        while(enum_rentals.hasMoreElements()){
            Rental each  = (Rental) enum_rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }


}
    