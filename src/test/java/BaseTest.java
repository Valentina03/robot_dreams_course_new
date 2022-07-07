import org.testng.annotations.AfterSuite;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {
    public String bdAddress = "jdbc:postgresql://127.0.0.1:8090/postgres";
    public String dbUser = "postgres";
    public String dbPassword = "mypasspostgres";
    private static final Logger log = LogManager.getLogger(BaseTest.class);


    protected Connection getConnect() throws SQLException {
        return DBConnect.getInstance(bdAddress, dbUser, dbPassword).getConnect();
    }

    @AfterSuite
    public void tearDown() {
        try {
            DBConnect.closeConnect();
        } catch (SQLException e) {
            log.error("Failed to close connection {}", e.getMessage());
        }
    }
}
