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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

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
    }

    public void submit(ActionEvent event) {

    }

    public void back(ActionEvent event) throws IOException {
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
