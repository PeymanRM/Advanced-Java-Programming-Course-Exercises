package classwork;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        User user = new User("PeymanRM", "JHvU6KHb", "Peyman",
                "Roohi-Moghadam", "Back-End Developer", 19);
        System.out.println("name: " + user.getName());
        System.out.println("family: " + user.getFamily());
        System.out.println("username: " + user.getUsername());
        System.out.println("job: " + user.getJob());
        System.out.println("age: " + user.getAge());
    }
}
