package homework3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EquationSolver equationSolver = new EquationSolver();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a, b and e in order: ");
        equationSolver.setEquation1(input.nextDouble(), input.nextDouble(), input.nextDouble());
        System.out.println("Enter c, d and f in order: ");
        equationSolver.setEquation2(input.nextDouble(), input.nextDouble(), input.nextDouble());
        equationSolver.getSolution();
    }
}