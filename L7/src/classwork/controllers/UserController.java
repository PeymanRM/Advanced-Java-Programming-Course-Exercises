package classwork.controllers;


import classwork.models.entities.UserEnti;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private UserController() {}
    private static UserController userController = new UserController();
    public static UserController getInstance(){
        return userController;
    }

    public UserEnti getUser(){

    }

    public void logout() {

    }
}
