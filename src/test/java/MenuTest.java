import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MenuTest {
    Menu menu = new Menu();
//TODO ::NO TESTS FOR MOVIE CHECKOUT
    @Test
    void shouldDisplayListOfBooksInLibraryIfOptionIsOne() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        menu.respond(1);

        verify(out).println("Book{name='Refactoring', year=2018, authorName='Martin Fowler'}");
        verify(out).println("Book{name='NoSQL Distilled', year=2012, authorName='Pramod J'}");
    }

    @Test
    @ExpectSystemExitWithStatus(0)
    void shouldQuitIfOptionIsFour() {
        menu.respond(6);
    }

    @Test
    void shouldDisplayInvalidMessageIfOptionIsInValid() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        menu.respond(10);

        verify(out).println("Invalid Option!");
    }

    @Test
    void shouldSuccessMessageOnCheckoutSuccess() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        input("Refactoring\n123-4567\npassword");

        menu.respond(2);

        verify(out).println("Thank you! Enjoy the book");
    }

    @Test
    void shouldSuccessMessageOnCheckoutUnSuccess() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        input("hi\n123-4567\npassword");

        menu.respond(2);

        verify(out).println("Sorry, that book is not available");
    }

    @Test
    void shouldDisplaySuccessMessageIfReturnValid() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        input("Refactoring\n123-4567\npassword");
        menu.respond(2);

        input("Refactoring\n123-4567\npassword");
        menu.respond(3);

        verify(out).println("Thank you! Enjoy the book");
        verify(out).println("Thank you for returning the book");
    }

    @Test
    void shouldDisplayUnSuccessMessageIfReturnInValid() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        input("Hello\n765-4321\nPASS");
        menu.respond(3);

        verify(out).println("That is not a valid book to return");
    }

    @Test
    void shouldSuccessMessageOnCheckoutSuccessAfterSuccessFullLogin() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        input("Refactoring\n123-4567\npassword");

        menu.respond(2);

        verify(out).println("Thank you! Enjoy the book");
    }

    private void input(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}