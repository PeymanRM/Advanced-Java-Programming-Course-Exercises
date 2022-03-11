package homework1;


import java.util.Scanner;

/**
 * Created by Peyman RM
 */
public class Student {
    private String name, username, password;

    public void register() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student's name: ");
        name = input.nextLine();
        System.out.println("Enter student's username: ");
        while(true) {
            username = input.nextLine();
            try {
                Student student = Database.findByUsername(username);

                //Line below will only be executed if the username is already taken
                System.out.println("!!This username is already taken; try another one: ");

            } catch (StudentException e) {
                break;
            }
        }
        System.out.println("Enter student's password: ");
        password = hashPassword(input.nextLine());
    }

    public boolean login() {
        //getting info
        Scanner input = new Scanner(System.in);
        String username, password;
        System.out.println("Enter student's username: ");
        username = input.nextLine();
        System.out.println("Enter student's password: ");
        password = input.nextLine();

        //logging in
        try {
            Student student = Database.findByUsername(username);
            if (password.equals(student.password)){
                this.name = student.name;
                this.username = student.username;
                System.out.println("Logged in");
                return true;
            } else{
                throw new StudentException("Invalid username or password");
            }
        } catch (StudentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    private String hashPassword(String password){
        //TODO: implement password hashing
        return password;
    }
}
