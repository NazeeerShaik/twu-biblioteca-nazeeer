import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LibraryTest {

    Library library = new Library();

    @Test
    void shouldDisplayListOfBooks() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        library.showAllBooks();

        verify(out).println("Book{" +
                "name='" +"Refactoring"  + '\'' +
                ", year=" + 2018 +
                ", authorName='" + "Martin Fowler" + '\'' +
                '}');
        verify(out).println("Book{" +
                "name='" +"NoSQL Distilled"  + '\'' +
                ", year=" + 2012 +
                ", authorName='" + "Pramod J" + '\'' +
                '}');
    }

    @Test
    void shouldReturnTrueIfBookIsAvailable() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        Assertions.assertTrue(library.has("Refactoring"));
    }

    @Test
    void shouldReturnFalseIfBookIsUnAvailable() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        Assertions.assertFalse(library.has("Java"));
    }

    @Test
    void shouldRemoveBookAfterCheckout() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Book book = new Book("Refactoring","Martin Fowler",2018);
        library.remove(book);
        library.showAllBooks();

        verify(out).println("Book{" +
                "name='" +"NoSQL Distilled"  + '\'' +
                ", year=" + 2012 +
                ", authorName='" + "Pramod J" + '\'' +
                '}');
    }

    @Test
    void shouldAddBookAfterReturn() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Book book = new Book("Refactoring","Martin Fowler",2018);
        library.remove(book);
        library.add(book);
        library.showAllBooks();

        verify(out).println("Book{" +
                "name='" +"NoSQL Distilled"  + '\'' +
                ", year=" + 2012 +
                ", authorName='" + "Pramod J" + '\'' +
                '}');
        verify(out).println("Book{" +
                "name='" +"Refactoring"  + '\'' +
                ", year=" + 2018 +
                ", authorName='" + "Martin Fowler" + '\'' +
                '}');
    }
}