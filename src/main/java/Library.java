import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    //TODO: new ArrayList not required
    private List<Book> books = new ArrayList<>(Arrays.asList(new Book("Refactoring", "Martin Fowler", 2018), new Book("NoSQL Distilled", "Pramod J", 2012)));
    private List<Movie> movies = new ArrayList<>();
    Library(){
        movies.add(new Movie(2009, "Avatar", "James Cameron", 7.8));
        movies.add(new Movie(2019, "Avengers: Endgame", "Russo brothers", 8.5));
    }

    public void showAllBooks() {
        for (Book book : books) {
            book.view();
        }
    }
    public void showAllMovies() {
        for (Movie movie : movies) {
            movie.view();
        }
    }

    public void checkoutMovie(String movieName) {

        movies.removeIf(movie -> movie.has(movieName));
    }
    public boolean hasBook(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName)) return true;
        }
        return false;
    }

    public Book getBook(String bookName) {
        for (Book book : books) {
            if (book.has(bookName)) return book;
        }
        return null;
    }

    public void remove(Book book) {
        books.remove(book);
    }

    public void add(Book book) {
        books.add(book);
    }
}
