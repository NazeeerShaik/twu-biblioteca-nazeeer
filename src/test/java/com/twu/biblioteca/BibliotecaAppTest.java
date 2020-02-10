package com.twu.biblioteca;

import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {
    @Test
    void shouldDisplayWelcomeMessageOnAppStart() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        BibliotecaApp.start();

        verify(out).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    void shouldDisplayListOfAllLibraryBooksAfterSelectingOptionOne(int optionNumber) {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        BibliotecaApp.respondToOption(optionNumber);

        verify(out).println("Planning Extreme Programming\tKent Beck\t2000");
        verify(out).println("Domain Specific Languages\tMartin Fowler\t2010");
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void shouldDisplayErrorNotificationMessageIfOptionIsInvalid(int optionNumber) {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        BibliotecaApp.respondToOption(optionNumber);

        verify(out).println("Please select a valid option!");
    }

    @ParameterizedTest
    @ValueSource(ints = {2})
    @ExpectSystemExitWithStatus(0)
    void shouldQuitFromApplicationIfOptionIsQuit(int optionNumber) {

        BibliotecaApp.respondToOption(optionNumber);
    }


    @ParameterizedTest
    @ValueSource(strings = {"Planning Extreme Programming"})
    void shouldReturnSuccessMessageOnCheckoutOfBook(String bookName) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        bibliotecaApp.checkOutBook(bookName);

        verify(out).println("Thank you! Enjoy the book");

    }

    @ParameterizedTest
    @ValueSource(strings = {"NoSQL Distilled"})
    void shouldReturnUnSuccessMessageOnCheckoutOfBook(String bookName) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        bibliotecaApp.checkOutBook(bookName);

        verify(out).println("Sorry, that book is not available");

    }

    @ParameterizedTest
    @ValueSource(strings = {"Planning Extreme Programming"})
    void shouldDisplaySuccessMessageIfReturnIsValid(String bookName) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        bibliotecaApp.checkOutBook(bookName);
        bibliotecaApp.returnBook(bookName);

        verify(out).println("Thank you! Enjoy the book");
        verify(out).println("Thank you for returning the book");

    }


}
