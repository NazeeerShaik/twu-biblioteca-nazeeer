public class Movie {
    private int year;
    private String name;
    private String director;
    private double rating;

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

    public boolean has(String movieName) {
        return movieName.equals(this.name);
    }
}
