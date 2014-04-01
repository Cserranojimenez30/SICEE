package Utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author aya
 */
public class SQLServerConnection {

    private static ResourceBundle properties;

    private static String host;
    private static String port;
    private static String database;
    private static String user;
    private static String password;

    public static Connection getConnection(String propertiesFile) {
        try {
            System.out.print("Conecting with the database... ");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            properties = ResourceBundle.getBundle(propertiesFile);

            host = properties.getString("host");
            port = properties.getString("port");
            database = properties.getString("database");
            user = properties.getString("user");
            password = properties.getString("password");

            Connection con = DriverManager.getConnection(
                    String.format("jdbc:sqlserver://%s:%s;databaseName=%s", host, port, database),
                    user, password);

            System.out.println("success.");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("failed.\n" + ex);
            return null;
        }
    }
}
