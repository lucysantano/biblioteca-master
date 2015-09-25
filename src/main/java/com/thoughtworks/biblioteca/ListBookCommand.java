package com.thoughtworks.biblioteca;

/**
 * Created by lsantano on 9/25/15.
 */
public class ListBookCommand implements Command{
    private Library library;

    public ListBookCommand(Library library) {

        this.library = library;
    }

    @Override
    public void execute() {
        library.listBooks();
    }
}
