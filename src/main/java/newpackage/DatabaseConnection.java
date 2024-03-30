
package newpackage;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    
    private static final String URL = "jdbc:mysql://localhost:3306/eventplanner";
    private static final String USER = "root";
    private static Connection connection = null;
    
    private DatabaseConnection()
    {
    }
    public static Connection getConnection()
    {
        try {
        if (connection == null || connection.isClosed()) 
        {
            InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties");
            Properties prop = new Properties();
            prop.load(input);

            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");
            
            connection = DriverManager.getConnection(url, user, password);
        }

        } catch (SQLException e) {
            System.out.println(e);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
