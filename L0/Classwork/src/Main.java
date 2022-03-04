import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            int[] arr = new int[5];
            boolean repeated = false;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter an array: ");
            for(int i = 0; i < arr.length; i++){
                arr[i] = input.nextInt();
            }
            System.out.println("Enter a number to search: ");
            int num = input.nextInt();
            int count = 0;
            for(int item: arr){
                if (item == num) {
                    repeated = true;
                    count++;
                }
            }
            System.out.println(repeated);
            if(repeated)
                System.out.println("Repeated " + count + " times");
        }
    }
}