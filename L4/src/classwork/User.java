package classwork;

/**
 * Created by Peyman RM
 */
public class User {
    private String username, pass, name, family, job;
    private int age;

    public User (String username, String pass, String name, String family, String job, int age) {
        this.username = username;
        this.pass = pass;
        this.name = name;
        this.family = family;
        this.job = job;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getJob() {
        return job;
    }

    public int getAge() {
        return age;
    }
}
