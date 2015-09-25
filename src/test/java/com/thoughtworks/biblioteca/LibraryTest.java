package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


/**
 * Created by eleones on 9/22/15.
 */
public class LibraryTest {
    private Library library;
    private PrintStream printStream;
    private ArrayList<Book> bookList;
    private Book book;
    private ArrayList<Movie> movieList;
    private Movie movie;


    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        bookList = new ArrayList<>();
        book = mock(Book.class);
        bookList.add(book);
        movieList = new ArrayList<>();
        movie = mock(Movie.class);
        movieList.add(movie);
        library = new Library(bookList, movieList, printStream);
    }


    @Test
    public void shouldPrintBookDetailsWhenListingBooks() {
        library.listBooks();
        verify(book).printDetails();
    }

    @Test
    public void shouldChangeCheckoutStatusWhenBookIsCheckedOut(){
        when(book.hasTitle("Book1")).thenReturn(true);

        library.checkOutBook("Book1");

        verify(book).changeCheckOutStatus();
    }

    @Test
    public void shouldNotPrintBookDetailsWhenABookIsCheckedOut() {
        when(book.isCheckedOut()).thenReturn(true);

        library.listBooks();

        verify(book, never()).printDetails();
    }

    @Test
     public void shouldSeeSuccessMessageWhenUserChecksOutABook() {
        when(book.hasTitle("Book1")).thenReturn(true);

        library.checkOutBook("Book1");

        verify(printStream).println("Thank you! Enjoy the book.");
    }

    @Test
    public void shouldNotSeeFailureMessageWhenUserChecksOutABook() {
        when(book.hasTitle("Book1")).thenReturn(true);

        library.checkOutBook("Book1");

        verify(printStream, never()).println("Book is not available.");
    }

    @Test
    public void shouldSeeErrorMessageWhenUserTriesToCheckOutABookThatIsNotAvailable() {
        when(book.hasTitle("Book1")).thenReturn(false);

        library.checkOutBook("Book1");

        verify(printStream).println("Book is not available.");
    }

    @Test
    public void shouldChangeCheckoutStatusWhenReturningBook(){
        when(book.hasTitle("Book1")).thenReturn(true);

        library.returnBook("Book1");

        verify(book).changeCheckOutStatus();

    }

    @Test
    public void shouldPrintBookDetailsWhenABookIsReturned() {
        when(book.hasTitle("book1")).thenReturn(true, true);
        when(book.isCheckedOut()).thenReturn(false, true);

        library.checkOutBook("book1");
        library.returnBook("book1");
        library.listBooks();

        verify(book).printDetails();
    }

    @Test
    public void shouldSeeSuccessMessageWhenUserReturnsABook() {
        when(book.hasTitle("Book1")).thenReturn(true);

        library.returnBook("Book1");

        verify(printStream).println("Thank you for returning the book.");
    }

    @Test
    public void shouldNotSeeFailureMessageWhenUserReturnsABook() {
        when(book.hasTitle("Book1")).thenReturn(true);

        library.returnBook("Book1");

        verify(printStream, never()).println("That is not a valid book to return.");
    }

    @Test
    public void shouldSeeErrorMessageWhenUserTriesToReturnABookThatIsNotAvailable() {
        when(book.hasTitle("Book1")).thenReturn(false);

        library.returnBook("Book1");

        verify(printStream).println("That is not a valid book to return.");
    }

    @Test
    public void shouldDisplayAllMovieDetailsWhenListingMovies(){
        library.listMovies();
        verify(movie).printDetails();
    }

    @Test
    public void shouldChangeCheckoutStatusWhenMovieIsCheckedOut(){
        when(movie.hasTitle("MovieTitle")).thenReturn(true);

        library.checkOutMovie("MovieTitle");

        verify(movie).changeCheckOutStatus();
    }

    @Test
    public void shouldNotPrintMovieDetailsWhenAMovieIsCheckedOut() {
        when(movie.isCheckedOut()).thenReturn(true);

        library.listMovies();

        verify(movie, never()).printDetails();
    }

}