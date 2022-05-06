package homework2.controllers;


import homework2.models.entities.UserEnti;
import homework2.models.services.UserServ;

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

    public void logout() {
        loggedInUser = null;
    }

    public void purchaseCar(int carCode) throws Exception {
        switch (carCode) {
            case 1 -> UserServ.getInstance().editOrder(loggedInUser.get("username"), "Tiba", 200);
            case 2 -> UserServ.getInstance().editOrder(loggedInUser.get("username"), "Saina", 214);
            case 3 -> UserServ.getInstance().editOrder(loggedInUser.get("username"), "Pride", 180);
            case 4 -> UserServ.getInstance().editOrder(loggedInUser.get("username"), "Shahin", 380);
            case 5 -> throw new Exception("back");
            default -> throw new Exception("Invalid response");
        }
    }
}
