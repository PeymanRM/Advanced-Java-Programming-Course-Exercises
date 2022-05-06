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

    public UserEnti getUser(String nationalCode) throws Exception{
        UserRepo userRepo = new UserRepo();
        return userRepo.selectUser(nationalCode);
    }

    public boolean verifyUser(String nationalCode, String enteredPassword) throws Exception{
        UserRepo userRepo = new UserRepo();
        return userRepo.selectUserPassword(nationalCode).equals(enteredPassword);
    }

    public void editOrder(String nationalCode, String order, int debt) throws Exception{
        UserRepo userRepo = new UserRepo();
        UserEnti user = getUser(nationalCode);
        if (user.getOrder() != null && !user.getOrder().equals("")) throw new Exception("You have already purchased a car");
        userRepo.updateOrder(nationalCode, order, debt);
        userRepo.commit();
        userRepo.close();
    }

}
