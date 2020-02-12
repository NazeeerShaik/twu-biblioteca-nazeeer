import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LibrarianTest {
    Librarian librarian = new Librarian();

    @Test
    void shouldSuccessMessageOnCheckoutSuccess() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        librarian.checkout("123-4567","Refactoring");

        verify(out).println("Thank you! Enjoy the book");
    }

    @Test
    void shouldSuccessMessageOnCheckoutUnSuccess() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        librarian.checkout("123-4567","hi");

        verify(out).println("Sorry, that book is not available");
    }

    @Test
    void shouldDisplaySuccessMessageIfReturnValid() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        librarian.checkout("123-4567","Refactoring");
        librarian.returnBook("Refactoring");

        verify(out).println("Thank you! Enjoy the book");
        verify(out).println("Thank you for returning the book");
    }


    @Test
    void shouldDisplayUnSuccessMessageIfReturnInValid() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);


        librarian.returnBook("Hello");

        verify(out).println("That is not a valid book to return");
    }

    @Test
    void shouldDisplayDetailsOfRecords() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        librarian.checkout("123-4567","Refactoring");
        librarian.records();

        verify(out).println("Thank you! Enjoy the book");
        verify(out).println("123-4567 Refactoring");
    }
}