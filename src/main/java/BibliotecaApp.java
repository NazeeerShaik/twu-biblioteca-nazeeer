import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore");
        start();
    }

    private static void start() {
        Menu menu = new Menu();
        do {
            menu.displayMenu();
            Scanner in = new Scanner(System.in);
            int option = in.nextInt();
            menu.respond(option);
        } while (true);
    }
}
