package homework1.controllers;

import classwork.validators.UserInputException;
import homework1.models.services.EmployeeServ;
import homework1.validators.EmployeeInputException;
import homework1.validators.EmployeeValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.regex.Pattern;

/**
 * Created by Peyman RM
 */
public class MainController {

    @FXML
    private TextField nameTextField, fatherNameTextField, nationalCodeTextField, ageTextField
            , degreeTextField, phoneNumberTextField, telephoneTextField, addressTextField;

    @FXML
    private Label errorLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void submit(ActionEvent event){
        errorLabel.setText("");
        try {
            if(!Pattern.matches("^[0-9]+$", ageTextField.getText())) throw new EmployeeInputException("Age must be a number");

            EmployeeValidator employee = new EmployeeValidator();
            employee.setName(nameTextField.getText().trim()).setFatherName(fatherNameTextField.getText().trim()).setNationalCode(nationalCodeTextField.getText().trim())
                .setAge(Integer.parseInt(ageTextField.getText().trim())).setDegree(degreeTextField.getText().trim()).setPhoneNumber(phoneNumberTextField.getText().trim())
                .setTelephone(telephoneTextField.getText().trim()).setAddress(addressTextField.getText().trim());
            employee.validateInputs();
            EmployeeServ.getInstance().save(employee);

        } catch (UserInputException e) {
            errorLabel.setText(e.getMessage());
        } catch (Exception e){
            errorLabel.setText("Something went wrong on our end");
        }

        errorLabel.setTextFill(Color.web("#b6f404"));
        errorLabel.setText("Successfully Submitted");
        nameTextField.setText("");
        fatherNameTextField.setText("");
        nationalCodeTextField.setText("");
        ageTextField.setText("");
        degreeTextField.setText("");
        phoneNumberTextField.setText("");
        telephoneTextField.setText("");
        addressTextField.setText("");
    }
}
