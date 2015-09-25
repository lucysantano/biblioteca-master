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
        Book foundBook = findBookBy(bookTitle);
        if (foundBook != null){
            foundBook.changeCheckOutStatus();
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("Book is not available.");
        }
    }

    private Book findBookBy(String bookTitle) {
        Book foundBook = null;
        for (Book book : books) {
            if (book.hasTitle(bookTitle)) {
                foundBook = book;
                break;
            }
        }
        return foundBook;
    }

    public void returnBook(String bookTitle) {
        Book foundBook = findBookBy(bookTitle);

        if (foundBook != null){
            foundBook.changeCheckOutStatus();
        }
    }
}
