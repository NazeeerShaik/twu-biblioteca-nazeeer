package com.twu.biblioteca;

import java.util.List;

import static java.util.Arrays.asList;

public class Library {

    private final Book book1 = new Book("Kent Beck", "Planning Extreme Programming", 2000);
    private final Book book2 = new Book("Martin Fowler", "Domain Specific Languages", 2010);

    private  List<Book> bookList = asList(book1, book2);

    public void viewListOfBooks(){
        for(Book book:bookList) {
            book.view();
        }
    }


}
