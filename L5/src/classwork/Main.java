package classwork;

import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the operation(only 3 characters allowed):");
        String sOperation = input.nextLine();
        char[] operation = new char[3];
        for (int i = 0; i < 3; i++){
            operation[i] = sOperation.charAt(i);
        }
        Calculate operation1 = CalcFactory.getCalc(operation[1]);
        System.out.println("Result = " + operation1.calc(Character.getNumericValue(operation[0]), Character.getNumericValue(operation[2])));
    }
}
