package com.twu.biblioteca;

// TODO - what is the behaviour of this class?
// TODO - how is librarian different from library?
// TODO - no test.
public class Librarian {
    Library library;

    Librarian() {
        this.library = new Library();
    }

    // TODO - what does prepare mean?
    public boolean prepare(String bookName) {
         return library.addToCollections(bookName);
    }

    public boolean addBook(String bookName) {
        return library.addBook(bookName);
    }
}
