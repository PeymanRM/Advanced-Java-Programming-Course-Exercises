package homework1;

public class Subtarction extends Operation implements Result {

    @Override
    public void getResult() {
        System.out.println(num1 - num2);
    }
}
