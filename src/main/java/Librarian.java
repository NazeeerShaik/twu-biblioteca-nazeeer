import java.util.HashMap;
import java.util.Map;

public class Librarian {

    private Map<String, Book> record = new HashMap<>();
    private Library library = new Library();

    public void checkoutBook(String libraryNumber, String bookName) {
        if (library.hasBook(bookName)) {
            Book book = library.getBook(bookName);
            record.put(libraryNumber, book);
            library.remove(book);
            System.out.println("Thank you! Enjoy the book");
        } else System.out.println("Sorry, that book is not available");
    }


    public void returnBook(String bookName) {
        if (isInRecords(bookName)) {
            for (Map.Entry entry : record.entrySet()) {
                Book book = (Book) entry.getValue();
                if (book.has(bookName)) {
                    library.add(book);
                    record.remove(entry);
                    System.out.println("Thank you for returning the book");
                    break;
                }
            }
        } else System.out.println("That is not a valid book to return");
    }

    private boolean isInRecords(String bookName) {
        for (Map.Entry entry : record.entrySet()) {
            Book book = (Book) entry.getValue();
            if (book.has(bookName)) return true;
        }
        return false;
    }

    public void records() {
        record.forEach((libraryNumber, book) -> System.out.println(libraryNumber + " " + book.getName()));
    }

}
