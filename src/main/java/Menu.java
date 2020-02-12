import java.util.*;

public class Menu {

    //TODO:Print stream out
    private Library library = new Library();
    private Librarian librarian = new Librarian();
    private Map<Integer, String> options = new HashMap<>();


    public void displayMenu() {
        setOptions();
        options.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public void respond(int option) {//TODO :if else ladder
        final int viewListOfBooks = 1;
        final int checkoutBook = 2;
        final int returnBook = 3;
        final int viewListOfMovies = 4;
        final int checkoutMovie = 5;
        final int quit = 6;
        Scanner in = new Scanner(System.in);
        if (option == viewListOfBooks) library.showAllBooks();
        else if (option == checkoutBook) checkout(in);
        else if (option == returnBook) returnBook(in);
        else if (option == quit) System.exit(0);
        else if (option == viewListOfMovies) library.showAllMovies();
        else if (option == checkoutMovie) checkoutMovie(in);
        else System.out.println("Invalid Option!");
    }

    private void checkoutMovie(Scanner in) {
        String movieName = in.nextLine();
        String libraryNumber = in.nextLine();
        String password = in.nextLine();
        Login login = new Login(libraryNumber, password);
        if (login.verify()) library.checkoutMovie(movieName);
    }

    private void returnBook(Scanner in) {
        String bookName = in.nextLine();
        String libraryNumber = in.nextLine();
        String password = in.nextLine();
        Login login = new Login(libraryNumber, password);
        if (login.verify()) librarian.returnBook(bookName);
    }

    private void checkout(Scanner in) {
        String bookName = in.nextLine();
        String libraryNumber = in.nextLine();
        String password = in.nextLine();
        Login login = new Login(libraryNumber, password);
        if (login.verify()) librarian.checkoutBook(libraryNumber, bookName);
    }

    private void setOptions() {
        options.put(1, "View list of books");
        options.put(2, "Checkout book");
        options.put(3, "Return book");
        options.put(4, "View list of Movies");
        options.put(5, "Checkout movie");
        options.put(6, "Quit");
    }
}
