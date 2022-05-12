package classwork.models.services;

import classwork.models.entities.UserEnti;
import classwork.models.repositories.UserRepo;

/**
 * Created by Peyman RM
 */
public class UserServ {
    private UserServ() {}
    private static UserServ userServ = new UserServ();
    public static UserServ getInstance(){
        return userServ;
    }

    public void save(UserEnti user) throws Exception {
        UserRepo userRepo = new UserRepo();

        //hashing password
        PasswordAuthentication auth = new PasswordAuthentication();
        char[] password = new char[user.getPassword().length()];
        for (int i = 0; i < user.getPassword().length(); i++) {
            password[i] = user.getPassword().charAt(i);
        }
        user.setPassword(auth.hash(password));

        userRepo.insertUser(user);
        userRepo.commit();
        userRepo.close();
    }

    public UserEnti getUser(String username) throws Exception{
        UserRepo userRepo = new UserRepo();
        return userRepo.selectUser(username);
    }

    public boolean verifyUser(String username, String enteredPassword) throws Exception{
        UserRepo userRepo = new UserRepo();
        //verifying password with saved password hash
        PasswordAuthentication auth = new PasswordAuthentication();
        char[] enteredPasswordChar = new char[enteredPassword.length()];
        for (int i = 0; i < enteredPassword.length(); i++) {
            enteredPasswordChar[i] = enteredPassword.charAt(i);
        }
        return auth.authenticate(enteredPasswordChar, userRepo.selectUserPassword(username));
    }
}
