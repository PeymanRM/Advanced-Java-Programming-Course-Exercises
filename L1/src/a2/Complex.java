package a2;

public class Complex {
    private float realPart, imaginaryPart;

    public Complex(float realPart, float imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public Complex() {
        realPart = 0;
        imaginaryPart = 0;
    }

    public static Complex add(Complex c1, Complex c2) {
        Complex result = new Complex(c1.realPart + c2.realPart, c1.imaginaryPart + c2.imaginaryPart);
        return result;
    }

    public static Complex subtract(Complex c1, Complex c2) {
        Complex result = new Complex(c1.realPart - c2.realPart, c1.imaginaryPart - c2.imaginaryPart);
        return result;
    }

    public void print() {
        System.out.println(realPart + " + " + imaginaryPart + "i");
    }
}
