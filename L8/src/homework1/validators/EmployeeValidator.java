package homework1.validators;

import homework1.models.entities.EmployeeEnti;

import java.util.regex.Pattern;

public class EmployeeValidator extends EmployeeEnti {

    public void validateInputs() throws Exception {
        //Name
        if (getName().length() < 3) throw new EmployeeInputException("Entered name is too short!");
        if (!Pattern.matches("^[a-zA-Z ,.'-]+$", getName())) throw new EmployeeInputException("Invalid name!");

        //Father's Name
        if (getFatherName().length() < 3) throw new EmployeeInputException("Entered ّfather's name is too short!");
        if (!Pattern.matches("^[a-zA-Z ,.'-]+$", getFatherName())) throw new EmployeeInputException("Invalid father's name!");

        //National Code
        if (getNationalCode().length() != 10) throw new EmployeeInputException("National code must be 10 digits!");
        if (!Pattern.matches("^[0-9]+$", getNationalCode())) throw new EmployeeInputException("National code must only contain digits!");
        final int r = Character.getNumericValue(getNationalCode().charAt(9));
        int sum = 0;
        for (int i = 0; i < getNationalCode().length()-1; i++){
            sum += Character.getNumericValue(getNationalCode().charAt(i)) * (10-i);
        }
        if(sum%11 < 2) {
            if (sum % 11 != r) throw new EmployeeInputException("Invalid national code!");
        } else {
            if (11 - (sum % 11) != r) throw new EmployeeInputException("Invalid national code!");
        }

        //Age
        if (getAge() < 0) throw new EmployeeInputException("Invalid age!");
        if (getAge() < 18) throw new EmployeeInputException("You're age should be above 18!");

        //Degree
        if (!Pattern.matches("^[a-zA-Z ,.'-]+$", getDegree())) throw new EmployeeInputException("Invalid degree!");

        //Phone Number
        if (getPhoneNumber().length() != 11) throw new EmployeeInputException("Phone number must be 11 digits!");
        if (!Pattern.matches("^[0-9]+$", getPhoneNumber())) throw new EmployeeInputException("Phone number must only contain digits!");

        //Telephone
        if (getTelephone().length() != 11) throw new EmployeeInputException("Telephone must be 11 digits! (don't forget typing city code at the beginning)");
        if (!Pattern.matches("^[0-9]+$", getTelephone())) throw new EmployeeInputException("Telephone must only contain digits!");
    }
}