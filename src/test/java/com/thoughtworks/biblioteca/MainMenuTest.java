package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

/**
 * Created by eleones on 9/23/15.
 */
public class MainMenuTest {
    private PrintStream printStream;
    private MainMenu menu;
    private HashMap<String,Command> commandMap;
    private ListBookCommand listBookCommand;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        commandMap = new HashMap<>();
        listBookCommand = mock(ListBookCommand.class);
        commandMap.put("1", listBookCommand);
        menu = new MainMenu(printStream, commandMap);

    }
    @Test
    public void shouldDisplayOptionsWhenStarts(){
        menu.displayOptions();
        verify(printStream).println("Menu:\n" +
                "1 - List Books\n" +
                "Q - Quit");
    }

    @Test
    public void shouldCallListBooksExecuteWhenKeyIsOne(){
        menu.runCommand("1");
        verify(listBookCommand).execute();
    }

    @Test
    public void shouldDisplayInvalidOptionWhenOptionChoosenIsNotFound(){
        menu.runCommand("adf");
        verify(printStream).println("Invalid option!");
    }
}