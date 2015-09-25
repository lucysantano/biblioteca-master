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
public class CheckOutCommandTest {

    private Library library;
    private CheckOutCommand checkOutCommand;
    private BufferedReader reader;
    private PrintStream printStream;

    @Before
    public void setup() {
        library = mock(Library.class);
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        checkOutCommand = new CheckOutCommand(library,reader,printStream);
    }

    @Test
    public void shouldListBooksWhenCommandExecutes() throws IOException {
        when(reader.readLine()).thenReturn("BookTitle");
        checkOutCommand.execute();
        verify(library).checkOut("BookTitle");
    }

}