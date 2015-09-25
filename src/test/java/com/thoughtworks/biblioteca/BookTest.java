package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eleones on 9/23/15.
 */
public class BookTest {

    private Book book;
    private PrintStream printStream;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        book = new Book("The Hungry Caterpillar", "Eric Carle", "1969", printStream);
    }

    @Test
    public void shouldFormatDetailsIntoColumnsWhenPrintingDetails() {
        book.printDetails();

        verify(printStream).println("The Hungry Caterpillar        | Eric Carle                    | 1969");
    }

    @Test
    public void shouldReturnTrueIfBookHasTitle() {
        assertTrue(book.hasTitle("The Hungry Caterpillar"));
    }

    @Test
    public void shouldReturnFalseIfBookDoesNotHaveTitle() {
        assertFalse(book.hasTitle("The Hungry"));
    }

    @Test
    public void shouldSetStatusToTrueWhenCheckedOut(){
        book.changeCheckOutStatus();
        assertTrue(book.isCheckedOut());
    }


}