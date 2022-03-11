package homework1;

/**
 * Created by Peyman RM
 */
public final class Database {
    private static Student[] students = new Student[10];
    private static int studentCount = 0;

    public static Student findByUsername(String username) throws StudentException{
        for (Student student : students) {
            if(student.getUsername().equals(username)) return student;
        }
        throw new StudentException("Invalid username or password");
    }

    public void addStudent(Student student) throws DatabaseException{
        if(studentCount != 10){
            students[studentCount] = student;
            studentCount++;
        } else {
            throw new DatabaseException("Database reached its maximum capacity");
        }
    }
}
