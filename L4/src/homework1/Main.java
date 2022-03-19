package homework1;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map data = new HashMap();
        System.out.println("Enter student's code: ");
        data.put("code", input.nextLine());
        System.out.println("Enter student's name: ");
        data.put("name", input.nextLine());
        System.out.println("Enter student's grade: ");
        data.put("grade", input.nextDouble());

        System.out.println("Code: " + data.get("code"));
        System.out.println("Name: " + data.get("name"));
        System.out.println("Grade: " + data.get("grade"));
    }
}
