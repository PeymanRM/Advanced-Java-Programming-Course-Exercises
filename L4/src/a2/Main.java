package a2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        while (true) {
            //getting a number
            System.out.println("Enter a number");
            Scanner input = new Scanner(System.in);
            try {
                int num = input.nextInt();
                if (num < 1) throw new Exception("You should enter a whole number");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            //analyzing the number

        }
    }
}
