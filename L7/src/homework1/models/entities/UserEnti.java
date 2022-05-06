package homework1.models.entities;

/**
 * Created by Peyman RM
 */
public class UserEnti {
    private String name, password, username, phoneNumber;
    private int debt = 0;
    private double traffic = 0;

    public double getTraffic() {
        return traffic;
    }

    public UserEnti addTraffic(double traffic) {
        this.traffic += traffic;
        return this;
    }

    public int getDebt() {
        return debt;
    }

    public UserEnti addDebt(int debt) {
        this.debt += debt;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEnti setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEnti setPassword(String pass) {
        this.password = pass;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEnti setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserEnti setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
