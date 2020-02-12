import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    //TODO: new ArrayList not required
    private List<Book> books = new ArrayList<>(Arrays.asList(new Book("Refactoring", "Martin Fowler", 2018), new Book("NoSQL Distilled", "Pramod J", 2012)));

    public void showAllBooks() {
        for (Book book : books) {
            book.view();
        }
    }


    public boolean has(String bookName) {
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
