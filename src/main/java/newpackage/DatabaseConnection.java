
package newpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    
    private static final String URL = "jdbc:mysql://localhost:3306/eventplanner";
    private static final String USER = "root";
    private static Connection connection = null;
    
    private DatabaseConnection()
    {
    }
    public static Connection getConnection() {
        try {
        if (connection == null || connection.isClosed()) 
        {
            String password = "";
            connection = DriverManager.getConnection(URL, USER, password);
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
