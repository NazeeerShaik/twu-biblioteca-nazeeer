import java.util.ArrayList;
import java.util.List;

public class Librarian {

    private List<Book> record = new ArrayList<>();
    private Library library = new Library();

    public void checkout(String bookName) {
        if (library.has(bookName)) {
            Book book = library.getBook(bookName);
            record.add(book);
            library.remove(book);
            System.out.println("Thank you! Enjoy the book");
        } else System.out.println("Sorry, that book is not available");
    }


    public void returnBook(String bookName) {
        if (isInRecords(bookName)) {
            for (Book book : record) {
                if (bookName.equals(book.getName())) {
                    library.add(book);
                    record.remove(book);
                    System.out.println("Thank you for returning the book");
                    break;
                }
            }
        } else System.out.println("That is not a valid book to return");
    }

    private boolean isInRecords(String bookName) {
        for (Book book : record) {
            if (bookName.equals(book.getName())) return true;
        }
        return false;
    }
}
