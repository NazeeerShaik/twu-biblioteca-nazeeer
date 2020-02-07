package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class BibliotecaApp {
    private final List<String> books = new ArrayList<>(asList("1.Planning Extreme Programming", "2.Domain Specific Languages"));

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    public void start() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
        viewBooks();
    }

    private void viewBooks() {
        for (String book : books) {
            System.out.println(book);
        }
    }
}
