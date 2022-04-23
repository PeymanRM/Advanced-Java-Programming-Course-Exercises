package homework1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private static Database database = new Database();
    public static Database getInstance() {return database;}
    private static Connection connection = null;
    private Database() {
        try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanced-java-programming-course"
                , "JavaLearner", "LearningIsFun,HomeworkIsn't");
        } catch (SQLException e) {
            System.out.println("DB ERROR " + e.getMessage());
        }
    }

    public void addUser(User user){
        try {
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("insert into l4-homework1 (id,username,emailAddress,password,age,degree) " +
                            "values (SELECT COUNT(*) FROM l4-homework1,?,?,?,?,?)");
            preparedStatement1.setString(2, user.getUsername());
            preparedStatement1.setString(3, user.getEmailAddress());
            preparedStatement1.setString(4, user.getPassword());
            preparedStatement1.setInt(5, user.getAge());
            preparedStatement1.setString(6, user.getDegree());

            System.out.println ("Insert into DB: "+preparedStatement1.executeUpdate());
        } catch (SQLException e) {
            System.out.println("DB ERROR " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("DB ERROR " + e.getMessage());
        }
    }
}
