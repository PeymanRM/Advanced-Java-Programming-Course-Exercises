package classwork;

import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        String books[] = {"The Alchemist", "The Old Man and the Sea", "War and Peace"};
        Library lib1 = new Library(books.length, books);
        System.out.println("Welcome,");
        outer:while(true) {
            System.out.println("\nHow can we help you today? \n1.Show Books\n2.Borrow a book\n3.Return a book\n4.Exit");
            Scanner input = new Scanner(System.in);
            switch (input.nextInt()) {
                case 1:
                    lib1.getBooks();
                    break;
                case 2:
                    lib1.borrowBook();
                    break;
                case 3:
                    lib1.returnBook();
                    break;
                case 4:
                    break outer;
                default:
                    System.out.print("Invalid Input!");
            }
        }
    }
}
