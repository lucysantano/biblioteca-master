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

        Library library = new Library(bookList, System.out);

        HashMap<String, Command> commandMap = new HashMap<>();
        commandMap.put("1", new ListBookCommand(library));
        commandMap.put("2", new CheckOutCommand(library, new BufferedReader(new InputStreamReader(System.in)), System.out));

        MainMenu mainMenu = new MainMenu(System.out, commandMap);

        Application application = new Application(System.out, mainMenu, new BufferedReader(new InputStreamReader(System.in)));
        application.start();
    }
}