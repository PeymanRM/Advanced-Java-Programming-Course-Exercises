import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter two numbers: ");
            float num1 = input.nextFloat(), num2 = input.nextFloat();
            System.out.println("Choose what to do with the numbers:\n1)Add\n2)Subtract\n3)Multiply\n4)Divide");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Answer = " + (num1 + num2));
                    break;
                case 2:
                    if (num1 > num2) System.out.println("Answer = " + (num1 - num2));
                    else System.out.println(num2 - num1);
                    break;
                case 3:
                    System.out.println("Answer = " + (num1 * num2));
                    break;
                case 4:
                    float division = num1 / num2;
                    System.out.println("Answer = " + division);
                    break;
                default:
                    System.out.println("Incorrect Response");
            }
        }
    }
}
