package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Events
{
    public void print_categories()
    {
       String query = " select * from event_category";
       try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + " | Name: " + name);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void insert_new_event(Event E) 
    {
        String query = "INSERT INTO `event_info` (`organizer_id`, `event_category_id`, `name`, `event_date`, `event_time`, `description`, `no_visitor`, `price_per_person`, `no_meals`, `meal_price`, `no_drinks`, `drink_price`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setInt(1, E.organizer_id);
            pst.setInt(2, E.event_category_id);
            pst.setString(3, E.name);
            pst.setString(4, E.event_date);
            pst.setString(5, E.event_time);
            pst.setString(6, E.description);
            pst.setInt(7, E.no_vesitors);
            pst.setFloat(8, E.price_per_visitor);
            pst.setInt(9, E.no_meals);
            pst.setFloat(10, E.meal_price);
            pst.setInt(11, E.no_drinks);           
            pst.setFloat(12, E.drink_price);

            pst.executeUpdate();
          
            query = "select max(id) from event_info;";
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            if (rs.next())
            {
                int maxId = rs.getInt(1);
                E.id = maxId;
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
    }
    
    public void print_org_events(int org_id)
    {
          String query = "select id , name , event_date , event_time from event_info where organizer_id = "+org_id+" order by event_date , event_time; ";
       try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String date = rs.getString("event_date");
                String time = rs.getString("event_time");
                System.out.println("ID: " + id + " | Name: " + name + " | Date: " + date + " | Time: " + time);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void get_one_event(int event_id) 
    {
         String query = "SELECT event_info.id, event_info.organizer_id, event_info.event_category_id, " +
                   "event_info.name, event_info.description, event_info.event_date, event_info.event_time, " +
                   "event_info.no_visitor, event_info.price_per_person, event_info.no_meals, event_info.meal_price, " +
                   "event_info.no_drinks, event_info.drink_price, " +
                   "CONCAT(users.first_name, ' ', users.last_name) AS organizer_name, " +
                   "event_category.name AS category_name " +
                   "FROM event_info " +
                   "LEFT JOIN organizer ON organizer.id = event_info.organizer_id " +
                   "LEFT JOIN users ON users.id = organizer.user_id " +
                   "LEFT JOIN event_category ON event_category.id = event_info.event_category_id " +
                   "WHERE event_info.id = ?;";

   
         try (Connection conn = DatabaseConnection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(query))
         {
             pstmt.setInt(1, event_id);
             ResultSet rs = pstmt.executeQuery();
             if (rs.next()) {
                 System.out.println("Event ID: " + rs.getInt("id"));
                 System.out.println("Organizer Name: " + rs.getString("organizer_name"));
                 System.out.println("Category Name: " + rs.getString("category_name"));
                 System.out.println("Name: " + rs.getString("name"));
                 System.out.println("Description: " + rs.getString("description"));
                 System.out.println("Event Date: " + rs.getString("event_date"));
                 System.out.println("Event Time: " + rs.getString("event_time"));
                 System.out.println("Number of Visitors: " + rs.getInt("no_visitor"));
                 System.out.println("Price per Person: " + rs.getFloat("price_per_person"));
                 System.out.println("Number of Meals: " + rs.getInt("no_meals"));
                 System.out.println("Meal Price: " + rs.getFloat("meal_price"));
                 System.out.println("Number of Drinks: " + rs.getInt("no_drinks"));
                 System.out.println("Drink Price: " + rs.getFloat("drink_price"));
        }
         } catch (SQLException e) 
         {
             System.out.println(e);
         }
    }
    
     public void get_event_meta(int event_id) 
    {
         String query = "SELECT * FROM event_meta WHERE event_info_id = ?;";

   
         try (Connection conn = DatabaseConnection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(query))
         {
             pstmt.setInt(1, event_id);
             ResultSet rs = pstmt.executeQuery();
              while (rs.next()) {
                int id = rs.getInt("id");
                String link = rs.getString("link");
                int type = rs.getInt("type");
                String e_type = null;
                if(type == 1)
                {
                    e_type = "Image";
                }
                else
                {
                    e_type = "Video";
                }
                System.out.println("ID: " + id + " | Link: " + link + " | Date: " + e_type );
            }
         } catch (SQLException e) 
         {
             System.out.println(e);
         }
    }
    
     public void add_meta(int event_id , String link , int type)
     {
          String query = "INSERT INTO `event_meta` (`event_info_id`, `link`, `type`) VALUES (? ,? ,? );";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setInt(1, event_id);
            pst.setString(2, link);
            pst.setInt(3, type);
            
            pst.executeUpdate();
            System.out.println("Done");
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
     }
     
      public void get_Invitations(int event_id) 
    {
         String query = "SELECT visitor_id , concat(users.first_name , ' ' , users.last_name) as \"user name\" ,\n" +
                        "no_persons , VIP\n" +
                        "FROM `visits_order`\n" +
                        "left join visitor on visitor.id = visits_order.visitor_id\n" +
                        "left join users on users.id = visitor.user_id\n" +
                        "WHERE  event_info_id = ?;";

         try (Connection conn = DatabaseConnection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(query))
         {
             pstmt.setInt(1, event_id);
             ResultSet rs = pstmt.executeQuery();
              while (rs.next()) {
                int visitor_id = rs.getInt("visitor_id");
                String user_name = rs.getString("user name");
                int no_visitors = rs.getInt("no_persons");
                int VIP = rs.getInt("VIP");
                String e_vip = null;
                if(VIP == 0)
                {
                    e_vip = "NO";
                }
                else
                {
                    e_vip = "YES";
                }
                System.out.println("Visitor ID: " + visitor_id + " | Visitor name: " + user_name + " | no_persons: " + String.valueOf(no_visitors) + " | VIP: " + e_vip);
            }
         } catch (SQLException e) 
         {
             System.out.println(e);
         }
    }
    
     public void add_Invitation(int event_id,int visitor_id , int no_invites , int VIP)
     {
          String query = "INSERT INTO `visits_order` (`visitor_id`, `event_info_id`, `no_persons`, `VIP`) VALUES ( ?, ?, ?, ?);";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setInt(1, visitor_id);
            pst.setInt(2, event_id);         
            pst.setInt(3, no_invites);
            pst.setInt(4, VIP);
            
            pst.executeUpdate();
            System.out.println("Done");
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
     }
     
    public boolean delete_event(int event_id)
    {
        String query = "DELETE FROM event_info WHERE id = ?;";
        boolean isSuccess = false;
        
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query))
        {
            pstmt.setInt(1, event_id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                isSuccess = true;
                System.out.println("Event with ID " + event_id + " was successfully deleted.");
            } else {
                System.out.println("No event found with ID " + event_id + ", or it could not be deleted.");
            }
            
        } catch (SQLException e) {
            System.out.println("SQL error occurred: " + e.getMessage());
        }
        return isSuccess; 
    }
    
     public void order_to_place(int place_id , int event_id , String start_date ,  String end_date ,  String start_time ,  String end_time  )
     {
      String query = "INSERT INTO `event_place_order` (`event_info_id`, `place_id`, `start_date`, `end_date`, `start_time`, `end_time`) VALUES ( ? , ? , ? , ? , ? , ?);";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setInt(1, event_id);
            pst.setInt(2, place_id);
            pst.setString(3, start_date);
            pst.setString(4, end_date);
            pst.setString(5 , start_time);
            pst.setString(6, end_time);
            
            pst.executeUpdate();
            
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
     }
}

