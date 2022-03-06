package homework3;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Integer int1 = new Integer(5);
        System.out.println(int1.isEven());
        System.out.println(int1.isOdd());
        System.out.println(int1.isPosetive());
        System.out.println(int1.isNegative());
        System.out.println(int1.isZero());
        System.out.println();
        Integer int2 = new Integer(-8);
        System.out.println(int2.isEven());
        System.out.println(int2.isOdd());
        System.out.println(int2.isPosetive());
        System.out.println(int2.isNegative());
        System.out.println(int2.isZero());
    }
}
