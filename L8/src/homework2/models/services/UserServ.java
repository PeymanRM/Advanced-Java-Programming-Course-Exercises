package homework2.models.services;

import homework2.models.entities.UserEnti;
import homework2.models.repositories.UserRepo;

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
        userRepo.insertUser(user);
        userRepo.commit();
        userRepo.close();
    }

    public UserEnti getUser(String username) throws Exception{
        UserRepo userRepo = new UserRepo();
        return userRepo.selectUser(username);
    }

    public void editUserInfo(UserEnti user) throws Exception{
        UserRepo userRepo = new UserRepo();
        userRepo.updateUserInfo(user);
        userRepo.commit();
        userRepo.close();
    }

    public boolean verifyUser(String username, String enteredPassword) throws Exception{
        UserRepo userRepo = new UserRepo();
        return userRepo.selectUserPassword(username).equals(enteredPassword);
    }
}
