package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, User_name);
            pst.setString(2, First_name);
            pst.setString(3, Last_name);
            pst.setString(4, Email);
            pst.setString(5, Password);
            pst.setString(6, Image);

            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.id;
    }
}