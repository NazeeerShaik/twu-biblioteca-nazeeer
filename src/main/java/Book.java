import java.util.Objects;

public class Book {
    private String name;
    private int year;
    private String authorName;


    Book(String name, String authorName, int year) {
        this.authorName = authorName;
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(getName(), book.getName()) &&
                Objects.equals(authorName, book.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), year, authorName);
    }

    public void view() {
        System.out.println("Book{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", authorName='" + authorName + '\'' +
                '}');
    }

    public boolean has(String bookName) {
        return bookName.equals(this.name);
    }
}