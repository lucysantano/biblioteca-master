package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lsantano on 9/25/15.
 */
public class CheckOutMoviesCommandTest {

    private Library library;
    private CheckOutMoviesCommand checkOutMoviesCommand;
    private BufferedReader reader;
    private PrintStream printStream;

    @Before
    public void setup(){
        library = mock(Library.class);
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        checkOutMoviesCommand = new CheckOutMoviesCommand(library,reader,printStream);
    }



    @Test
    public void shouldListMoviesWhenCommandExecutes() throws IOException {
        when(reader.readLine()).thenReturn("MovieTitle");
        checkOutMoviesCommand.execute();
        verify(library).checkOutMovie("MovieTitle");
    }

}