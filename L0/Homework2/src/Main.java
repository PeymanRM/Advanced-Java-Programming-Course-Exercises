import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int n = 5;

        int[] arr = new int[n];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an array: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = input.nextInt();
        }
        int max = arr[0];
        for(int item: arr)
            if (max < item) max = item;
        System.out.println("Max = " + max);
    }
}
