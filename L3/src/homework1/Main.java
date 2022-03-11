package homework1;

import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    private static boolean loggedIn = false;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student student = new Student();
        System.out.print("Welcome, ");
        outer:while (true) {
            System.out.println("\nHow can we help you? ");
            if (!loggedIn) {
                System.out.println("1.Register\n2.Login\n3.Exit");
                switch (input.next()){
                    case "1":
                        student = register();
                        System.gc();
                        break;
                    case "2":
                        student = login();
                        System.gc();
                        break;
                    case "3":
                        break outer;
                    default:
                        System.out.println("Invalid Response");
                }
            } else {
                System.out.println("1.Show my info\n2.Logout\n3.Exit");
                switch (input.next()){
                    case "1":
                        System.out.println("Name = " + student.getName() + "\t\tUsername = " + student.getUsername());
                        break;
                    case "2":
                        student = null;
                        loggedIn = false;
                        break;
                    case "3":
                        break outer;
                    default:
                        System.out.println("Invalid Response");
                }
            }
        }
    }

    private static Student login(){
        Student std = new Student();
        loggedIn = std.login();
        return std;
    }

    private static Student register() {
        Student std = new Student();
        try {
            std.register();

            Database.addStudent(std);
            loggedIn = true;
            System.out.println("Successfully registered and logged in");
            return std;
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
