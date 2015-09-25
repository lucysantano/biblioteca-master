package com.thoughtworks.biblioteca;

/**
 * Created by lsantano on 9/25/15.
 */
public class ListMoviesCommand implements Command{
    private Library library;

    public ListMoviesCommand(Library library) {

        this.library = library;
    }

    @Override
    public void execute() {
        library.listMovies();
    }
}
