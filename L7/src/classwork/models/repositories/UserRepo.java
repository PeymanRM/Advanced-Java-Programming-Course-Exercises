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

    public void insert (UserEnti user) throws Exception {
        preparedStatement = connection.prepareStatement("select count(*) from l6homework1");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id = resultSet.getInt(1) + 1;

        preparedStatement=connection.prepareStatement ("INSERT INTO person(id, name, username, password, email) VALUES (?,?,?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getEmail());
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
