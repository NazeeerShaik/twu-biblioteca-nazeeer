package com.twu.biblioteca;

public class Book {

    private final String author;
    private final int year;
    private final String name;

    Book(String author, String name, int year) {
        this.author = author;
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void view() {
        System.out.println(this.name + "\t" + this.author + "\t" + this.year);
    }
}
