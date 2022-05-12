package homework1.models.repositories;

import homework1.models.entities.EmployeeEnti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Peyman RM
 */
public class EmployeeRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public EmployeeRepo() throws Exception{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanced-java-programming-course"
                , "JavaLearner", "LearningIsFun,HomeworkIsn't");;
        connection.setAutoCommit (false);
    }

    public void insertEmployee(EmployeeEnti employee) throws Exception {
        preparedStatement = connection.prepareStatement("select count(*) from l8homework1");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id = resultSet.getInt(1) + 1;

        preparedStatement=connection.prepareStatement ("INSERT INTO l8homework1(name, fatherName, nationalCode, age, `degree`, phoneNumber, telephone, address, id) VALUES (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getFatherName());
        preparedStatement.setString(3, employee.getNationalCode());
        preparedStatement.setInt(4, employee.getAge());
        preparedStatement.setString(5, employee.getDegree());
        preparedStatement.setString(6, employee.getPhoneNumber());
        preparedStatement.setString(7, employee.getTelephone());
        preparedStatement.setString(8, employee.getAddress());
        preparedStatement.setInt(9, id);
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
