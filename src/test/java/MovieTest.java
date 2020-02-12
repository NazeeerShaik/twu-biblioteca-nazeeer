import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MovieTest {
    @Test
    void shouldDisplayListOfMovies() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Movie movie = new Movie(2009,"Avatar","James Cameron", 7.8);

        movie.view();

        verify(out).println("Movie{" +
                "year=" + 2009 +
                ", name='" + "Avatar" + '\'' +
                ", director='" + "James Cameron" + '\'' +
                ", rating=" + 7.8 +
                '}');
    }

    @Test
    void shouldReturnTrueIfMovieIsAvailable() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Movie movie = new Movie(2009,"Avatar","James Cameron", 7.8);

        Assertions.assertTrue(movie.has("Avatar"));
    }

    @Test
    void shouldReturnFalseIfMovieIsAvailable() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Movie movie = new Movie(2009,"Avatar","James Cameron", 7.8);

        Assertions.assertFalse(movie.has("Titanic"));
    }
}