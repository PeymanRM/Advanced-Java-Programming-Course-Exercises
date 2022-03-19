package homework2;

/**
 * Created by Peyman RM
 */
public class User <userData> implements Cloneable {
    private userData name, username, password;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public User(userData name, userData username, userData password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public userData getName() {
        return name;
    }

    public userData getUsername() {
        return username;
    }
}
