package homework1;

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
        Database.getInstance().closeConnection();
    }

    private static void createUser(){
        Scanner input = new Scanner(System.in);
        User user = new User();
        System.out.println("Username: ");
        user.setUsername(input.nextLine());
        System.out.println("Email Address: ");
        user.setEmailAddress(input.nextLine());
        System.out.println("Password: ");
        user.setPassword(input.nextLine());
        System.out.println("Degree: ");
        user.setDegree(input.nextLine());
        System.out.println("Age: ");
        user.setAge(input.nextInt());
        Database.getInstance().addUser(user);
    }
    private static void updateUser(){

    }
}
