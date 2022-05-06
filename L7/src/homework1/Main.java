package homework1;

import homework1.controllers.AuthController;
import homework1.controllers.UserController;
import homework1.models.entities.UserEnti;

import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        outer:while (true){
            System.out.print("\nHello, ");
            if (UserController.getInstance().getProfile() != null) {
                try {
                    System.out.println(UserController.getInstance().getProfile().get("name"));
                } catch (Exception e){
                    System.out.println ("Failed to load user! " + e.getMessage ());
                    UserController.getInstance().logout();
                    continue;
                }
                System.out.println(" how can we help you today?");
                System.out.println("   1.Profile\n   2.Purchase package\n   3.Log out\n   4.Exit");

                switch (input.nextInt()){
                    case 1:
                        try {
                            UserEnti user = UserController.getInstance().getUser();
                            System.out.println("Name: " + user.getName() + "\t\tPhone Number: " + user.getPhoneNumber() + "\t\tUsername: " + user.getUsername());
                            System.out.println("Remaining Traffic = " + user.getTraffic() + "\t\tDebt = " + user.getDebt() + " T");
                        } catch (Exception e) {
                            System.out.println("Failed to load user! " + e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.println(" Choose a package(added tax is not calculated): ");
                        System.out.println("   1: 2GB - 1000T\n   2: 4GB - 2000T\n   3: 10GB - 5000T\n   4: 25GB - 10000T\n   5.Back");
                        try {
                            UserController.getInstance().purchasePackage(input.nextInt());
                            System.out.println("Successfully Purchased");
                        } catch (Exception e) {
                            if(e.getMessage().equals("back")) break;
                            else System.out.println ("Something Went Wrong: " + e.getMessage ());
                        }
                        break;
                    case 3:
                        UserController.getInstance().logout();
                        System.out.println("Successfully logged out");
                        break;
                    case 4:
                        break outer;
                    default:
                        System.out.println("Invalid response");
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
                        System.out.println("Enter your phone number: ");
                        user.setPhoneNumber(input.next());
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
                    default:
                        System.out.println("Invalid response");
                }
            }
        }
    }
}
