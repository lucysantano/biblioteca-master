package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        List<Book> bookList = new ArrayList<Book>();
        Book TheHungryCaterpillar = new Book("The Hungry Caterpillar", "Eric Carle", "1969", System.out);
        bookList.add(TheHungryCaterpillar);

        Book GoodnightMoon = new Book("Goodnight, Moon", "Margaret Wise Brown", "1947", System.out);
        bookList.add(GoodnightMoon);

        List<Movie> movieList = new ArrayList<>();
        Movie starWars = new Movie("Star Wars IV", "George Lucas", "1977", "9", System.out);
        movieList.add(starWars);

        Movie jaws = new Movie("Jaws", "Steven Spielberg", "1975", "9", System.out);
        movieList.add(jaws);

        Library library = new Library(bookList, movieList, System.out);

        HashMap<String, Command> commandMap = new HashMap<>();
        commandMap.put("1", new ListBookCommand(library));
        commandMap.put("2", new CheckOutBooksCommand(library, new BufferedReader(new InputStreamReader(System.in)), System.out));
        commandMap.put("3", new ReturnBookCommand(library, new BufferedReader(new InputStreamReader(System.in)), System.out));
        commandMap.put("4", new ListMoviesCommand(library));
        commandMap.put("5", new CheckOutMoviesCommand(library, new BufferedReader(new InputStreamReader(System.in)), System.out));

        MainMenu mainMenu = new MainMenu(System.out, commandMap);

        Application application = new Application(System.out, mainMenu, new BufferedReader(new InputStreamReader(System.in)));
        application.start();
    }
}