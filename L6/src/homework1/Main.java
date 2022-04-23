package homework1;

import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Hi, ");
        outer:while (true) {
            System.out.println("\n How can we help you?");
            System.out.println("   1.Create a new user\n   2.Show users\n   3.Edit an existing user\n   4.Exit");
            switch (input.nextInt()){
                case 1:
                    UserRepo.getInstance().addUser(getUserInfo());
                    break;
                case 2:
                    UserRepo.getInstance().showUsers();
                    break;
                case 3:
                    System.out.println("Enter the ID of the user you want to edit: ");
                    UserRepo.getInstance().updateUser(input.nextInt(),getUserInfo());
                    break;
                case 4:
                    break outer;
            }
        }
        UserRepo.getInstance().closeConnection();
    }

    private static UserEnti getUserInfo(){
        Scanner input = new Scanner(System.in);
        UserEnti user = new UserEnti();
        System.out.print("Username: ");
        user.setUsername(input.nextLine());
        System.out.print("Email Address: ");
        user.setEmailAddress(input.nextLine());
        System.out.print("Password: ");
        user.setPassword(input.nextLine());
        System.out.print("Degree: ");
        user.setDegree(input.nextLine());
        System.out.print("Age: ");
        user.setAge(input.nextInt());
        return user;
    }
}
