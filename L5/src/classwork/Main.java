package classwork;

import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char operation[] = new char[3];
        for (int i = 0; i < 2; i++){
            operation[i] = input.nextLine().charAt(i);
        }
        for (int i = 0; i < 2; i++){
            System.out.println(operation[i]);
        }
    }
}
