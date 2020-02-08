package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {

    @Test
    void shouldDisplayWelcomeMessageOnAppStart() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        BibliotecaApp.main(new String[]{});

        verify(out).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    void shouldDisplayListOfAllLibraryBooksAfterWelcomeMessage() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        BibliotecaApp.main(new String[]{});

        verify(out).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        verify(out).println("NAME\tAUTHOR\tYEAR");
        verify(out).println("Planning Extreme Programming\tKent Beck\t2000");
        verify(out).println("Domain Specific Languages\tMartin Fowler\t2010");
    }

}
