
package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;
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
  
  
  // search code
  
  
      public void srch_byname(){
         
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter the name of the place to search: ");
         String placeName = scanner.nextLine();
         
           String sql = "SELECT * FROM place WHERE name = ?";
           String sqlReservation = "SELECT COUNT(*) AS reservation_count FROM event_place_order WHERE place_id = ?";
           String sqlReservationDetails = "SELECT start_date, end_date, start_time, end_time FROM event_place_order WHERE place_id = ?";
           
           

            try ( Connection conn = DatabaseConnection.getConnection(); 
        PreparedStatement pstmt = conn.prepareStatement(sql);
        PreparedStatement pstmtReservation = conn.prepareStatement(sqlReservation);
        PreparedStatement pstmtReservationDetails = conn.prepareStatement(sqlReservationDetails)) {
     
    pstmt.setString(1, placeName);
    ResultSet rs = pstmt.executeQuery();
    boolean placeFound = false;

    // Process the result set
    while (rs.next()) {
        placeFound = true;
        int id = rs.getInt("id");
        String name = rs.getString("name");
        pstmtReservation.setInt(1, id);
        ResultSet rsReservation = pstmtReservation.executeQuery();

        if (rsReservation.next()) {
            int reservationCount = rsReservation.getInt("reservation_count");
            if (reservationCount > 0) {
                int vendorId = rs.getInt("vendor_id");
                String location = rs.getString("location");
                int capacity = rs.getInt("capacity");
                float pricePerHour = rs.getFloat("Price_per_hour"); // Corrected column name
                float rate = rs.getFloat("rate");

                // Print the place details
                System.out.print("ID: " + id + "|" + "Vendor ID: " + vendorId + "|" + "Name: " + name + "|" + "Location: " + location + "|" + "Capacity: " + capacity + "|" + "Price Per hour: " + pricePerHour + "|" + "Rate: " + rate + "|" + " has been booking ");

                pstmtReservationDetails.setInt(1, id);
                ResultSet rsReservationDetails = pstmtReservationDetails.executeQuery();

                // Assuming there could be multiple reservations, iterate through them
                while (rsReservationDetails.next()) {
                    Date startDate = rsReservationDetails.getDate("start_date");
                    Date endDate = rsReservationDetails.getDate("end_date");
                    Time startTime = rsReservationDetails.getTime("start_time");
                    Time endTime = rsReservationDetails.getTime("end_time");

                    // Print the reservation details
                    System.out.println("Date(" + startDate + " to " + endDate + ")" + " Time(" + startTime + " to " + endTime + ")");
                }
            } else {
                int vendorId = rs.getInt("vendor_id");
                String location = rs.getString("location");
                int capacity = rs.getInt("capacity");
                float pricePerHour = rs.getFloat("Price_per_hour"); // Corrected column name
                float rate = rs.getFloat("rate");

                // Print the place details
                System.out.println("ID: " + id + "|" + "Vendor ID: " + vendorId + "|" + "Name: " + name + "|" + "Location: " + location + "|" + "Capacity: " + capacity + "|" + "Price Per hour: " + pricePerHour + "|" + "Rate: " + rate + "|" + " has not been booking");
            }
        }
    }
    if (!placeFound) {
        System.out.println("No place found with the name: " + placeName);
    }
} catch (SQLException e) {
    System.out.println("Error executing query: " + e.getMessage());
}
 
          
          
     }
          
          
          
          
     public void srch_bylocation()
      
      {
        Scanner scanner = new Scanner(System.in);
System.out.println("Enter the location of the place to search: ");
String locationName = scanner.nextLine();
String sql = "SELECT * FROM place WHERE location = ?";
String sqlReservation = "SELECT COUNT(*) AS reservation_count FROM event_place_order WHERE place_id = ?";
String sqlReservationDetails = "SELECT start_date, end_date, start_time, end_time FROM event_place_order WHERE place_id = ?";




try (Connection conn = DatabaseConnection.getConnection(); 
     PreparedStatement pstmt = conn.prepareStatement(sql);
     PreparedStatement pstmtReservation = conn.prepareStatement(sqlReservation);
     PreparedStatement pstmtReservationDetails = conn.prepareStatement(sqlReservationDetails)) {
    
    pstmt.setString(1, locationName);
    ResultSet rs = pstmt.executeQuery();
    boolean placeFound = false;

    
    
    
    // Process the result set
    while (rs.next()) {
        placeFound = true;
        int id = rs.getInt("id");
        String location = rs.getString("location");
        pstmtReservation.setInt(1, id);
        ResultSet rsReservation = pstmtReservation.executeQuery();

        if (rsReservation.next()) {
            int reservationCount = rsReservation.getInt("reservation_count");
            if (reservationCount > 0) {
                int vendorId = rs.getInt("vendor_id");
                String name = rs.getString("name");
                int capacity = rs.getInt("capacity");
                float pricePerHour = rs.getFloat("Price_per_hour"); // Changed to Price_per_hour
                float rate = rs.getFloat("rate");

                // Print the place details
                System.out.print("ID: " + id + "|" + "Vendor ID: " + vendorId + "|" + "Name: " + name + "|" + "Location: " + location + "|" + "Capacity: " + capacity + "|" + "Price Per hour: " + pricePerHour + "|" + "Rate: " + rate + "|" + " has been booking ");

                
                
                pstmtReservationDetails.setInt(1, id);
                ResultSet rsReservationDetails = pstmtReservationDetails.executeQuery();

                // Assuming there could be multiple reservations, iterate through them
                while (rsReservationDetails.next()) {
                    Date startDate = rsReservationDetails.getDate("start_date");
                    Date endDate = rsReservationDetails.getDate("end_date");
                    Time startTime = rsReservationDetails.getTime("start_time");
                    Time endTime = rsReservationDetails.getTime("end_time");

                    // Print the reservation details
                    System.out.println("Date(" + startDate + " to " + endDate + ")" + " Time(" + startTime + " to " + endTime + ")");
                }
            } else {
                int vendorId = rs.getInt("vendor_id");
                String name = rs.getString("name");
                int capacity = rs.getInt("capacity");
                float pricePerHour = rs.getFloat("Price_per_hour"); // Changed to Price_per_hour
                float rate = rs.getFloat("rate");

                // Print the place details
                System.out.println("ID: " + id + "|" + "Vendor ID: " + vendorId + "|" + "Name: " + name + "|" + "Location: " + location + "|" + "Capacity: " + capacity + "|" + "Price Per hour: " + pricePerHour + "|" + "Rate: " + rate + "|" + " has not been booking");
            }
        }
    }

    if (!placeFound) {
        System.out.println("No place found with the location: " + locationName);
    }
} catch (SQLException e) {
    System.out.println("Error executing query: " + e.getMessage());
}
 
          
          
          
          
      }
     
    
    
    public void srch_byprice()
    {
         
        Scanner scanner = new Scanner(System.in);
System.out.println("Enter the maximum hourly price of the place to search: ");
float place_maxHourlyPrice = scanner.nextFloat();

String sql = "SELECT * FROM place WHERE Price_per_hour <= ?";
String sqlReservation = "SELECT COUNT(*) AS reservation_count FROM event_place_order WHERE place_id = ?";
String sqlReservationDetails = "SELECT start_date, end_date, start_time, end_time FROM event_place_order WHERE place_id = ?";

try ( Connection conn = DatabaseConnection.getConnection(); 
      PreparedStatement pstmt = conn.prepareStatement(sql);
      PreparedStatement pstmtReservation = conn.prepareStatement(sqlReservation);
      PreparedStatement pstmtReservationDetails = conn.prepareStatement(sqlReservationDetails)) {
   
    pstmt.setFloat(1, place_maxHourlyPrice);
    ResultSet rs = pstmt.executeQuery();
    boolean placeFound = false;

    // Process the result set
    while (rs.next()) {
        placeFound = true;
        int id = rs.getInt("id");
        float pricePerHour = rs.getFloat("Price_per_hour");
        pstmtReservation.setInt(1, id);
        ResultSet rsReservation = pstmtReservation.executeQuery();

        if (rsReservation.next()) {
            int reservationCount = rsReservation.getInt("reservation_count");
            if (reservationCount > 0) {
                int vendorId = rs.getInt("vendor_id");
                String location = rs.getString("location");
                int capacity = rs.getInt("capacity");
                String name= rs.getString("name");
                float rate = rs.getFloat("rate");

                // Print the place details
                System.out.print("ID: " + id + "|" + "Vendor ID: " + vendorId + "|" + "Name: " + name + "|" + "Location: " + location + "|" + "Capacity: " + capacity + "|" + "Price Per hour: " + pricePerHour + "|" + "Rate: " + rate + "|" + " has been booking ");

                pstmtReservationDetails.setInt(1, id);
                ResultSet rsReservationDetails = pstmtReservationDetails.executeQuery();

                // Assuming there could be multiple reservations, iterate through them
                while (rsReservationDetails.next()) {
                    Date startDate = rsReservationDetails.getDate("start_date");
                    Date endDate = rsReservationDetails.getDate("end_date");
                    Time startTime = rsReservationDetails.getTime("start_time");
                    Time endTime = rsReservationDetails.getTime("end_time");

                    // Print the reservation details
                    System.out.println("Date(" + startDate + " to " + endDate + ")" + " Time(" + startTime + " to " + endTime + ")");
                }
            } else {
                int vendorId = rs.getInt("vendor_id");
                String location = rs.getString("location");
                int capacity = rs.getInt("capacity");
                String name = rs.getString("name");
                float rate = rs.getFloat("rate");

                // Print the place details
                System.out.println("ID: " + id + "|" + "Vendor ID: " + vendorId + "|" + "Name: " + name + "|" + "Location: " + location + "|" + "Capacity: " + capacity + "|" + "Price Per hour: " + pricePerHour + "|" + "Rate: " + rate + "|" + " has not been booking");
            }
        }
    }

    if (!placeFound) {
        System.out.println("No place found with the hourly price or less: " + place_maxHourlyPrice);
    }
} catch (SQLException e) {
    System.out.println("Error executing query: " + e.getMessage());
}

        
        
        
    }
    
    
    public void srch_byperiod()
    {  
          Scanner scanner = new Scanner(System.in);

System.out.println("Enter start date (YYYY-MM-DD): ");
String startDate = scanner.nextLine();
System.out.println("Enter start time (HH:MM:SS): ");
String startTime = scanner.nextLine();
System.out.println("Enter end time (HH:MM:SS): ");
String endTime = scanner.nextLine();

String sql = "SELECT p.id, p.name, p.location, p.capacity, p.Price_per_hour, p.rate " +
             "FROM place p " +
             "WHERE p.id NOT IN (" +
             "SELECT o.place_id " +
             "FROM event_place_order o " +
             "WHERE o.start_date = ? AND o.start_time <= ? AND o.end_time >= ?)";

try (Connection conn = DatabaseConnection.getConnection();
     PreparedStatement pstmt = conn.prepareStatement(sql)) {

    pstmt.setString(1, startDate);
    pstmt.setString(2, startTime);
    pstmt.setString(3, endTime);

    ResultSet rs = pstmt.executeQuery(); 
    System.out.println("The places available for booking based on the date you entered:");
    System.out.print("\n");
    while (rs.next()) {
        // Use the column names as they appear in the SQL statement above
        System.out.println("Place ID: " + rs.getInt("id") + " | " +
                           "Name: " + rs.getString("name") + " | " +
                           "Location: " + rs.getString("location") + " | " +
                           "Capacity: " + rs.getInt("capacity") + " | " +
                           "Price Per Hour: " + rs.getFloat("Price_per_hour") + " | " +
                           "Rate: " + rs.getFloat("rate"));
    }
} catch (SQLException e) {
    System.out.println("Error executing query: " + e.getMessage());
}
    
   
  
  
  
  
}
}

