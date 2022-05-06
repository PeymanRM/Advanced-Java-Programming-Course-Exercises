package classwork;

import classwork.controllers.AuthController;
import classwork.controllers.UserController;
import classwork.models.entities.UserEnti;

import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        outer:while (true){
            System.out.print("\nHello, ");
            if (UserController.getInstance().getUser() != null) {
                try {
                    System.out.println(UserController.getInstance().getUser().get("name"));
                } catch (Exception e){
                    System.out.println ("Failed to load user! " + e.getMessage ());
                    UserController.getInstance().logout();
                    continue;
                }
                System.out.println(" how can we help you today?");
                System.out.println("   1.Profile\n   2.Log out\n   3.Exit");

                switch (input.nextInt()){
                    case 1:
                        try {
                            UserEnti user = UserController.getInstance().getProfile();
                            System.out.println("Name: " + user.getName() + "\t\tEmail: " + user.getEmail() + "\t\tUsername: " + user.getUsername());
                        } catch (Exception e) {
                            System.out.println("Failed to load user! " + e.getMessage());
                        }
                        break;
                    case 2:
                        UserController.getInstance().logout();
                        System.out.println("Successfully logged out");
                        break;
                    case 3:
                        break outer;
                }
            } else {
                System.out.println("how can we help you today?");
                System.out.println("   1.Sign Up\n   2.Log in\n   3.Exit");
                switch (input.nextInt()){
                    case 1:
                        UserEnti user = new UserEnti();
                        System.out.println("Enter your name: ");
                        input.nextLine();
                        user.setName(input.nextLine());
                        System.out.println("Enter your email address: ");
                        user.setEmail(input.next());
                        System.out.println("Enter a username: ");
                        user.setUsername(input.next());
                        input.nextLine();
                        System.out.println("Enter a password: ");
                        user.setPassword(input.nextLine());
                        try {
                            AuthController.getInstance().register(user);
                            System.out.println("User successfully created");
                        } catch (Exception e){
                            System.out.println ("Failed to save user! " + e.getMessage ());
                        }
                        break;
                    case 2:
                        System.out.println("Enter your username: ");
                        String enteredUsername = input.next();
                        input.nextLine();
                        System.out.println("Enter your password: ");
                        try {
                            if (AuthController.getInstance().login(enteredUsername, input.nextLine())) {
                                System.out.println("Successfully Logged In");
                            } else {
                                System.out.println("Username or password is wrong");
                            }
                        } catch (Exception e){
                            if(e.getMessage().equals("Illegal operation on empty result set.")) System.out.println("Username or password is wrong");
                            else System.out.println ("Something Went Wrong: " + e.getMessage ());
                        }
                        break;
                    case 3:
                        break outer;
                }
            }
        }
    }
}
