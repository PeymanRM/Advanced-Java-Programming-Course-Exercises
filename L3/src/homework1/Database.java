package homework1;

public final class Database {
    private static Student[] students = new Student[10];

    public static Student findByUsername(String username) throws StudentException{
        for (Student student : students) {
            if(student.getUsername().equals(username)) return student;
        }
        throw new StudentException("Invalid username or password");
    }

    public void addStudent(Student student) {

    }
}
