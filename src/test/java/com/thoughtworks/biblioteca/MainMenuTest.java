package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

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
    private CheckOutBooksCommand checkOutBooksCommand;
    private ReturnBookCommand returnBookCommand;
    private ListMoviesCommand listMoviesCommand;
    private CheckOutMoviesCommand checkOutMoviesCommand;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        commandMap = new HashMap<>();
        listBookCommand = mock(ListBookCommand.class);
        checkOutBooksCommand = mock(CheckOutBooksCommand.class);
        returnBookCommand = mock(ReturnBookCommand.class);
        listMoviesCommand = mock(ListMoviesCommand.class);
        checkOutMoviesCommand = mock(CheckOutMoviesCommand.class);
        commandMap.put("1", listBookCommand);
        commandMap.put("2", checkOutBooksCommand);
        commandMap.put("3", returnBookCommand);
        commandMap.put("4", listMoviesCommand);
        commandMap.put("5", checkOutMoviesCommand);
        menu = new MainMenu(printStream, commandMap);

    }
    @Test
    public void shouldDisplayOptionsWhenStarts(){
        menu.displayOptions();
        verify(printStream).println("Menu:\n" +
                "1 - List Books\n" +
                "2 - Check Out Book\n" +
                "3 - Return Book\n" +
                "4 - List Movies\n" +
                "5 - Check Out Movie\n" +
                "Q - Quit");
    }

    @Test
    public void shouldExecuteCallListBooksWhenKeyIsOne(){
        menu.runCommand("1");
        verify(listBookCommand).execute();
    }

    @Test
    public void shouldDisplayInvalidOptionWhenOptionChoosenIsNotFound(){
        menu.runCommand("adf");
        verify(printStream).println("Invalid option!");
    }

    @Test
    public void shouldExecuteCheckOutBookWhenKeyIsTwo(){
        menu.runCommand("2");
        verify(checkOutBooksCommand).execute();
    }

    @Test
    public void shouldExecuteReturnBookWhenKeyIsThree(){
        menu.runCommand("3");
        verify(returnBookCommand).execute();
    }

    @Test
    public void shouldExecuteListMoviesWhenKeyIsFour(){
        menu.runCommand("4");
        verify(listMoviesCommand).execute();
    }

    @Test
    public void shouldExecuteCheckOutMovieWhenKeyIsFive(){
        menu.runCommand("5");
        verify(checkOutMoviesCommand).execute();
    }
}
