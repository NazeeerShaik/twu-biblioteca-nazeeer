package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Library {

    private final Book book1 = new Book("Kent Beck", "Planning Extreme Programming", 2000);
    private final Book book2 = new Book("Martin Fowler", "Domain Specific Languages", 2010);

    private List<Book> bookList = new ArrayList<>(asList(book1, book2));
    private List<Book> collections = new ArrayList<>(); // TODO - how is someone supposed to come to know about it?

    public  void viewListOfBooks() {
        for (Book book : bookList) {
            book.view();
        }
    }

    // TODO - CQS, anyone?
    public boolean addToCollections(String bookName) {
        for (Book book : bookList) {
            if (bookName.equals(book.getName())) {
                collections.add(book);
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }
    public void viewListOfCollectedBooks(){
        for(Book book:collections){
            book.view();
        }
    }

    public boolean addBook(String bookName) {
        for(Book book:collections){
            if(book.getName().equals(bookName)){
                bookList.add(book);
                collections.remove(book);
                return true;
            }
        }
        return false;
    }
}
