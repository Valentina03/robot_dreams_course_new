import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest extends BaseTest{

    @Test
    public void checkConnectToDBTest() throws SQLException {
        String sqlPattern = "SELECT * FROM pg_catalog.pg_tables";
        PreparedStatement statement = getConnect().prepareStatement(sqlPattern);
        ResultSet resultSet = statement.executeQuery();
    }

    @Test
    public void addNewCustomerTest() throws SQLException {
        String sqlPattern = "INSERT INTO сustomers VALUES (3,'Ira','Bancova','05066585','test3@gmail.com','Some address3','36065')";
        PreparedStatement statement = getConnect().prepareStatement(sqlPattern);
        ResultSet resultSet = statement.executeQuery();
    }

    @Test
    public void getCustomerTest() throws SQLException {
        String sqlPattern = "SELECT * FROM сustomers WHERE first_name=?";
        PreparedStatement statement = getConnect().prepareStatement(sqlPattern);
        statement.setString(1, "Ira");
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
        statement.setString(1, "test3@gmail.com");
        ResultSet resultSet = statement.executeQuery();
    }
}
