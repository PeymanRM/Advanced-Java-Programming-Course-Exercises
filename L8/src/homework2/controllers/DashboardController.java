package homework2.controllers;

import homework2.models.entities.UserEnti;
import homework2.models.services.UserServ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;


/**
 * Created by Peyman RM
 */
public class DashboardController {

    @FXML
    private Label nameLabel, emailLabel, usernameLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Map<String,String> loggedInUser = null; //with only necessary info of the user = username, name

    public void setLoggedInUser(Map<String, String> loggedInUser) {
        this.loggedInUser = loggedInUser;
        nameLabel.setText("Welcome, " + loggedInUser.get("name"));
        try {
            UserEnti user = UserServ.getInstance().getUser(loggedInUser.get("username"));
            usernameLabel.setText(user.getUsername());
            emailLabel.setText(user.getEmail());
        } catch (Exception e){
            System.out.println("Error:  " + e.getMessage());
        }
    }

    public void logout(ActionEvent event) throws IOException {
        loggedInUser = null;
        root = FXMLLoader.load(getClass().getResource("../views/main-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
