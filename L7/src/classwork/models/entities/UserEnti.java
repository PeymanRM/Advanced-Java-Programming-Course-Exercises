package classwork.models.entities;

public class UserEnti {
    private String name, password, username, email;

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

    public String getEmail() {
        return email;
    }

    public UserEnti setEmail(String email) {
        this.email = email;
        return this;
    }
}
