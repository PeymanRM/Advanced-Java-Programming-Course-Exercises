package homework1.models.services;

import homework1.models.entities.UserEnti;
import homework1.models.repositories.UserRepo;

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

    public boolean verifyUser(String username, String enteredPassword) throws Exception{
        UserRepo userRepo = new UserRepo();
        return userRepo.selectUserPassword(username).equals(enteredPassword);
    }

    public void editStatus(String username, Double addedTraffic, int addedDebt) throws Exception{
        UserRepo userRepo = new UserRepo();
        UserEnti user = getUser(username);
        // +9% tax
        userRepo.updateStatus(username, user.getTraffic() + addedTraffic, user.getDebt() + (addedDebt/100 * 109));
        userRepo.commit();
        userRepo.close();
    }
}
