package classwork.models.services;

import classwork.models.entities.UserEnti;
import classwork.models.repositories.UserRepo;

import java.util.List;

public class UserServ {
    private UserServ() {}
    private UserServ userServ = new UserServ();
    public UserServ getInstance(){
        return userServ;
    }

    public void save(UserEnti user) throws Exception {
        UserRepo userRepo = new UserRepo();
        userRepo.insertUser(user);
        userRepo.commit();
    }

    public UserEnti getUser(String username) throws Exception{
        UserRepo userRepo = new UserRepo();
        return userRepo.selectUser(username);
    }

    public boolean verifyUser(String username, String enteredPassword) throws Exception{
        UserRepo userRepo = new UserRepo();
        return userRepo.selectUserPassword(username).equals(enteredPassword);
    }
}
