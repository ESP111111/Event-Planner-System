package newpackage;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class NotificationService {

    private static Set<Integer> notifiedEvents = new HashSet<>();

    public static void main(String[] args) {
        try {
            if (SystemTray.isSupported()) {
                SystemTray tray = SystemTray.getSystemTray();

                
                Image image = Toolkit.getDefaultToolkit().createImage("EP.png");

                TrayIcon trayIcon = new TrayIcon(image, "Notification Demo");
                trayIcon.setImageAutoSize(true);
                tray.add(trayIcon);

                while (true) {
                    updateAndShowNotifications(trayIcon);
                    Thread.sleep(30000); 
                    int TIME = 0;
                    TIME++;
                    if(TIME == 60)
                    {
                        break;
                    }
                    
                }
            } else {
                System.err.println("System tray not supported!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void updateAndShowNotifications(TrayIcon trayIcon) throws SQLException {
        Set<Integer> currentEvents = new HashSet<>();
        String query = "SELECT concat(users.first_name , ' ' , users.last_name) ,\n" +
"event_info.id,\n" +
"event_info.name ,\n" +
"event_info.event_date,\n" +
"event_info.event_time\n" +
"FROM event_info \n" +
"LEFT JOIN organizer ON organizer.id = event_info.organizer_id \n" +
"LEFT JOIN users ON users.id = organizer.user_id \n" +
"WHERE \n" +
"   token = 1\n" +
"  AND (\n" +
"    -- Events starting in the next 24 hours\n" +
"    TIMESTAMP(event_date, event_time) BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 24 HOUR) \n" +
"    OR \n" +
"    -- Events starting in the next 12 hours\n" +
"    TIMESTAMP(event_date, event_time) BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 12 HOUR)\n" +
"    OR \n" +
"    -- Events starting right now\n" +
"    TIMESTAMP(event_date, event_time) = NOW()\n" +
"  );";
        Connection conn = null;
        Statement stmt  = null;      
        ResultSet rs    = null;
        try{
         conn = DatabaseConnection.getConnection();
         stmt = conn.createStatement();
         rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt(2);
            String user_name = rs.getString(1);
            String event_name = rs.getString(3);
            String event_date = rs.getString(4);
            String event_time = rs.getString(5);
            if (!notifiedEvents.contains(id)) {
                showNotification(trayIcon, "Event Planner\nEvent ID:"+id, "Hi: " + user_name + "\nThere are less than 24 hours left until Event "+event_name+" starts \nIn: "+event_date+" at: "+event_time);
                notifiedEvents.add(id);
            }
            currentEvents.add(id);
        }
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        finally {
        // Close resources in the finally block
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error closing ResultSet: " + e.getMessage());
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error closing Statement: " + e.getMessage());
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing PreparedStatement: " + e.getMessage());
            }
        }
        }
        

        notifiedEvents.retainAll(currentEvents);
    }

    private static void showNotification(TrayIcon trayIcon, String title, String message) {
        trayIcon.displayMessage(title, message, MessageType.INFO);
    }
}
