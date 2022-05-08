package classwork.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Map;

public class DashboardController {

    @FXML
    Label nameLabel;

    private Map<String,String> loggedInUser = null; //with only necessary info of the user = username, name

    public void setLoggedInUser(Map<String, String> loggedInUser) {
        this.loggedInUser = loggedInUser;
//        System.out.println(loggedInUser.get("name"));
//        nameLabel.setText(loggedInUser.get("name"));   ERROR TODO FIX THIS LINE
    }
}
