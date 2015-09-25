package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by lsantano on 9/25/15.
 */
public class MovieTest {

    Movie movie;
    PrintStream printStream;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        movie = new Movie("name", "year", "director", "rating", printStream);
    }


    @Test
    public void shouldDisplayMovieDetailsInCorrectFormatWhenPrintingDetails() {
        movie.printDetails();

        verify(printStream).println("name                          | director                      | year                          | rating");
    }
}
