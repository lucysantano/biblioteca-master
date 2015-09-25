package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;


/**
 * Created by eleones on 9/22/15.
 */
public class ApplicationTest {

    private Application application;
    private PrintStream printStream;
    private MainMenu mainMenu;
    private BufferedReader reader;


    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        mainMenu = mock(MainMenu.class);
        reader = mock(BufferedReader.class);
        application = new Application(printStream, mainMenu, reader);
    }

    @Test
    public void shouldPrintWelcomeWhenStarting() throws IOException {
        when(reader.readLine()).thenReturn("Q");
        application.start();
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldCallListBooksWhenStarting() throws IOException {
        when(reader.readLine()).thenReturn("Q");
        application.start();
        verify(mainMenu).displayOptions();
    }

    @Test
    public void shouldReadInputWhenStarting() throws IOException {
        when(reader.readLine()).thenReturn("Q");
        application.start();
        verify(reader).readLine();
    }

    @Test
    public void shouldRunCommandWhenUserInputsACommand() throws IOException {
        when(reader.readLine()).thenReturn("1","Q");

        application.start();

        verify(mainMenu).runCommand("1");

    }

    @Test
    public void shouldContinueToAcceptCommandsUntilQuitting() throws IOException {
        when(reader.readLine()).thenReturn("1","1","Q");

        application.start();

        verify(mainMenu, times(2)).runCommand("1");
    }



}
