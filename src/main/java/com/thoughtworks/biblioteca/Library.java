package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by eleones on 9/22/15.
 */
public class Library {
    private List<Book> books;
    private PrintStream printStream;

    public Library(List<Book> books, PrintStream printStream){
        this.books = books;
        this.printStream = printStream;
    }

    public void listBooks() {
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                book.printDetails();
            }
        }
    }

    public void checkOut(String bookTitle) {
        for (Book book : books) {
            if (book.hasTitle(bookTitle)) {
                book.changeCheckOutStatus();
                printStream.println("Thank you! Enjoy the book");
                return;
            }
        }
        printStream.println("Book is not available.");
    }
}
