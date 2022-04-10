package homework2;

import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter username: ");
        Database.getInstance().setUsername(input.nextLine());
        System.out.println("Enter password: ");
        Database.getInstance().setPassword(input.nextLine());

        System.out.println("Username: " + Database.getInstance().getUsername());
        System.out.println("Password: " + Database.getInstance().getPassword());
    }
}
