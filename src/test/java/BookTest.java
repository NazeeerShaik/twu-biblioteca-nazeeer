import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BookTest {
    @Test
    void shouldDisplayDetailsOfBook() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Book book = new Book("Refactoring","Martin Fowler",2018);

        book.view();

        verify(out).println("Book{" +
                "name='" +"Refactoring"  + '\'' +
                ", year=" + 2018 +
                ", authorName='" + "Martin Fowler" + '\'' +
                '}');
    }
}