import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDTest extends BaseTest{

    @Test
    public void checkConnectToDBTest() throws SQLException {
        String sqlPattern = "SELECT * FROM pg_catalog.pg_tables";
        PreparedStatement statement = getConnect().prepareStatement(sqlPattern);
        ResultSet resultSet = statement.executeQuery();
    }

    @Test
    public void addNewCustomerTest() throws SQLException {
        String sqlPattern = "INSERT INTO сustomers VALUES (3,?,?,?,?,?,?)";
        PreparedStatement statement = getConnect().prepareStatement(sqlPattern);
        statement.setString(1,"Ira");
        statement.setString(2,"Bancova");
        statement.setString(3,"05066585");
        statement.setString(4,"test3@gmail.com");
        statement.setString(5,"Some address3");
        statement.setString(6,"36065");
        ResultSet resultSet = statement.executeQuery();
    }

    @Test
    public void getOrderTest() throws SQLException {
        String sqlPattern = "SELECT * FROM orders WHERE product_id=3";
        PreparedStatement statement = getConnect().prepareStatement(sqlPattern);
        ResultSet resultSet = statement.executeQuery();
    }

    @Test
    public void updateProductTest() throws SQLException {
        String sqlPattern = "UPDATE products SET name=? Where id=3";
        PreparedStatement statement = getConnect().prepareStatement(sqlPattern);
        statement.setString(1, "TRENCH COAT");
        ResultSet resultSet = statement.executeQuery();
    }

    @Test
    public void deleteCustomerTest() throws SQLException {
        String sqlPattern = "DELETE FROM customers Where email=?";
        PreparedStatement statement = getConnect().prepareStatement(sqlPattern);
        statement.setString(1, "test@gmail.com");
        ResultSet resultSet = statement.executeQuery();
    }
}
