package homework1;

import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    private boolean loggedIn = false;

    public static void main(String[] args) {
        Student student;

    }

    private Student login(){
        Student std = new Student();
        loggedIn = std.login();
        return std;
    }

    private Student register() {
        Student std = new Student();
        std.register();
        try {
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
