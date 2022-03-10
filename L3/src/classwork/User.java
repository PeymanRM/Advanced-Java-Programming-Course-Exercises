package classwork;

/**
 * Created by Peyman RM
 */
public class User {
    private String name, family;
    private int age;

    public User(String name, String family, int age) {
        this.age = age;
        this.name = name;
        this.family = family;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }
}
