package com.twu.biblioteca;

public class Librarian {
    Library library;

    Librarian() {
        this.library = new Library();
    }

    public boolean prepare(String bookName) {
         return library.addToCollections(bookName);
    }

    public void addBook(String bookName) {
        library.addBook(bookName);
    }
}
