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
}

