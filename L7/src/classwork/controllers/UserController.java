package classwork.controllers;


import classwork.models.entities.UserEnti;
import classwork.models.services.UserServ;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private UserController() {}
    private static UserController userController = new UserController();
    public static UserController getInstance(){
        return userController;
    }

    private Map<String,String> loggedInUser = null; //with only necessary info of the user = username, name

    public void setLoggedInUser(Map<String, String> loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public Map<String,String> getUser() {
        return loggedInUser;
    }

    public UserEnti getProfile() throws Exception {
        return UserServ.getInstance().getUser(loggedInUser.get("username"));
    }

    public void logout() {
        loggedInUser = null;
    }
}
