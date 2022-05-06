package homework1.models.repositories;

import homework1.models.entities.UserEnti;

import java.sql.*;

/**
 * Created by Peyman RM
 */
public class UserRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserRepo() throws Exception{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanced-java-programming-course"
                , "JavaLearner", "LearningIsFun,HomeworkIsn't");;
        connection.setAutoCommit (false);
    }

    public void insertUser(UserEnti user) throws Exception {
        preparedStatement = connection.prepareStatement("select count(*) from l7homework1");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id = resultSet.getInt(1) + 1;

        preparedStatement=connection.prepareStatement ("INSERT INTO l7homework1(name, username, password, phoneNumber, traffic, debt, id) VALUES (?,?,?,?,?,?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getPhoneNumber());
        preparedStatement.setDouble(5, user.getTraffic());
        preparedStatement.setInt(6, user.getDebt());
        preparedStatement.setInt(7, id);
        preparedStatement.executeUpdate();
    }
    public String selectUserPassword(String username) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM l7homework1 WHERE username =\"" + username + "\"");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("password");
    }
    public UserEnti selectUser(String username) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT * FROM l7homework1 WHERE username =\"" + username + "\"");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new UserEnti().setName(resultSet.getString("name")).setUsername(resultSet.getString("username"))
                .setPhoneNumber(resultSet.getString("phoneNumber")).setPassword(resultSet.getString("password"))
                .addTraffic(resultSet.getDouble("traffic")).addDebt(resultSet.getInt("debt"));
    }
    public void updateStatus(String username, double traffic, int debt) throws Exception {
        preparedStatement = connection.prepareStatement("UPDATE l7homework1 SET traffic=?, debt=? WHERE username=?");
        preparedStatement.setDouble(1, traffic);
        preparedStatement.setInt(2, debt);
        preparedStatement.setString(3, username);
        preparedStatement.executeUpdate();
    }
    public void commit() throws Exception{
        connection.commit ();
    }
    public void rollback() throws Exception{
        connection.rollback ();
    }
    public void close() throws Exception{
        preparedStatement.close ();
        connection.close ();
    }
}
