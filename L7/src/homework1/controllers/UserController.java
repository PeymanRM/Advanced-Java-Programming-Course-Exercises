package homework1.controllers;


import homework1.models.entities.UserEnti;
import homework1.models.services.UserServ;

import java.util.Map;

/**
 * Created by Peyman RM
 */
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

    public Map<String,String> getProfile() {
        return loggedInUser;
    }

    public UserEnti getUser() throws Exception {
        return UserServ.getInstance().getUser(loggedInUser.get("username"));
    }

    public void purchasePackage(int packageCode) throws Exception {
        switch (packageCode) {
            case 1 -> UserServ.getInstance().editStatus(loggedInUser.get("username"), 2.0, 1000);
            case 2 -> UserServ.getInstance().editStatus(loggedInUser.get("username"), 4.0, 2000);
            case 3 -> UserServ.getInstance().editStatus(loggedInUser.get("username"), 10.0, 5000);
            case 4 -> UserServ.getInstance().editStatus(loggedInUser.get("username"), 25.0, 10000);
            case 5 -> throw new Exception("back");
            default -> throw new Exception("Invalid response");
        }
    }

    public void logout() {
        loggedInUser = null;
    }
}
