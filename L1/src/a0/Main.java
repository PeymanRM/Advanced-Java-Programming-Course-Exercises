package a0;

public class Main {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        rec.setLength(19f);
        rec.setWidth(50f);
        rec.setWidth(10f);
        System.out.println(rec.getLength());
        System.out.println(rec.getWidth());
        System.out.println(rec.getPerimeter());
        System.out.println(rec.getArea());
    }
}
