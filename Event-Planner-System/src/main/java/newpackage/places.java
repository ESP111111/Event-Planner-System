
package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class places
{ 
  public void insert_new_place(int vendor_id , String name,String location , int capacity , float price , int rate)
  {
      String query = "INSERT INTO `place` (`vendor_id`, `name`, `location`, `capacity`, `Price_per_hour`, `rate`) VALUES (? , ? , ? , ? , ? , ?);";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setInt(1, vendor_id);
            pst.setString(2, name);
            pst.setString(3, location);
            pst.setInt(4, capacity);
            pst.setFloat(5 , price);
            pst.setInt(6, rate);
            
            pst.executeUpdate();
            
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
  }
  
  public void print_all_places(int vendor_id)
  {
        String query = "SELECT * FROM PLACE WHERE vendor_id = "+vendor_id+" ;";
       try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                int capacity = rs.getInt("capacity");
                float price = rs.getFloat("price_per_hour");
                int rate = rs.getInt("rate");
                System.out.println("ID: " + id + " | Name: " + name + " | Location: " + location + " | Capacity: " + capacity + " | Price per hour: " + price + " | Rate: " + rate);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
  }
  
  public void print_one_place(int place_id)
  {
     String query = "select \n" +
             "event_info.id,\n" +
             "place.name , \n" +
             "event_place_order.start_date,\n" +
             "event_place_order.end_date ,\n" +
             "event_place_order.start_time,\n" +
             "event_place_order.end_time ,\n" +
             "event_info.name ,\n" +
             "concat(users.first_name , ' ' , users.last_name)\n" +
             "from place \n" +
             "left join event_place_order on event_place_order.place_id = place.id\n" +
             "left join event_info on event_info.id = event_place_order.event_info_id\n" +
             "left join organizer on organizer.id = event_info.organizer_id\n" +
             "left join users on users.id = organizer.user_id\n" +
             "where place.id = " + place_id + " ORDER BY  event_place_order.start_date, event_place_order.start_time  ;";
     try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int event_id = rs.getInt(1);
                String place_name = rs.getString(2);
                String start_date = rs.getString(3);
                String end_date = rs.getString(4);
                String start_time = rs.getString(5);
                String end_time = rs.getString(6);
                String event_name = rs.getString(7);
                String user_name = rs.getString(8);

                System.out.println("Event ID: " + event_id + " | Event Name: " + event_name + " | Place Name: " + place_name + " | Start Date: " + start_date + " | End Date: " + end_date + " | Start Time: " + start_time + " | End Time: " + end_time + " | Organizer Name: " + user_name);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
     
  } 
}
