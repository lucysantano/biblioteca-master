package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by eleones on 9/22/15.
 */
public class Application {

    private PrintStream printStream;
    private MainMenu mainMenu;
    private BufferedReader reader;

    public Application(PrintStream printStream, MainMenu mainMenu, BufferedReader reader) {
        this.printStream = printStream;
        this.mainMenu = mainMenu;
        this.reader = reader;
    }

    public void start() throws IOException {
        printStream.println("Welcome to Biblioteca!");
        mainMenu.displayOptions();
        String option = reader.readLine();
        mainMenu.runCommand(option);
        //while(){ mainMenu.runCommand(option);
        // String option }

    }


}
