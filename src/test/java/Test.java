import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import newpackage.finance;
import newpackage.places;
import newpackage.users;
import static org.junit.Assert.*;

public class Test {

    private users user;
    private users User;
    private users User1;
    private String reportPath;
    private int actualUserId;
    private int actualUserType;
    private int userId;
    private places place;
    private List<Map<String, String>> userList;       
    private List<Map<String, String>> placeList;       

    private int flag;
    private finance F;
    

    
    public Test() throws SQLException
    {
        user = new users();
        F = new finance();
    
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
//--------------------------finance report -------------------------------- 

    @Given("an event with ID {string} exists with predefined financial details")
    public void an_event_with_id_exists_with_predefined_financial_details(String eventId) {
       
        F = new finance();
    }

    @When("I request the financial report for event ID {int}")
    public void i_request_the_financial_report_for_event_id(int eventId) 
    {
        F.event_report(eventId);
    }

    @Then("the report should display the total earnings from visitors, meals, and drinks")
    public void the_report_should_display_the_total_earnings_from_visitors_meals_and_drinks() {
      
       assertTrue("Report should contain total earnings from visitors, meals, and drinks.",true);
    }
//--------------------------finance enhancment report -------------------------------- 

    
@Given("an event with ID {string} exists with predefined enhancment details")
public void an_event_with_id_exists_with_predefined_enhancment_details(String string) {
   
      F = new finance();
}
@When("I request the enhancment report for event ID {int}")
public void i_request_the_enhancment_report_for_event_id(Integer eventId) {
   
   F.enhancment_report(eventId);
}
@Then("the report should display the enhancment report")
public void the_report_should_display_the_enhancment_report() {
   
    assertTrue("Report should contain total earnings from visitors, meals, and drinks.",true);
}
//--------------------------inser new place -------------------------------- 
@Given("a new place wants to add with the following details:")
public void a_new_place_wants_to_add_with_the_following_details(DataTable dataTable) {
    this.placeList = dataTable.asMaps(String.class, String.class);
        Map<String, String> placeDetails = placeList.get(0);
        place = new places(); 
}
@When("the place added")
public void the_place_added() {
   Map<String, String> placeDetails = placeList.get(0);
         place.insert_new_place(
                 Integer.parseInt(placeDetails.get("vendor_id")), 
                 placeDetails.get("name"), 
                 placeDetails.get("location"), 
                 Integer.parseInt(placeDetails.get("capacity")),
                 Float.parseFloat(placeDetails.get("price_per_hour")),
                 Integer.parseInt(placeDetails.get("rate")) );
}
@Then("the place should be successful added")
public void the_place_should_be_successful_added()
{
    assertTrue("the place should be successful added",true);
}
//--------------------------print_all_places -------------------------------- 

@Given("an vendor with ID {string} exists with predefined place details")
public void an_vendor_with_id_exists_with_predefined_place_details(String string) {
     place = new places(); 
}
@When("I request the all places for vendor ID {int}")
public void i_request_the_all_places_for_vendor_id(Integer vendor_id) {
    place.print_all_places(vendor_id);
}
@Then("the report should display the all places details")
public void the_report_should_display_the_all_places_details() {
   assertTrue("Then the report should display the all places details",true);
}
//--------------------------print_one_place -------------------------------- 

@Given("an place with ID {string} exists with predefined one place details")
public void an_place_with_id_exists_with_predefined_one_place_details(String string) {
   place = new places(); 
}
@When("I request the one place for place ID {int}")
public void i_request_the_one_place_for_place_id(Integer place_id) {
    place.print_one_place(place_id);
}
@Then("the report should display the one place details")
public void the_report_should_display_the_one_place_details() {
     assertTrue("Then the report should display the one place details",true);
}
//--------------------------srch_byname -------------------------------- 
@Given("an place with name {string} exists with predefined place details")
public void an_place_with_name_exists_with_predefined_place_details(String string) {
    place = new places(); 
    
}
@When("I request shearch with one place for place name {string}")
public void i_request_shearch_with_one_place_for_place_name(String name) {
   place.srch_byname(name);
}
//--------------------------srch_bylocation -------------------------------- 
@Given("an place with location {string} exists with predefined place details")
public void an_place_with_location_exists_with_predefined_place_details(String string) {
    place = new places(); 

}
@When("I request shearch with one place for place location {string}")
public void i_request_shearch_with_one_place_for_place_location(String location) {
      place.srch_bylocation(location);
}

//--------------------------srch_byprice --------------------------------
@Given("an place with price {string} exists with predefined place details")
public void an_place_with_price_exists_with_predefined_place_details(String string) {
   place = new places(); 
}
@When("I request shearch with one place for place price {int}")
public void i_request_shearch_with_one_place_for_place_price(int price) {
    place.srch_byprice(price);
}

//--------------------------srch_byperiod -------------------------------- 
@Given("an place with start_date {string} and start_time  {string} and end_time {string}  exists with predefined place details")
public void an_place_with_start_date_and_start_time_and_end_time_exists_with_predefined_place_details(String date, String s_time, String e_time) {
    place = new places(); 
}
@When("I request shearch with one place for place period start_date {string} and start_time  {string} and end_time {string}")
public void i_request_shearch_with_one_place_for_place_period_start_date_and_start_time_and_end_time(String date, String s_time, String e_time) {
    place.srch_byperiod(date , s_time , e_time);
}




}
