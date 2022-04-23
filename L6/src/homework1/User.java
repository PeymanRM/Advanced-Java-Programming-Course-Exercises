package homework1;

public class User {
    String username, emailAddress, password, degree;
    int age;

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setDegree(String degree) {
        this.degree = degree;
        return this;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getDegree() {
        return degree;
    }

    public int getAge() {
        return age;
    }
}
