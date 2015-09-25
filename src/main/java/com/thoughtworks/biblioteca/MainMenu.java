package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

/**
 * Created by eleones on 9/23/15.
 */
public class MainMenu {
    private PrintStream printStream;
    private HashMap<String, Command> commandMap;

    MainMenu(PrintStream printStream, HashMap<String, Command> commandMap){
        this.printStream = printStream;
        this.commandMap = commandMap;
    }

    public void displayOptions(){
        printStream.println("Menu:\n" +
                "1 - List Books\n" +
                "2 - Check Out Book\n" +
                "3 - Return Book\n" +
                "4 - List Movies\n" +
                "5 - Check Out Movie\n" +
                "Q - Quit");
    }

    public void runCommand(String option) {
        if(commandMap.containsKey(option)) {
            commandMap.get(option).execute();
        }
        else{
            printStream.println("Invalid option!");
        }
    }
}
