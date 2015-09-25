package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by eleones on 9/24/15.
 */
public class OptionsTest {

    private Library library;
    private Options options;
    private PrintStream printStream;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        options = new Options(library,printStream);
    }

    @Test
    public void shouldListBooksWhenOptionIsOne() {
        options.runSelection("1");
        verify(library).listBooks();
    }

    @Test
    public void shouldGiveErrorMessageWhenOptionIsInvalid() throws IOException {
        options.runSelection("afd");
        verify(printStream).println("Invalid option!");
    }

    @Test
    public void shouldReturnFalseWhenNotQuitting() {

        assertFalse(options.notQuitting("Q"));
    }

    @Test
    public void shouldReturnTrueWhenNotQuitting() {

        assertTrue(options.notQuitting("1"));
    }

}