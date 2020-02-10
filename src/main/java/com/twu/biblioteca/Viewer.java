package com.twu.biblioteca;

public class Viewer {
    private final Library library;

    public Viewer(Library library) {
        this.library = library;
    }

    public void displayBooks() {
        for (Book book : library.getBookList()) {
            book.view();
        }
    }
}