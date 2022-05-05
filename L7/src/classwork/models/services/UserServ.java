package classwork.models.services;

import classwork.models.entities.UserEnti;
import classwork.models.repositories.UserRepo;


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

    public boolean verifyUser(String username, String enteredPassword) throws Exception{
        UserRepo userRepo = new UserRepo();
        return userRepo.selectUserPassword(username).equals(enteredPassword);
    }
}
