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
        printStream.println("Menu:\n1 - List Books\n2 - Check Out Book\nQ - Quit");
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
