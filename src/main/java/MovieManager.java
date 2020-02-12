import java.util.ArrayList;
import java.util.List;

public class MovieManager {

    private List<Movie> movieList = new ArrayList<>();

    MovieManager() {
        movieList.add(new Movie(2009, "Avatar", "James Cameron", 7.8));
        movieList.add(new Movie(2019, "Avengers: Endgame", "Russo brothers", 8.5));
    }

    public void display() {
        for (Movie movie : movieList) {
            movie.view();
        }
    }

    public void checkoutMovie(String movieName) {
        movieList.removeIf(movie -> movie.has(movieName));
    }
}
