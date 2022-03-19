package homework2;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        User user = new User("Peyman", "PeymanRM", "KjhUTF:O*yv");
        User clone1 = null;
        User clone2 = null;
        User clone3 = null;
        try {
            clone1 = (User) user.clone();
            clone2 = (User) user.clone();
            clone3 = (User) user.clone();
        }catch (CloneNotSupportedException e){
            System.out.println(e.getMessage());
        }

        System.out.println(clone1.getName());
        System.out.println(clone2.getUsername());
        System.out.println(clone3.getName());
    }
}
