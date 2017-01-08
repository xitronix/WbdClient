package basic;

/**
 * Created by xitronix on 06.11.2016.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {

    private static Connection conn;
    private static String url = "jdbc:oracle:thin:@localhost:1521:dbzst";
    private static String user = "WBDUSER";
    private static String pass = "hren";

    public static Connection connect() throws SQLException {
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn != null && !conn.isClosed())
            return conn;
        connect();
        return conn;

    }
}