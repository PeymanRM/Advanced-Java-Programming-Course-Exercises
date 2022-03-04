package a2;

public class Main {
    public static void main(String[] args) {
        Complex complex1 = new Complex(2f,-1f);
        Complex complex2 = new Complex(4f,2f);
        Complex complex3 = Complex.add(complex1, complex2);
        complex3.print();
        Complex complex4 = Complex.subtract(complex1, complex2);
        complex4.print();
    }
}
