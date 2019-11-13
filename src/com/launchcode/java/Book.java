package com.launchcode.java;

public class Book {

     //Properties, fields, global variables

    String title;
    int pageCount;
    int ISBN;
    boolean checkedOut;
    int dayCheckedOut = -1;

    //constructor

    public Book(String bookTitle, int bookPageCount, int bookISBN){
        this.title = bookTitle;
        this.pageCount = bookPageCount;
        this.ISBN = bookISBN;
        checkedOut = false;
    }

    //getters - instance methods since they  get the
    //value of certain properties within the instance

    public String getTitle(){
        return this.title;
    }

    public int getPageCount(){
        return this.pageCount;
    }

    public int getISBN(){
        return this.ISBN;
    }

    public boolean getCheckedout(){
        return this.checkedOut;
    }
    public int getDayCheckedOut(){
        return this.dayCheckedOut;
    }

        //setters

    public void setCheckedOut(boolean newCheckedOut, int currentDayCheckedOut){
        this.checkedOut = newCheckedOut;
        setDayCheckedOut(currentDayCheckedOut);
    }
    private void setDayCheckedOut(int day){
        this.dayCheckedOut = day;
    }
}
