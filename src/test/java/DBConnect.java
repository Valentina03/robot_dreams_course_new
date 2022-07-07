import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private static DBConnect instance;
    private final Connection dbConnect;
    private final String dbUser;
    private static final Logger log = LogManager.getLogger(DBConnect.class);


    private DBConnect(String url, String dbUser, String dbPassword) throws SQLException {
        this.dbConnect = DriverManager.getConnection(url, dbUser, dbPassword);
        this.dbUser = dbUser;
    }

    public static DBConnect getInstance(String url, String dbUser, String dbPassword) throws SQLException {
        if (instance == null) {
            instance = new DBConnect(url, dbUser, dbPassword);
        } else if (!instance.dbUser.equals(dbUser)) {
            log.warn("Connection is open with different credentials");
        }
        return instance;
    }

    public static void closeConnect() throws SQLException {
        if (instance != null) {
            instance.getConnect().close();
        }
    }

    public Connection getConnect() {
        return this.dbConnect;
    }
}
