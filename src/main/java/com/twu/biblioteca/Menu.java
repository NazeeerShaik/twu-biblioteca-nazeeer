package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, String> options = new HashMap<>();

    private void setOptions() {
        options.put(1, "List of books");
        options.put(2, "Quit");
        options.put(3, "check out");
        options.put(4,"return");
    }

    public void displayMenu() {
        setOptions();
        options.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
