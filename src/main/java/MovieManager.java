import java.util.ArrayList;
import java.util.List;

public class MovieManager {

    private List<Movie> movieList = new ArrayList<>();
    MovieManager(){
        movieList.add(new Movie(2009,"Avatar","James Cameron", 7.8));
    }

    public void display() {
        for(Movie movie:movieList){
            movie.view();
        }
    }
}
