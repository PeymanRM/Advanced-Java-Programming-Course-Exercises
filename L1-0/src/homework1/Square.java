package homework1;

public class Square {
    private double length, area, perimeter;

    public Square(double length) {
        this.length = length;
    }

    public double getArea() {
        return length*length;
    }

    public double getPerimeter(){
        return length*4;
    }
}
