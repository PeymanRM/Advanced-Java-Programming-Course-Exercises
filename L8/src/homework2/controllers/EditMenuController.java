package homework2.controllers;

import homework2.models.entities.UserEnti;
import homework2.models.services.UserServ;
import homework2.validators.UserInputException;
import homework2.validators.UserValidator;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class EditMenuController {

    @FXML
    private TextField editNameTextField,editEmailTextField, editUsernameTextField;
    @FXML
    private Label editErrorLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Map<String,String> loggedInUser = null; //with only necessary info of the user = username, name

    public void setLoggedInUser(Map<String, String> loggedInUser) {
        this.loggedInUser = loggedInUser;
        try {
            UserEnti user = UserServ.getInstance().getUser(loggedInUser.get("username"));
            editNameTextField.setText(user.getName());
            editEmailTextField.setText(user.getEmail());
            editUsernameTextField.setText(user.getUsername());
        }catch (Exception e){
            editErrorLabel.setText("Something went wrong on our end");
        }
    }

    public void submit(ActionEvent event) {
        UserValidator user = new UserValidator();
        user.setName(editNameTextField.getText().trim()).setEmail(editEmailTextField.getText().toLowerCase().trim())
                .setUsername(editUsernameTextField.getText().toLowerCase().trim());
        try {
            user.validateInputs(false);
            UserServ.getInstance().editUserInfo(user, loggedInUser.get("username"));
            loggedInUser.put("username", user.getUsername());
            loggedInUser.put("name", user.getName());
            editErrorLabel.setTextFill(Color.web("#b6f404"));
            editErrorLabel.setText("Successfully edited information");
            renderDashboardView(event, loggedInUser);
        } catch (UserInputException e) {
            editErrorLabel.setText(e.getMessage());
        } catch (Exception e){
            if(e.getMessage().split("'")[0].equals("Duplicate entry ")) editErrorLabel.setText("Entered username is already used.\nPick another one.");
            else editErrorLabel.setText("Something went wrong on our end");
        }
    }

    public void back(ActionEvent event) throws IOException {
        renderDashboardView(event, loggedInUser);
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
