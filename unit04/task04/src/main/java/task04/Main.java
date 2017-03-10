package task04;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FilmCollection filmCollection = new FilmCollection();
        File films = new File("films.txt");
        filmCollection.deserializeCollection(films);

        while (true) {
            System.out.println("Welcome to film collection. Choose the operation you want to do:");
            System.out.println("1. Add film.");
            System.out.println("2. Delete film.");
            System.out.println("3. Show collection.");
            System.out.println("0. Quit.");


            Scanner scanner = new Scanner(System.in);
            int operation;
            String film;
            String actor;
            operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("Enter film name:");
                    scanner.nextLine();
                    film = scanner.nextLine();
                    System.out.println("Enter actor name:");
                    actor = scanner.nextLine();
                    filmCollection.addFilm(film, actor);
                    break;
                case 2:
                    System.out.println("Enter film name:");
                    film = scanner.nextLine();
                    filmCollection.deleteFilm(film);
                    break;
                case 3:
                    filmCollection.showCollection();
                    break;
                case 0:
                    filmCollection.serializeCollection(films);
                    System.exit(1);
                default:
                    System.out.println("Wrong operation number!");
                    break;
            }
            System.out.println("---------------------------");

        }
    }
}
