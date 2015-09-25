package com.thoughtworks.biblioteca;

import java.io.PrintStream;

/**
 * Created by lsantano on 9/25/15.
 */
public class Movie {
    private String name;
    private String year;
    private String director;
    private String rating;
    private PrintStream printStream;
    private boolean checkedOut;

    public Movie(String name, String year, String director, String rating, PrintStream printStream) {

        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.printStream = printStream;
        this.checkedOut = false;
    }



    public void printDetails() {
        String bookDetails = String.format("%-30s| %-30s| %-30s| %s", name, director, year, rating);
        printStream.println(bookDetails);
    }

    public boolean hasTitle(String movieTitle) {
        return movieTitle.equals(name);
    }

    public void changeCheckOutStatus() {
        this.checkedOut = !this.checkedOut;
    }

    public boolean isCheckedOut() {
        return this.checkedOut;
    }
}
