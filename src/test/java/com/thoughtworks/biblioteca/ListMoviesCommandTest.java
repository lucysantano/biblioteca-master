package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by lsantano on 9/25/15.
 */
public class ListMoviesCommandTest {

    private Library library;
    private ListMoviesCommand listMoviesCommand;

    @Before
    public void setup(){
        library = mock(Library.class);
        listMoviesCommand = new ListMoviesCommand(library);
    }



    @Test
    public void shouldListMoviesWhenCommandExecutes(){
        listMoviesCommand.execute();
        verify(library).listMovies();
    }
}