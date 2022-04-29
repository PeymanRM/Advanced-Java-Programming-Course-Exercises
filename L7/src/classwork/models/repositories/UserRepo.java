package classwork.models.repositories;

import classwork.models.entities.UserEnti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserRepo() throws Exception{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanced-java-programming-course"
                , "JavaLearner", "LearningIsFun,HomeworkIsn't");;
        connection.setAutoCommit (false);
    }

    public void insertUser(UserEnti user) throws Exception {
        preparedStatement=connection.prepareStatement ("INSERT INTO l7classwork(name, username, password, email) VALUES (?,?,?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getEmail());
    }
    public UserEnti selectUser(String username) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM l7classwork WHERE username=?");
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        return new UserEnti().setName(resultSet.getString("name")).setUsername(resultSet.getString("username"))
                .setEmail(resultSet.getString("email")).setPassword(resultSet.getString("password"));
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
