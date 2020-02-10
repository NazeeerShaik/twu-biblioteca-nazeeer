package com.twu.biblioteca;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LibraryTest {
    @ParameterizedTest
    @ValueSource(strings = {"Planning Extreme Programming"})
    void shouldRemoveBookFromBookListAfterCheckOut() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        Library library = new Library();
        library.viewListOfBooks();

        verify(out).println("Domain Specific Languages\tMartin Fowler\t2010");

    }

    @Test
    void shouldAddToCollectionsAfterBookCheckout() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Library library = new Library();
        library.viewListOfBooks();

        verify(out).println("Planning Extreme Programming\tKent Beck\t2000");

    }
}