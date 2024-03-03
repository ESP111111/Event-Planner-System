package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class users 
{
    private int id;
    private String user_name;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String image;
    private int type; // 1- (1)vendor 2- (2)organizer 3- (3)visitor
    
    public users()
    {
        id = -1;
        user_name = null;
        first_name = null;
        last_name = null;
        email = null;
        password = null;
        image = null;
        type = -1;
    }        
    public int sign_up(String User_name,String First_name,String Last_name,String Email ,String Password,String Image,int type )
    {
        String query = "INSERT INTO users (user_name, first_name, last_name, email, password, image) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setString(1, User_name);
            pst.setString(2, First_name);
            pst.setString(3, Last_name);
            pst.setString(4, Email);
            pst.setString(5, Password);
            pst.setString(6, Image);

            pst.executeUpdate();
            // give new user id for to register this in user type                        
            query = "select max(id) from users;";
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            if (rs.next())
            {
                int maxId = rs.getInt(1);
                this.id = maxId;
            }
            String type_table = null;
            switch (type) {
                case 1:
                {
                    type_table = "vendor";
                    break;
                }
                case 2:
                {                       
                    type_table = "organizer";
                    break;
                }
                case 3:
                {
                    type_table = "visitor";
                    break;
                }        
                default:
                {
                    System.out.println("Error in signup : ---User type undefined---");
                }
            }
            query = "INSERT INTO "+type_table+" (user_id) VALUES (?)";
            PreparedStatement pst1 = con.prepareStatement(query);
            pst1.setString(1,  String.valueOf(this.id));
            pst1.executeUpdate();
            // close DB conniction
//            DatabaseConnection.closeConnection();
            System.out.println("Create account succeeded");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this.id;
    }

    public int get_id()
    {
        return this.id;
    }
}