package homework1;

/**
 * Created by Peyman RM
 */
public class Multiplication extends  Operation implements Result {

    @Override
    public void getResult() {
        System.out.println(num1 * num2);
    }
}
