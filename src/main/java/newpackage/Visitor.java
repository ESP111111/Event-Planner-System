
package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Visitor 
{
    public void my_invitations(int user_id)
    {
        String query = 
                """
                select event_info.name , event_info.event_date , event_info.event_time,
                concat(users.first_name , ' ' , users.last_name),
                visits_order.no_persons ,
                if(visits_order.VIP = 1 , "YES" , "NO") as "VIP"
                from visitor
                left join visits_order on visits_order.visitor_id = visitor.id 
                left join event_info on event_info.id = visits_order.event_info_id
                left join organizer on organizer.id = event_info.organizer_id
                left join users on users.id = organizer.user_id
                
                where visitor.id = ? \n""" +
                "ORDER BY event_info.event_date , event_info.event_time\n" +
                ";" ;
        
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt1 = null;
         try {
            conn = DatabaseConnection.getConnection();
            pstmt1 = conn.prepareStatement(query);
            pstmt1.setInt(1, user_id);
            rs = pstmt1.executeQuery();
            
            while (rs.next()) {
                String event_name = rs.getString(1);
                String event_date = rs.getString(2);
                String event_time = rs.getString(3);
                String event_organizer = rs.getString(4);
                int on_visitors = rs.getInt(5);
                String VIP = rs.getString(6);
                System.out.println("Event Name: " + event_name + " | Event Date: "+event_date + " | Event Time: "+event_time + " | Event Organizer: "+event_organizer + " | NO_Your Visitors: "+String.valueOf(on_visitors) + " | VIP: "+VIP );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
         finally {
        
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error closing ResultSet: " + e.getMessage());
            }
        }
        if (pstmt1 != null) {
            try {
                pstmt1.close();
            } catch (SQLException e) {
                System.out.println("Error closing ResultSet: " + e.getMessage());
            }
        
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing ResultSet: " + e.getMessage());
            }
        }
         
         }
    }
}
