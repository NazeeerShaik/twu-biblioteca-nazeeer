import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MovieManagerTest {

    MovieManager movieManager = new MovieManager();

    @Test
    void shouldDisplayListOfMovies() {
        PrintStream out =mock(PrintStream.class);
        System.setOut(out);

        movieManager.display();


        verify(out).println("Movie{" +
                "year=" + 2009 +
                ", name='" + "Avatar" + '\'' +
                ", director='" + "James Cameron" + '\'' +
                ", rating=" + 7.8 +
                '}');
    }
}
