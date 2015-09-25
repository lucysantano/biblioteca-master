package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by eleones on 9/22/15.
 */
public class Library {
    private List<Book> books;
    private List<Movie> movies;
    private PrintStream printStream;

    public Library(List<Book> books, List<Movie> movies, PrintStream printStream){
        this.books = books;
        this.movies = movies;
        this.printStream = printStream;
    }

    public void listBooks() {
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                book.printDetails();
            }
        }
    }

    public void checkOutBook(String bookTitle) {
        Book foundBook = findBookBy(bookTitle);
        if (foundBook != null){
            foundBook.changeCheckOutStatus();
            printStream.println("Thank you! Enjoy the book.");
        } else {
            printStream.println("Book is not available.");
        }
    }

    public void returnBook(String bookTitle) {
        Book foundBook = findBookBy(bookTitle);

        if (foundBook != null){
            foundBook.changeCheckOutStatus();
            printStream.println("Thank you for returning the book.");
        }
        else{
            printStream.println("That is not a valid book to return.");
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

    public void listMovies() {
        for (Movie movie : movies) {
            if(!movie.isCheckedOut()){
                movie.printDetails();
            }
        }
    }

    public void checkOutMovie(String movieTitle) {
        Movie foundMovie = findMovieBy(movieTitle);
        if (foundMovie != null){
            foundMovie.changeCheckOutStatus();
            printStream.println("Thank you! Enjoy the movie.");
        } else {
            printStream.println("Movie is not available.");
        }
    }

    private Movie findMovieBy(String movieTitle) {
        Movie foundmovie = null;
        for (Movie movie : movies) {
            if (movie.hasTitle(movieTitle)) {
                foundmovie = movie;
                break;
            }
        }
        return foundmovie;
    }
}
