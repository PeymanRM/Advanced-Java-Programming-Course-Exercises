package homework1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hi, ");
        outer:while (true) {
            System.out.println("How can we help you?");
            System.out.println("1.Create a new user\n2.Edit an existing user\n3.Exit");
            switch (input.nextInt()){
                case 1:
                    createUser();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    break outer;
            }
        }
        try {
            Database.getInstance().closeConnection();
    }

    private static void createUser(){

    }
    private static void updateUser(){

    }
}
