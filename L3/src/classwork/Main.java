package classwork;

import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name, family;
        int age;

        //getting info
        System.out.println("Enter 1st user's name, family and age in order: ");
        User user1 = new User(input.next(), input.next(), input.nextInt());
        System.out.println("Enter 2nd user's name, family and age in order: ");
        User user2 = new User(input.next(), input.next(), input.nextInt());

        //checking users
        try {
            if (user1.getName().equals(user2.getName()) && user1.getFamily().equals(user2.getFamily()) && user1.getAge()==user2.getAge()){
                throw new UserException("Users are the same!");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Finished");
    }
}
