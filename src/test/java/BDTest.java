import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDTest extends BaseTest{

    @Test
    public void checkConnectToDBTest() throws SQLException {
        Statement sqlStatement = getConnect().createStatement();
        ResultSet resultSet = sqlStatement.executeQuery("SELECT * FROM pg_catalog.pg_tables");
    }
    @Test
    public void addNewCustomerTest() throws SQLException {
        Statement sqlStatement = getConnect().createStatement();
        ResultSet resultSet = sqlStatement.executeQuery("INSERT INTO Customers VALUES (3,'Ira','Bancova','05066585','test3@gmail.com','Some address3','36065')");
    }

    @Test
    public void getOrdersTest() throws SQLException {
        Statement sqlStatement = getConnect().createStatement();
        ResultSet resultSet = sqlStatement.executeQuery("SELECT * FROM public.Orders");
    }

    @Test
    public void updateProductTest() throws SQLException {
        Statement sqlStatement = getConnect().createStatement();
        ResultSet resultSet = sqlStatement.executeQuery("UPDATE Product SET name='TRENCH COAT' Where id=3");
    }

    @Test
    public void deleteCustomerTest() throws SQLException {
        Statement sqlStatement = getConnect().createStatement();
        ResultSet resultSet = sqlStatement.executeQuery("DELETE FROM Customer Where id=3");
    }
}
