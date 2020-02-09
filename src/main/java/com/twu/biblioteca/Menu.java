package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer,String> options = new HashMap<>();

    private void setOptions(){
        options.put(1,"List of books");
    }
    public void displayMenu(){
        options.forEach((key,value)-> System.out.println(key+" "+value));
    }
}