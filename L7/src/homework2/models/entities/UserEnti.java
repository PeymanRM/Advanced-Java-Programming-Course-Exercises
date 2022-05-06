package homework2.models.entities;

/**
 * Created by Peyman RM
 */
public class UserEnti {
    private String name, password, nationalCode, phoneNumber, order = "";
    int debt = 0;

    public String getOrder() {
        return order;
    }

    public UserEnti setOrder(String order) {
        this.order = order;
        return this;
    }

    public int getDebt() {
        return debt;
    }

    public UserEnti setDebt(int debt) {
        this.debt = debt;
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

    public String getNationalCode() {
        return nationalCode;
    }

    public UserEnti setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
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
