package a2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        while (true) {
            //getting a number
            System.out.println("Enter a number:");
            Scanner input = new Scanner(System.in);
            int num;
            try {
                num = input.nextInt();
                if (num < 1) throw new Exception("You should enter a whole number");
            } catch (Exception e){
                System.out.println(e.getMessage());
                continue;
            }

            //handling 1 exception
            if (num == 1) {
                System.out.println("Not A Prime Number!");
                continue;
            }else if (num == 2) {
                System.out.println("Prime Number!");
                continue;
            }

            //analyzing the number
            Set <Integer> primeFactors = new TreeSet<>();
            int originalNum = num;
            for (int i = 2; i <= num;) {  //not num/2, to detect all the prime factors - e.g., 6
                if(num%i == 0) {
                    primeFactors.add(i);
                    num /= i;
                    continue;
                }
                i++;
                if (i>originalNum/2) break;
            }

            //showing result
            if(primeFactors.isEmpty()){
                System.out.println("Prime Number!");
            } else {
                System.out.print("Not A Prime Number!\t\t Prime Factors: ");
                for (Integer primeFactor : primeFactors) {
                    System.out.print(primeFactor + ", ");
                }
                System.out.println("\b\b");
            }
        }
    }
}
