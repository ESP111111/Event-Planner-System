import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import newpackage.DatabaseConnection;
import newpackage.users;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Test {

    private users user;
    private users User;
    private users User1;


    private int actualUserId;
    private int actualUserType;
    private int userId;
    private List<Map<String, String>> userList;       
    private int flag;
    
    

    
    public Test() throws SQLException
    {
        user = new users();
    
    }
   
    @Given("an organizer user exists with username {string} and password {string}")
    public void an_organizer_user_exists_with_username_and_password(String username, String password) throws SQLException {
        user = new users();
    }

    
    @Given("an vendor user exists with username {string} and password {string}")
    public void an_vendor_user_exists_with_username_and_password(String username, String password)
    {
        user = new users();
    }
    
    @Given("an visitor user exists with username {string} and password {string}")
    public void an_visitor_user_exists_with_username_and_password(String username, String password)
    {
        user = new users();
    }
          
   
    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {
        actualUserId = user.login(username, password);
        actualUserType = user.get_type(); 
        flag = user.logout(user.get_id());
    }
    
    
    @Then("the login should be successful with user id {int} and user type {int} and flag {int}")
    public void the_login_should_be_successful_with_user_id_and_user_type(Integer expectedUserId, Integer expectedUserType , Integer expectedUserFlag) {
        assertEquals(expectedUserId.intValue(), actualUserId);
        assertEquals(expectedUserType.intValue(), actualUserType);
        assertEquals(expectedUserFlag.intValue(), flag);
    }
    
   
    
    
  //--------------------------Signup -------------------------------- 
    
    
 @Given("a new user wants to sign up with the following details:")
    public void a_new_user_wants_to_sign_up_with_the_following_details(DataTable dataTable) {
        this.userList = dataTable.asMaps(String.class, String.class);
        Map<String, String> userDetails = userList.get(0);
        User = new users(); 
        
    }

    @When("the user signs up")
    public void the_user_signs_up() {
         
       Map<String, String> userDetails = userList.get(0);
        userId = User.sign_up(
                userDetails.get("Username"),
                userDetails.get("FirstName"),
                userDetails.get("LastName"),
                userDetails.get("Email"),
                userDetails.get("Password"),
                userDetails.get("Image"),
                Integer.parseInt(userDetails.get("Type"))
        );
        
    }

    @Then("the signup should be successful and a new user id should be returned")
    public void the_signup_should_be_successful_and_a_new_user_id_should_be_returned() {
        assertTrue("The returned user id should be positive indicating a successful signup", userId > 0);
    }
    
//--------------------------Update user profile -------------------------------- 

@Given("a user exists with id {int}")
public void a_user_exists_with_id(int id) 
{
     
        User = new users(); 
        User.id = id;
}
@When("I update all the user's information fields")
public void i_update_all_the_user_s_information_fields(DataTable dataTable) {
     this.userList = dataTable.asMaps(String.class, String.class);
        Map<String, String> userDetails = userList.get(0);
    flag = User.set_user_name(User, userDetails.get("Username"));
    User.set_first_name(User, userDetails.get("First"));
    User.set_last_name(User, userDetails.get("Last"));
    User.set_email(User, userDetails.get("Email"));
    User.set_password(User, userDetails.get("Password"));
    User.set_image(User, userDetails.get("Image"));
    
}
@Then("the update should be successful with flag {int}")
public void the_update_should_be_successful_with_flag(Integer expectedFlag) 
{
            assertEquals(expectedFlag.intValue(), flag);
}

}



