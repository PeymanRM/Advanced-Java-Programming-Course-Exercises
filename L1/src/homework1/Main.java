package homework1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter width and length of a rectangle: ");
        Rectangle rec = new Rectangle();
        rec.setWidth(input.nextFloat());
        rec.setLength(input.nextFloat());
        System.out.println("Enter length of a square: ");
        Square sqr = new Square(input.nextDouble());
        System.out.println("Area of the Rectangle = "+ rec.getArea());
        System.out.println("Perimeter of the Rectangle = " + rec.getPerimeter());
        System.out.println("\nArea of the Square = " + sqr.getArea());
        System.out.println("Perimeter of the Square = " + sqr.getPerimeter());
    }
}
