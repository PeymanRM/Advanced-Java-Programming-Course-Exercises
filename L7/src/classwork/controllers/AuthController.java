package classwork.controllers;

import classwork.models.entities.UserEnti;
import classwork.models.services.UserServ;

import java.util.HashMap;
import java.util.Map;

public class AuthController {
    private AuthController() {}
    private static AuthController authController = new AuthController();
    public static AuthController getInstance(){
        return authController;
    }

    public void register(UserEnti user) throws Exception {
        UserServ.getInstance().save(user);
        Map<String,String> loggedInUser = new HashMap<String,String>();
        loggedInUser.put("username", user.getUsername());
        loggedInUser.put("name", user.getName());
        UserController.getInstance().setLoggedInUser(loggedInUser);
    }

    public boolean login(String enteredUsername, String enteredPassword) throws Exception {
        if(UserServ.getInstance().verifyUser(enteredUsername, enteredPassword)) {
            Map<String,String> loggedInUser = new HashMap<String,String>();
            loggedInUser.put("username", enteredUsername);
            loggedInUser.put("name", UserServ.getInstance().getUser(enteredUsername).getName());
            UserController.getInstance().setLoggedInUser(loggedInUser);
            return true;
        } else return false;
    }
}
