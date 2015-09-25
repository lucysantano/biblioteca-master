package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eleones on 9/23/15.
 */
public class BookTest {

    @Test
    public void shouldFormatDetailsIntoColumnsWhenPrintingDetails() {
        PrintStream printStream = mock(PrintStream.class);
        Book book = new Book("The Hungry Caterpillar", "Eric Carle", "1969", printStream);

        book.printDetails();

        verify(printStream).println("The Hungry Caterpillar        | Eric Carle                    | 1969");
    }
}