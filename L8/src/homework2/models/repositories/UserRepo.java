package homework2.models.repositories;

import homework2.models.entities.UserEnti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        preparedStatement = connection.prepareStatement("select count(*) from l7classwork");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id = resultSet.getInt(1) + 1;

        preparedStatement=connection.prepareStatement ("INSERT INTO l7classwork(name, username, password, email, id) VALUES (?,?,?,?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setInt(5, id);
        preparedStatement.executeUpdate();
    }
    public String selectUserPassword(String username) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM l7classwork WHERE username =\"" + username + "\"");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("password");
    }
    public UserEnti selectUser(String username) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM l7classwork WHERE username =\"" + username + "\"");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new UserEnti().setName(resultSet.getString("name")).setUsername(resultSet.getString("username"))
                .setEmail(resultSet.getString("email"));
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
