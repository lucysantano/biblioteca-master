package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


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
    public void shouldTrueWhenCheckedOut(){
        when(book.hasTitle("Book1")).thenReturn(true);

        library.checkOut("Book1");

        verify(book).changeCheckOutStatus();
    }


}