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
    public int login(String User_name , String Password)
    {
      
      String query = "select * from users where user_name = '"+User_name+"' and password = '"+Password+"'";        

      try (Connection con = DatabaseConnection.getConnection();)
      {
          Statement stmt = con.createStatement();
          ResultSet rs= stmt.executeQuery(query);
          if (rs.next())
          {
              int maxId = rs.getInt(1);
              this.id = maxId;
              this.user_name = rs.getString(2);
              this.first_name = rs.getString(3);
              this.last_name = rs.getString(4);
              this.email = rs.getString(5);
              this.password = rs.getString(6);
              this.image = rs.getString(7);
              
              String vendor_query = "select id from vendor where user_id ="+this.id;
              String organizer_query = "select id from organizer where user_id ="+this.id;
              String visitor_query = "select id from visitor where user_id ="+this.id; 
               Statement stmt1 = con.createStatement();
              ResultSet rs1= stmt1.executeQuery(vendor_query);
               Statement stmt2 = con.createStatement();
              ResultSet rs2= stmt2.executeQuery(organizer_query);
               Statement stmt3 = con.createStatement();
              ResultSet rs3= stmt3.executeQuery(visitor_query);
             
               if (rs1.next())
               {
                   this.type = 1;
               }
               else if (rs2.next())
               {
                   this.type = 2;
               }
               else if (rs3.next())
               {
                   this.type = 3;
               }
               else
               {
                   System.out.println("Invalid user name password and type"); 
               }
          }
          else
          {
              System.out.println("Invalid user name or password"); 
          }
          
      } catch (SQLException ex) {
          System.out.println(ex); 
      }
      return this.id;
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