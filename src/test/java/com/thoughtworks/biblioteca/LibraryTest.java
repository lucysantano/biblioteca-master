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


    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        bookList = new ArrayList();
        book = mock(Book.class);
        bookList.add(book);
        library = new Library(bookList, printStream);
    }


    @Test
    public void shouldPrintBookDetailsWhenListingBooks() {
        library.listBooks();
        verify(book).printDetails();
    }

    @Test
    public void shouldChangeCheckoutStatusWhenCheckedOut(){
        when(book.hasTitle("Book1")).thenReturn(true);

        library.checkOut("Book1");

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

        library.checkOut("Book1");

        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldNotSeeFailureMessageWhenUserChecksOutABook() {
        when(book.hasTitle("Book1")).thenReturn(true);

        library.checkOut("Book1");

        verify(printStream, never()).println("Book is not available.");
    }

    @Test
    public void shouldSeeErrorMessageWhenUserTriesToCheckOutABookThatIsNotAvailable() {
        when(book.hasTitle("Book1")).thenReturn(false);

        library.checkOut("Book1");

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

        library.checkOut("book1");
        library.returnBook("book1");
        library.listBooks();

        verify(book).printDetails();
    }
}