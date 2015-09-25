package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
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
    private BufferedReader reader;
    private Options options;
    private HashMap<String,Command> commandMap;
    private ListBookCommand listBookCommand;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        options = mock(Options.class);
        commandMap = new HashMap<>();
        listBookCommand = mock(ListBookCommand.class);
        commandMap.put("1", listBookCommand);
        menu = new MainMenu(printStream, reader, options, commandMap);

    }
    @Test
    public void shouldDisplayOptionsWhenStarts() throws IOException {
        when(reader.readLine()).thenReturn("0","Q");

        menu.displayOptions();

        verify(printStream).println("Menu:\n" +
                "1 - List Books\n" +
                "Q - Quit");
    }

    @Test
    public void shouldCallOptionWhenOptionIsInputted() throws IOException {
        when(reader.readLine()).thenReturn("1","Q");
        menu.displayOptions();
        verify(options).runSelection("1");
    }

    @Test
    public void shouldCallListBooksExecuteWhenKeyIsOne(){
        menu.runCommand("1");
        verify(listBookCommand).execute();
    }
}