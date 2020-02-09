package com.twu.biblioteca;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.mismatch;

public class BibliotecaApp {
    private static final List<String> books = asList("Planning Extreme Programming", "Domain Specific Languages");

    public static void main(String[] args) {
        new BibliotecaApp().start();
        Menu menu = new Menu();
        menu.displayMenu();
    }
    public static void getOption(int opinionNumber){
        if(opinionNumber == 1) viewBooks();
    }
    private  void start() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

    private static void viewBooks() {
        System.out.println("NAME\tAUTHOR\tYEAR");
        Library library = new Library();
        library.viewListOfBooks();
    }
}
