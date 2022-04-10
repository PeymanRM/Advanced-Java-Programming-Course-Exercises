package homework1;

public class UserBuilder {
    private String username;
    private String name;
    private String password;
    private int age;
    private String address;
    private String telephone;
    private String cellphone;
    private String degree;

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public UserBuilder setCellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public UserBuilder setDegree(String degree) {
        this.degree = degree;
        return this;
    }

    public User createUser() {
        return new User(username, name, password, age, address, telephone, cellphone, degree);
    }
}