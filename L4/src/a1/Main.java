package a1;

import java.awt.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
//test
/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {

        Set <String> names = new TreeSet<>();
        System.out.println("Enter a set of names with a space in between:");
        Scanner input = new Scanner(System.in);
        for (String name : input.nextLine().trim().toLowerCase().split(" ")) {
            names.add(name);
        }

        while (true) {
            System.out.println("\nEnter the name you want to search:");
            String searchedName = input.next().toLowerCase();
            boolean foundName = false;
            for (String name : names) {
                if(name.equals(searchedName)){
                    foundName = true;
                    break;
                }

            }

            if(foundName) System.out.println("Name Found");
            else System.out.println("Name Not Found");
        }
    }
}
