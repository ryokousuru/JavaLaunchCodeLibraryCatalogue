package com.launchcode.java;

import java.nio.BufferOverflowException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    //properties, fields, globals, variables
    Map<String, Book>bookCollection = new HashMap<String, Book>();
    int currentDay = 0;
    int checkoutPeriod = 21;
    double initialLateFee = 0.5;
    double feePerLateDay = 0.75;

    //2 constructors means more flexibility

    public Main(Map<String, Book> collection){
        this.bookCollection = collection;
    }

    public Main(Map<String, Book> collection, int checkoutPeriod,
                double initialLateFee, double feePerLateDay){
        this.bookCollection = collection;
        this.checkoutPeriod = checkoutPeriod;
        this.initialLateFee = initialLateFee;
        this.feePerLateDay = feePerLateDay;
    }

    //getters


    public int getCurrentDay() {
        return this.currentDay;
    }

    public Map<String, Book> getBookCollection(){
        return this.bookCollection;
    }

    public Book getBook(String bookTitle){      //get a book by it's title
        return getBookCollection().get(bookTitle);
    }

    public int getCheckoutPeriod(){
        return this.checkoutPeriod;
    }

    public double getInitialLateFee(){
        return this.initialLateFee;
    }

    public double getFeePerLateDay(){
        return this.feePerLateDay;
    }

    //setters

    public void nextDay(){
        currentDay++;
    }

    public void setDay (int day){
        currentDay = day;
    }

    //instance methods (don't have static in front of them

   public void checkOutBook(String title){
        Book book = getBook(title);
        if (book.getCheckedout()){
            alreadyCheckedOutBook(book);
        }else{
            book.setCheckedOut(true, currentDay);
            System.out.println("You just checked out " + title + ".");
            System.out.println("Due date for it is "
                    + (getCurrentDay() + getCheckoutPeriod()) + ".");
        }
   }

   public void returnBook (String title){
        Book book = getBook(title);
        int daysLate = currentDay - (book.getDayCheckedOut()
                + getCheckoutPeriod());
           if (daysLate > 0) {
               System.out.println("You owe the library "
                       + (getInitialLateFee() + (daysLate
                       * getFeePerLateDay())) + " because your "
               + "book is " + daysLate + " days past due.");
           } else{
               System.out.println("Book has been returned, thanks!");
           }
           book.setCheckedOut(false, -1);
       }

    public void alreadyCheckedOutBook(Book book){
        System.out.println("Sorry, but " + book.getTitle()
                + " is already checked out");
        System.out.println("It should be back on " +
                book.getCheckedout() + " " + getCheckoutPeriod() + ".");
    }

    //class method since it's static

    public static void main(String[] args) {
        Map<String, Book> bookCollection = new HashMap<String, Book>();
        Book shoe = new Book("How to properly tie a shoe.", 199, 20418024);
        Book bicycle = new Book("Bicycle routes in Kansas City", 179, 40428719);
        Book color = new Book("The various colors of the rainbow", 274, 89042025);
        Book monorail = new Book("Monorails of the World", 229, 72048947);
        bookCollection.put("How to properly tie a shoe.", shoe);
        bookCollection.put("Bicycle routes in Kansas City", bicycle);
        bookCollection.put("The various colors of the rainbow", color);
        bookCollection.put("Monorails of the World", monorail);
        Main librarycatalogue = new Main(bookCollection);
        librarycatalogue.checkOutBook("How to properly tie a shoe.");
        librarycatalogue.nextDay();
        librarycatalogue.nextDay();
        librarycatalogue.checkOutBook("How to properly tie a shoe.");
        librarycatalogue.setDay(28);
        librarycatalogue.returnBook("How to properly tie a shoe.");
        librarycatalogue.checkOutBook("Bicycle routes in Kansas City");
    }
}
