package homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Enter Student's Name: ");
        student.setName(input.nextLine());
        System.out.println("Enter Student's Code: ");
        student.setStudentCode(input.nextLine());
        System.out.println("Enter Student's Father's Name: ");
        student.setFatherName(input.nextLine());
        System.out.println("Enter Student's 5 grades: ");
        List<Double> grades = new ArrayList<>();
        for (int i=0; i<5; i++)
            grades.add(input.nextDouble());
        student.setGrades(grades);


        //testing getters
        System.out.println("\nName: " + student.getName());
        System.out.println("Code: " + student.getStudentCode());
        System.out.println("Father's Name: " + student.getFatherName());
        System.out.println("Grades: ");
        for (Object grade : student.getGrades()) {
            System.out.print(grade);
            System.out.print("   ");
        }
    }
}
