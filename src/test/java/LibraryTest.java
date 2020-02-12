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

        Assertions.assertTrue(library.hasBook("Refactoring"));
    }

    @Test
    void shouldReturnFalseIfBookIsUnAvailable() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        Assertions.assertFalse(library.hasBook("Java"));
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

    @Test
    void shouldDisplayListOfMovies() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        library.showAllMovies();


        verify(out).println("Movie{" +
                "year=" + 2009 +
                ", name='" + "Avatar" + '\'' +
                ", director='" + "James Cameron" + '\'' +
                ", rating=" + 7.8 +
                '}');
        verify(out).println("Movie{" +
                "year=" + 2019 +
                ", name='" + "Avengers: Endgame" + '\'' +
                ", director='" + "Russo brothers" + '\'' +
                ", rating=" + 8.5 +
                '}');
    }

    @Test
    void shouldAbleToCheckOutMovie() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        library.checkoutMovie("Avatar");
        library.showAllMovies();

        verify(out).println("Movie{" +
                "year=" + 2019 +
                ", name='" + "Avengers: Endgame" + '\'' +
                ", director='" + "Russo brothers" + '\'' +
                ", rating=" + 8.5 +
                '}');
    }
}