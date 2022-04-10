package homework1;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        UserBuilder bUser = new UserBuilder()
                .setUsername("PeymanRM")
                .setName("Peyman")
                .setAge(19)
                .setPassword("qwerty:)")
                .setAddress("Somewhere far away")
                .setTelephone("02100000000")
                .setCellphone("09123456789")
                .setDegree("Diploma");
        User user = bUser.createUser();
        user.showAll();
    }
}