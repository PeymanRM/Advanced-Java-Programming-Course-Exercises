package homework2.controllers;

import homework2.models.services.PasswordAuthentication;
import homework2.models.services.UserServ;
import homework2.validators.UserInputException;
import homework2.validators.UserValidator;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Peyman RM
 */
public class MainController {

    @FXML
    private TextField loginUsernameTextField, loginPasswordField,
            signupNameTextField,signupEmailTextField, signupUsernameTextField, signupPasswordField1, signupPasswordField2;
    @FXML
    private Label loginErrorLabel, signUpErrorLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login(ActionEvent event) {
        loginErrorLabel.setText("");
        signUpErrorLabel.setText("");
        try {
            if (UserServ.getInstance().verifyUser(loginUsernameTextField.getText().toLowerCase().trim(), loginPasswordField.getText())) {
                Map<String, String> loggedInUser = new HashMap<String, String>();
                loggedInUser.put("username", loginUsernameTextField.getText().toLowerCase().trim());
                loggedInUser.put("name", UserServ.getInstance().getUser(loginUsernameTextField.getText().toLowerCase().trim()).getName());
                renderDashboardView(event, loggedInUser);
            } else {
                loginErrorLabel.setText("Wrong username or password!");
            }
        } catch (IOException e){
            loginErrorLabel.setText("Something went wrong on our end");

        } catch (Exception e){
            if (e.getMessage().equals("Illegal operation on empty result set.")) loginErrorLabel.setText("Wrong username or password!");
            else loginErrorLabel.setText("Something went wrong on our end");
        }
    }

    public void SignUp(ActionEvent event) {
        loginErrorLabel.setText("");
        signUpErrorLabel.setText("");
        if(signupPasswordField1.getText().equals(signupPasswordField2.getText())) {
            UserValidator user = new UserValidator();
            user.setName(signupNameTextField.getText().trim()).setEmail(signupEmailTextField.getText().toLowerCase().trim())
                    .setUsername(signupUsernameTextField.getText().toLowerCase().trim()).setPassword(signupPasswordField1.getText());
            try {
                user.validateInputs(true);
                UserServ.getInstance().save(user);
                Map<String,String> loggedInUser = new HashMap<String,String>();
                loggedInUser.put("username", user.getUsername());
                loggedInUser.put("name", user.getName());
                renderDashboardView(event, loggedInUser);
            } catch (UserInputException e) {
                signUpErrorLabel.setText(e.getMessage());
            } catch (Exception e){
                if(e.getMessage().split("'")[0].equals("Duplicate entry ") && e.getMessage().split("'")[3].equals("l7classwork.username_UNIQUE"))
                    signUpErrorLabel.setText("Entered username is already used.\nPick another one.");
                else if(e.getMessage().split("'")[0].equals("Duplicate entry ") && e.getMessage().split("'")[3].equals("l7classwork.email_UNIQUE"))
                    signUpErrorLabel.setText("Entered email is already used.");
                else signUpErrorLabel.setText("Something went wrong on our end");
                    System.out.println(e.getMessage());
            }
        } else{
            signUpErrorLabel.setText("Passwords don't match!");
        }
    }

    private void renderDashboardView(Event event, Map<String,String> loggedInUser) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/dashboard-view.fxml"));
        root = loader.load();
        DashboardController dashboardController = loader.getController();
        dashboardController.setLoggedInUser(loggedInUser);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
