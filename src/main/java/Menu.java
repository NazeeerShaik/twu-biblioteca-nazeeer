import java.util.*;

public class Menu {

    //TODO:Print stream out
    private Library library = new Library();
    private  Login login;
    private Librarian librarian = new Librarian();
    private Map<Integer, String> options = new HashMap<>();


    public void displayMenu() {
        setOptions();
        options.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public void respond(int option) {//TODO :if else ladder
        final int view = 1;
        final int checkOut = 2;
        final int returnBook = 3;
        final int quit = 4;
        Scanner in = new Scanner(System.in);
        if (option == view) library.showAllBooks();
        else if (option == checkOut) {
            String bookName = in.nextLine();
            String libraryNumber = in.nextLine();
            String password = in.nextLine();
            login = new Login(libraryNumber,password);
            if(login.submit()) librarian.checkout(libraryNumber,bookName);
        } else if (option == returnBook) {
            String bookName = in.nextLine();
            librarian.returnBook(bookName);
        } else if (option == quit) System.exit(0);
        else System.out.println("Invalid Option!");
    }

    private void setOptions() {
        options.put(1, "View list of books");
        options.put(2, "Checkout book");
        options.put(3, "Return book");
        options.put(4, "Quit");
    }
}
