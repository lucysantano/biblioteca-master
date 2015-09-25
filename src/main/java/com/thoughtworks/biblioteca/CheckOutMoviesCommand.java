package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by lsantano on 9/25/15.
 */
public class CheckOutMoviesCommand implements Command {
    private Library library;
    private BufferedReader reader;
    private PrintStream printStream;

    public CheckOutMoviesCommand(Library library, BufferedReader reader, PrintStream printStream) {

        this.library = library;
        this.reader = reader;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.println("Please enter a movie title:");
        String movieTitle = null;
        try {
            movieTitle = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        library.checkOutMovie(movieTitle);

    }
}
