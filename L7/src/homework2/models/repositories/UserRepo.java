package homework2.models.repositories;

import homework2.models.entities.UserEnti;

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
        preparedStatement = connection.prepareStatement("select count(*) from l7homework2");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id = resultSet.getInt(1) + 1;

        preparedStatement=connection.prepareStatement ("INSERT INTO l7homework2(name, nationalCode, password, phoneNumber, `order`, debt, id) VALUES (?,?,?,?,?,?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getNationalCode());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getPhoneNumber());
        preparedStatement.setString(5, user.getOrder());
        preparedStatement.setInt(6, user.getDebt());
        preparedStatement.setInt(7, id);
        preparedStatement.executeUpdate();
    }
    public String selectUserPassword(String nationalCode) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM l7homework2 WHERE nationalCode =\"" + nationalCode + "\"");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("password");
    }
    public UserEnti selectUser(String nationalCode) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM l7homework2 WHERE nationalCode =\"" + nationalCode + "\"");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new UserEnti().setName(resultSet.getString("name")).setNationalCode(resultSet.getString("nationalCode"))
                .setPhoneNumber(resultSet.getString("phoneNumber")).setPassword(resultSet.getString("password"))
                .setOrder(resultSet.getString("order")).setDebt(resultSet.getInt("debt"));
    }
    public void updateOrder(String nationalCode, String order, int debt) throws Exception {
        preparedStatement = connection.prepareStatement("UPDATE l7homework2 SET `order`=?, debt=? WHERE nationalCode=?");
        preparedStatement.setString(1, order);
        preparedStatement.setInt(2, debt);
        preparedStatement.setString(3, nationalCode);
        preparedStatement.executeUpdate();
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
