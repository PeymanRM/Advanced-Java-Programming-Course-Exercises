package a1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Set <String> names = new TreeSet<>();
        System.out.println("Enter a set of names with a space in between:");
        Scanner input = new Scanner(System.in);
        for (String name : input.nextLine().trim().split(" ")) {
            names.add(name);
        }


    }
}
