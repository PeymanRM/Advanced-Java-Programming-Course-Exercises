package homework3;

/**
 * Created by Peyman RM
 */
public class Integer implements MyInteger{
    private int num;

    Integer(int num) {
        this.num = num;
    }

    @Override
    public boolean isEven() {
        return (num%2==0);
    }

    @Override
    public boolean isOdd() {
        return (num%2==1);
    }

    @Override
    public boolean isPosetive() {
        return (num>0);
    }

    @Override
    public boolean isNegative() {
        return (num<0);
    }

    @Override
    public boolean isZero() {
        return (num==0);
    }
}
