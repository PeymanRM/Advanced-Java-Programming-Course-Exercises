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
        username = input.nextLine();
        System.out.println("Enter student's password: ");
        password = hashPassword(input.nextLine());
    }

    public void login() {
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
                System.out.println("Logged in");
            } else{
                throw new StudentException("Invalid username or password");
            }
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getUsername() {
        return username;
    }

    private String hashPassword(String password){
        //TODO: implement password hashing
        return password;
    }
}
