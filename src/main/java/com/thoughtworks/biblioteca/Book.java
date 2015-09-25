package com.thoughtworks.biblioteca;

import java.io.PrintStream;

/**
 * Created by eleones on 9/22/15.
 */
public class Book {
    private boolean checkedOut;
    private String title;
    private String author;
    private String year;
    private PrintStream printStream;

    public Book(String title, String author, String year, PrintStream printStream){
        this.title = title;
        this.author = author;
        this.year = year;
        this.printStream =printStream;
        this.checkedOut = false;
    }

    public void printDetails() {
        String bookDetails = String.format("%-30s| %-30s| %s", title, author, year);
        printStream.println(bookDetails);
    }

    public void changeCheckOutStatus() {
        this.checkedOut = !this.checkedOut;
    }

    public boolean hasTitle(String bookTitle) {
        return bookTitle.equals(title);
    }

    public boolean isCheckedOut() {
        return this.checkedOut;
    }
}
