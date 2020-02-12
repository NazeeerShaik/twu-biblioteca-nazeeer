import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MenuTest {
    Menu menu = new Menu();

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
        menu.respond(4);
    }

    @Test
    void shouldDisplayInvalidMessageIfOptionIsInValid() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        menu.respond(5);

        verify(out).println("Invalid Option!");
    }

    @Test
    void shouldSuccessMessageOnCheckoutSuccess() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        input("Refactoring");

        menu.respond(2);

        verify(out).println("Thank you! Enjoy the book");
    }

    @Test
    void shouldSuccessMessageOnCheckoutUnSuccess() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        input("hi");

        menu.respond(2);

        verify(out).println("Sorry, that book is not available");
    }

    @Test
    void shouldDisplaySuccessMessageIfReturnValid(){
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        input("Refactoring");
        menu.respond(2);

        input("Refactoring");
        menu.respond(3);


        verify(out).println("Thank you! Enjoy the book");
        verify(out).println("Thank you for returning the book");
    }

    private void input(String bookName) {
        InputStream inputStream = new ByteArrayInputStream(bookName.getBytes());
        System.setIn(inputStream);
    }

    @Test
    void shouldDisplayUnSuccessMessageIfReturnInValid() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        input("Hello");
        menu.respond(3);

        verify(out).println("That is not a valid book to return");
    }
}