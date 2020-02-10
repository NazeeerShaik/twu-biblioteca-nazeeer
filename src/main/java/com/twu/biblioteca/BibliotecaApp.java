package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private  Librarian librarian= new Librarian();
    public static void main(String[] args) {
        start();
        Menu menu = new Menu();
        menu.displayMenu();
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        respondToOption(option);
    }

    public static void respondToOption(int optionNumber) {
        if (optionNumber == 1) viewBooks();
        else if (optionNumber == 2) System.exit(0);
        else if (optionNumber == 3) System.out.println("checkout");
        else if (optionNumber == 4 ) System.out.println("return");
        else System.out.println("Please select a valid option!");
    }

    public void checkOutBook(String bookName) {
        if(librarian.prepare(bookName)) System.out.println("Thank you! Enjoy the book");
        else System.out.println("Sorry, that book is not available");
    }
    public void returnBook(String bookName){
        if(librarian.addBook(bookName)) System.out.println("Thank you for returning the book");
    }

    public static void start() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

    private static void viewBooks() {
        System.out.println("NAME\tAUTHOR\tYEAR");
        Library library = new Library();
        library.viewListOfBooks();
    }
}
