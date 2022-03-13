package homework2;

import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a, b and c in order:");
            QuadraticEquation equation = new QuadraticEquation(input.nextDouble(), input.nextDouble(), input.nextDouble());
            try {
                double[] answers = equation.getAnswers();
                System.out.print("Answer(s):\t");
                if(answers[0] == answers[1]) System.out.println(answers[0]);
                else System.out.println(answers[0] + "   " + answers[1]);
            } catch (EquationException e){
                System.out.println(e.getMessage());
            }
            System.gc();
        }
    }
}
