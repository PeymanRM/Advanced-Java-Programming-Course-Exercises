package classwork.controllers;

import java.util.Map;

public class AuthController {
    private AuthController() {}
    private static AuthController authController = new AuthController();
    public static AuthController getInstance(){
        return authController;
    }

    public Map<String,String> register() {

    }

    public Map<String,String> login() {

    }
}
