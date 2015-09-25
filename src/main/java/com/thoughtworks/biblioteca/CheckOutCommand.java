package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by lsantano on 9/25/15.
 */
public class CheckOutCommand implements Command {
    private Library library;
    private BufferedReader reader;
    private PrintStream printStream;

    public CheckOutCommand(Library library,BufferedReader reader,PrintStream printStream) {

        this.library = library;
        this.reader = reader;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.println("Please enter a book title:");
        String bookTitle = null;
        try {
            bookTitle = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        library.checkOut(bookTitle);
    }
}
