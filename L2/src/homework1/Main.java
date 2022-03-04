package homework1;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Addition op1 = new Addition();
        op1.setNums(5,9);
        op1.getResult();

        Subtarction op2 = new Subtarction();
        op2.setNums(5,9);
        op2.getResult();

        Multiplication op3 = new Multiplication();
        op3.setNums(5,9);
        op3.getResult();

        Division op4 = new Division();
        op4.setNums(5,9);
        op4.getResult();
    }
}
