package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class users 
{
    public int id;
    private String user_name;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String image;
    public int user_id;
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
        user_id = -1;
        type = -1;
    }        
     public int sign_up(String User_name,String First_name,String Last_name,String Email ,String Password,String Image,int type )
    {
        String query = "INSERT INTO users (user_name, first_name, last_name, email, password, image) VALUES (?, ?, ?, ?, ?, ?)";
        Connection con  = null;
        PreparedStatement pst = null;
        Statement stmt = null;
        PreparedStatement pst1 = null;
        ResultSet rs = null;
        try
        {
             con = DatabaseConnection.getConnection();
             pst = con.prepareStatement(query);
        
            pst.setString(1, User_name);
            pst.setString(2, First_name);
            pst.setString(3, Last_name);
            pst.setString(4, Email);
            pst.setString(5, Password);
            pst.setString(6, Image);

            pst.executeUpdate();
            // give new user id for to register this in user type                        
            query = "select max(id) from users;";
            stmt = con.createStatement();
            rs= stmt.executeQuery(query);
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
            pst1 = con.prepareStatement(query);
            pst1.setString(1,  String.valueOf(this.id));
            pst1.executeUpdate();
            // close DB conniction
            DatabaseConnection.closeConnection();
            
            
            System.out.println("Create account succeeded");
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
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
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("Error closing PreparedStatement: " + e.getMessage());
            }
        }
        if (pst1 != null) {
            try {
                pst1.close();
            } catch (SQLException e) {
                System.out.println("Error closing PreparedStatement1: " + e.getMessage());
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error closing Connection: " + e.getMessage());
            }
        }
    }
        return this.id;
    }
    
    public int login(String User_name, String Password) {
        String query = "SELECT * FROM users WHERE user_name = ? AND password = ?";
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        PreparedStatement pstmt4 = null;
        try {
            con = DatabaseConnection.getConnection();
            pstmt1 = con.prepareStatement(query);
            pstmt1.setString(1, User_name);
            pstmt1.setString(2, Password);
            rs = pstmt1.executeQuery();
            

            if (rs.next()) {
                this.id = rs.getInt("id");
                this.user_name = rs.getString("user_name");
                this.first_name = rs.getString("first_name");
                this.last_name = rs.getString("last_name");
                this.email = rs.getString("email");
                this.password = rs.getString("password");
                this.image = rs.getString("image");

                String vendorQuery = "SELECT id FROM vendor WHERE user_id = ?";
                String organizerQuery = "SELECT id FROM organizer WHERE user_id = ?";
                String visitorQuery = "SELECT id FROM visitor WHERE user_id = ?";

                try {
                    pstmt2 = con.prepareStatement(vendorQuery);
                    pstmt3 = con.prepareStatement(organizerQuery);
                    pstmt4 = con.prepareStatement(visitorQuery);
                    pstmt2.setInt(1, this.id);
                    pstmt3.setInt(1, this.id);
                    pstmt4.setInt(1, this.id);
                    ResultSet rs2 = pstmt2.executeQuery();
                    ResultSet rs3 = pstmt3.executeQuery();
                    ResultSet rs4 = pstmt4.executeQuery();
                    if (rs2.next()) {
                        this.type = 1;
                    } else if (rs3.next()) {
                        this.type = 2;
                    } else if (rs4.next()) {
                        this.type = 3;
                    } else {
                        System.out.println("Invalid user name, password, or type");
                        this.id = -1;
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            } else {
                System.out.println("Invalid user name or password");
                this.id = -1;
            }

            query = "UPDATE users SET token = '1' WHERE id = ?";
            pstmt1 = con.prepareStatement(query);
            pstmt1.setInt(1, this.id);
            pstmt1.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
            this.id = -1;
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
        if (pstmt1 != null) {
            try {
                pstmt1.close();
            } catch (SQLException e) {
                System.out.println("Error closing Statement: " + e.getMessage());
            }
        }
        if (pstmt2 != null) {
            try {
                pstmt2.close();
            } catch (SQLException e) {
                System.out.println("Error closing PreparedStatement: " + e.getMessage());
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error closing Connection: " + e.getMessage());
            }
        }
        if (pstmt3 != null) {
            try {
                pstmt3.close();
            } catch (SQLException e) {
                System.out.println("Error closing Connection: " + e.getMessage());
            }
        }
        if (pstmt4 != null) {
            try {
                pstmt4.close();
            } catch (SQLException e) {
                System.out.println("Error closing Connection: " + e.getMessage());
            }
        }
        
    }
        return this.id;
    }

    
    public int logout(int user_id)
    {
        String query = "UPDATE users SET token = '0' where users.id = "+user_id+";";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.executeUpdate();
            return 1;
        }
         catch (SQLException ex) {
            System.out.println(ex);
        }
        return 0;
    }
    //Getter
    public int get_id()
    {
        return this.id;
    }
    public String get_user_name()
    {
        return this.user_name;
    }
    public String get_first_name()
    {
        return this.first_name;
    }
    public String get_last_name()
    {
        return this.last_name;
    }
    public String get_email()
    {
        return this.email;
    }
    public String get_password()
    {
        return this.password;
    }
    public String get_image()
    {
        return this.image;
    }
    public int get_type()
    {
        return this.type;
    }
    //update user profile
    public int set_user_name(users user , String new_user_name)
    {
        int status = 0;
         String query = "UPDATE users SET user_name = ? WHERE id = ?";
        try(Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setString(1, new_user_name);
            pst.setInt(2, user.get_id()); 
            
            pst.executeUpdate();
            user.user_name = new_user_name;
            status = 1;
                       
        } catch (SQLException e) {
            System.out.println("Erorr in update user name"+e);
        }
        return status;
    }
      public int set_first_name(users user , String new_first_name)
    {
         int status = 0;
         String query = "UPDATE users SET first_name = ? WHERE id = ?";
        try(Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setString(1, new_first_name);
            pst.setInt(2, user.get_id()); 
            
            pst.executeUpdate();
            user.first_name = new_first_name;
            status = 1;
                       
        } catch (SQLException e) {
            System.out.println("Erorr in update first name"+e);
        }
        return status;
    }
        public int set_last_name(users user , String new_last_name)
    {
        int status = 0;
         String query = "UPDATE users SET last_name = ? WHERE id = ?";
        try(Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setString(1, new_last_name);
            pst.setInt(2, user.get_id()); 
            
            pst.executeUpdate();
            user.last_name = new_last_name;
            status = 1;
                       
        } catch (SQLException e) {
            System.out.println("Erorr in update last name"+e);
        }
        return status;
    }
      public int set_email(users user , String new_email)
    {
         int status = 0;
         String query = "UPDATE users SET email= ? WHERE id = ?";
        try(Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setString(1, new_email);
            pst.setInt(2, user.get_id()); 
            
            pst.executeUpdate();
            user.email = new_email;
            status = 1;
                       
        } catch (SQLException e) {
            System.out.println("Erorr in update email"+e);
        }
        return status;
    }
      public int set_password(users user , String new_password)
    {
        int status = 0;
         String query = "UPDATE users SET password = ? WHERE id = ?";
        try(Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setString(1, new_password);
            pst.setInt(2, user.get_id()); 
            
            pst.executeUpdate();
            user.password = new_password;
            status = 1;
                       
        } catch (SQLException e) {
            System.out.println("Erorr in update password"+e);
        }
        return status;
    }
    public int set_image(users user , String new_image)
    {
        int status = 0;
         String query = "UPDATE users SET image = ? WHERE id = ?";
        try(Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query))
        {
            pst.setString(1, new_image);
            pst.setInt(2, user.get_id()); 
            
            pst.executeUpdate();
            user.image = new_image;
            status = 1;
                       
        } catch (SQLException e) {
            System.out.println("Erorr in update image"+e);
        }
        return status;
    }
     @Override
    public String toString()
    {
        return "Welcome " + first_name + " " + last_name + " in your profile:"+
                "\n (1) id:"+this.id+               
                "\n (2) user name:"+this.user_name+
                "\n (3) first name:"+this.first_name+
                "\n (4) last name:"+this.last_name+
                "\n (5) email:"+this.email+
                "\n (6) password:"+this.password+
                "\n (7) image url:"+this.image;
    }
}

