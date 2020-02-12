public class Movie {
    int year;
    String name;
    String director;
    double rating;

    public Movie(int year, String name, String director, double rating) {
        this.year = year;
        this.name = name;
        this.director = director;
        this.rating = rating;
    }
    public void view() {
        System.out.println("Movie{" +
                "year=" + year +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", rating=" + rating +
                '}');
    }
}
