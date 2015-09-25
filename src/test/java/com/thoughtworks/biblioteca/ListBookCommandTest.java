package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by lsantano on 9/25/15.
 */
public class ListBookCommandTest {

    private Library library;
    private ListBookCommand listBookCommand;

    @Before
    public void setup() {
        library = mock(Library.class);
        listBookCommand = new ListBookCommand(library);
    }

    @Test
    public void shouldListBooksWhenCommandExecutes() {

        listBookCommand.execute();

        verify(library).listBooks();

    }
}