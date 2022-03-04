package classwork;

public class Main {
    public static void main(String[] args) {
        Role obj = new Student();
        obj.getRole();
        obj = new Employee();
        obj.getRole();
        obj = new Teacher();
        obj.getRole();
    }
}
