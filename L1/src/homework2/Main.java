package homework2;

import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many lessons do you have?");
        int lessonsCount = input.nextInt();
        double[] grades = new double[lessonsCount];
        int[] coefficients = new int[lessonsCount];
        System.out.println("Enter each lesson's grade and coefficient in order");
        for(int i = 0; i < lessonsCount; i++){
            System.out.print("Lesson " + (i+1) + ": ");
            grades[i] = input.nextDouble();
            coefficients[i] = input.nextInt();
        }
        Student student = new Student(lessonsCount, grades, coefficients);
        System.out.println("Average Grade = " + student.getAverage());
    }
}
