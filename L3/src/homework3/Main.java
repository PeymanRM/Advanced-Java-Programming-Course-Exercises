package homework3;

import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a string: ");
            StringAnalyzer s = new StringAnalyzer(input.nextLine());
            try {
                System.out.println("String's length = " + s.analyse());
            } catch (NumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
