package homework1;

import java.sql.*;

public class Database {
    private static Database database = new Database();
    public static Database getInstance() {return database;}
    private Connection connection = null;
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
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select count(*) from l6homework1");
            resultSet.next();
            int id = resultSet.getInt(1) + 1;

            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into l6homework1 (id,username,emailAddress,password,age,degree) values (?,?,?,?,?,?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmailAddress());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getAge());
            preparedStatement.setString(6, user.getDegree());

            preparedStatement.executeUpdate();
            System.out.println("User Created");
        } catch (SQLException e) {
            System.out.println("DB ERROR " + e.getMessage());
        }
    }

    public void showUsers() {

    }

    public void updateUser(int id, User user) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update l6homework1 set username=?,emailAddress=?,password=?,age=?,degree=? where id="+id);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmailAddress());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, user.getDegree());

            preparedStatement.executeUpdate();
            System.out.println("User Updated");
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
