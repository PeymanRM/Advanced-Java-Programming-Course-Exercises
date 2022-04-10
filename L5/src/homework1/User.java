package homework1;

public class User {
    String username, name, password, address, telephone, cellphone, degree;
    int age;

    public User(String username, String name, String password, int age, String address, String telephone, String cellphone, String degree) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.age = age;
        this.address = address;
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.degree = degree;
    }

    public void showAll() {
        System.out.println("Username: " + username);
        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Telephone number: " + telephone);
        System.out.println("Cellphone number: " + cellphone);
        System.out.println("Degree: " + degree);
    }

}
