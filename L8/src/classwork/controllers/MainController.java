package classwork.controllers;

import classwork.models.entities.UserEnti;
import classwork.models.services.UserServ;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainController {

    @FXML
    private TextField loginUsernameTextField, loginPasswordField,
            signupNameTextField,signupEmailTextField, signupUsernameTextField, signupPasswordField1, signupPasswordField2;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login(ActionEvent event) {
        try {
            if (UserServ.getInstance().verifyUser(loginUsernameTextField.getText().toLowerCase().trim(), loginPasswordField.getText())) {
                Map<String, String> loggedInUser = new HashMap<String, String>();
                loggedInUser.put("username", loginUsernameTextField.getText().toLowerCase().trim());
                loggedInUser.put("name", UserServ.getInstance().getUser(loginUsernameTextField.getText().toLowerCase().trim()).getName());
                renderDashboardView(event, loggedInUser);
            } else {
                System.out.println("ERROR1");
            }
        } catch (IOException e){
            System.out.println("ERROR3 IO: " + e.getMessage());

        } catch (Exception e){
            System.out.println("ERROR2: " + e.getMessage());
        }
    }

    public void SignUp(ActionEvent event) {
        if(signupPasswordField1.getText().equals(signupPasswordField2.getText())) {
            UserEnti user = new UserEnti();
            user.setName(signupNameTextField.getText().trim()).setEmail(signupEmailTextField.getText().toLowerCase().trim())
                    .setUsername(signupUsernameTextField.getText().toLowerCase().trim()).setPassword(signupPasswordField1.getText());
            try {
                UserServ.getInstance().save(user);
                Map<String,String> loggedInUser = new HashMap<String,String>();
                loggedInUser.put("username", user.getUsername());
                loggedInUser.put("name", user.getName());
                renderDashboardView(event, loggedInUser);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        } else{
            System.out.println("ERROR PASSWORDS DON'T MATCH");
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
