package com.thoughtworks.biblioteca;

import java.io.PrintStream;

/**
 * Created by eleones on 9/24/15.
 */
public class Options {
    private Library library;
    private PrintStream printStream;

    public Options(Library library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    public void runSelection(String choice) {
        if (choice.equals("1")) {
            library.listBooks();
        } else {
            printStream.println("Invalid option!");
        }
    }

    public boolean notQuitting(String choice) {

        return !choice.toUpperCase().equals("Q");
    }
}
