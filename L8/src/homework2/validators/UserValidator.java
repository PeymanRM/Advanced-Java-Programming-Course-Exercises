package homework2.validators;

import homework2.models.entities.UserEnti;
import homework2.validators.UserInputException;

import java.util.regex.*;

/**
 * Created by Peyman RM
 */
public class UserValidator extends UserEnti {

    public void validateInputs() throws Exception {
        //name
        if (getName().length() < 3) throw new UserInputException("Entered name is too short!");
        if (!Pattern.matches("^[a-zA-Z ,.'-]+$" ,getName())) throw new UserInputException("Invalid name!");

        //email
        final String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        if (!Pattern.matches(emailRegex ,getEmail())) throw new UserInputException("Invalid email address!");

        //username
        if (getUsername().length() < 5) throw new UserInputException("Username must contain between 5 to 20 characters.");
        if (!Pattern.matches("^[a-zA-Z0-9._]+$" ,getUsername())) throw new UserInputException("Username must only contain only letters, numbers, dot, or underscore");
        if (!Pattern.matches("^(?![.])[a-zA-Z0-9._]+(?<![.])$" ,getUsername())) throw new UserInputException("Username cant begin or end with dot( . )!");

        //password
        if (getPassword().length() < 6 || getPassword().length() > 64) throw new UserInputException("Password must contain between 6 to 64 characters.");
    }
}
