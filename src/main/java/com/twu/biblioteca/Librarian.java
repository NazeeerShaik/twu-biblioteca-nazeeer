package com.twu.biblioteca;

public class Librarian {
    Library library;

    Librarian() {
        this.library = new Library();
    }

    public boolean processCheckout(String bookName) {
         return library.addToCollections(bookName);
    }

    public boolean processReturn(String bookName) {
        return library.addBook(bookName);
    }
}
