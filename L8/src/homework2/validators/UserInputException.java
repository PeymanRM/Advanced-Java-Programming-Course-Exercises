package homework2.validators;

/**
 * Created by Peyman RM
 */
public class UserInputException  extends Exception {
    public UserInputException(String msg) {
        super(msg);
    }

    public UserInputException() {
    }
}