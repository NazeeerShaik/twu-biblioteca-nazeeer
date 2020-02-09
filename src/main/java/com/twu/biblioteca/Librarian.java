package com.twu.biblioteca;

public class Librarian {
    Library library;

    Librarian() {
        this.library = new Library();
    }

    public void prepare(String bookName) {
        library.addToCollections(bookName);
    }
}
