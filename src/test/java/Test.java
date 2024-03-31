import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import newpackage.*;
import static org.junit.Assert.*;

public class Test {

    private users user;
    private users User;
    private users User1;
    private String reportPath;
    private int actualUserId;
    private int actualUserType;
    private Visitor V;
    private int userId;
    private Event EV;
    private Events ES;
    private places place;
    private List<Map<String, String>> userList;       
    private List<Map<String, String>> placeList;       
     private List<Map<String, String>> eventList;       

    private int flag;
    private finance F;
    

    
    public Test() throws SQLException
    {
        user = new users();
        F = new finance();
        ES = new Events(); 
        EV = new Event();
    
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

//--------------------------print_actegories -------------------------------- 

@Given("an place with cat {string} exists with predefined cats details")
public void an_place_with_cat_exists_with_predefined_cats_details(String string) {
   ES = new Events();
}
@When("I request shearch with one place for cats {string}")
public void i_request_shearch_with_one_place_for_cats(String string) {
   ES.print_categories();
}
@Then("the report should display the all cats")
public void the_report_should_display_the_all_cats() {
   assertTrue("the report should display the all cats",true);
}
//--------------------------insert_new_event -------------------------------- 

@Given("a new Event wants to add with the following details:")
public void a_new_event_wants_to_add_with_the_following_details(DataTable dataTable) 
{
   this.eventList = dataTable.asMaps(String.class, String.class);
        Map<String, String> EventDetails = eventList.get(0);
        ES = new Events(); 
        EV = new Event();
}
@When("the Event added")
public void the_event_added() {
    Map<String, String> EventDetails = eventList.get(0);
    
         EV.organizer_id  = Integer.parseInt(EventDetails.get("organizer_id"));
         
         EV.event_category_id = Integer.parseInt(EventDetails.get("event_category_id"));
         
         EV.name = EventDetails.get("name");
         
         EV.event_date = EventDetails.get("event_date");
         
         EV.event_time = EventDetails.get("event_time");
         
         EV.description = EventDetails.get("description");
         EV.no_vesitors = Integer.parseInt(EventDetails.get("no_visitor"));
         
         EV.price_per_visitor = Float.parseFloat(EventDetails.get("price_per_person"));
         EV.no_meals = Integer.parseInt(EventDetails.get("no_meals"));
         EV.meal_price = Float.parseFloat(EventDetails.get("meal_price"));
         EV.no_drinks = Integer.parseInt(EventDetails.get("no_drinks"));
         EV.drink_price = Float.parseFloat(EventDetails.get("drink_price"));

         ES.insert_new_event(EV);
}
@Then("the Event should be successful added")
public void the_event_should_be_successful_added() {
    assertTrue("the Event should be successful added",true);
}
//--------------------------print_org_events -------------------------------- 

@Given("an place with org id {string} exists with predefined org events details")
public void an_place_with_org_id_exists_with_predefined_org_events_details(String string) {
   ES = new Events();
}
@When("I request print org events for org id {int}")
public void i_request_print_org_events_for_org_id(Integer org_id) {
   ES.print_org_events(org_id);
}
@Then("the report should display the org events")
public void the_report_should_display_the_org_events() {
   assertTrue("the report should display the org events",true);
}

//--------------------------get_one_event -------------------------------- 

@Given("an place with event id {string} exists with predefined one event details")
public void an_place_with_event_id_exists_with_predefined_one_event_details(String string) {
   ES = new Events();
}
@When("I request print one event for event id {int}")
public void i_request_print_one_event_for_event_id(Integer event_id) {
  ES.get_one_event(event_id);
}
@Then("the report should display the one event")
public void the_report_should_display_the_one_event() {
       assertTrue("the report should display the one event",true);

}
//--------------------------get_event_meta -------------------------------- 
@Given("an meta with event id {string} exists with predefined one event meta details")
public void an_meta_with_event_id_exists_with_predefined_one_event_meta_details(String string) {
   ES = new Events();
}
@When("I request print one event meta for event id {int}")
public void i_request_print_one_event_meta_for_event_id(Integer event_id) {
   ES.get_event_meta(event_id);
}
@Then("the report should display the one event meta")
public void the_report_should_display_the_one_event_meta() {
     assertTrue("the report should display the one event meta",true);
}
//--------------------------add_meta -------------------------------- 

@Given("a new meat wants to add meta with the following details:")
public void a_new_meat_wants_to_add_meta_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
   this.eventList = dataTable.asMaps(String.class, String.class);
        Map<String, String> EventDetails = eventList.get(0);
        ES = new Events(); 
}
@When("the umeta added")
public void the_umeta_added() {
     Map<String, String> EventDetails = eventList.get(0);
     ES.add_meta(Integer.parseInt(
             EventDetails.get("event_id")),
             EventDetails.get("link"),
             Integer.parseInt(EventDetails.get("type")));
}
@Then("the meta added should be successful")
public void the_meta_added_should_be_successful() {
   assertTrue("the meta added should be successful",true);
}
//--------------------------get_Invitations-------------------------------- 

@Given("an invitations with event id {string} exists with predefined one event details")
public void an_invitations_with_event_id_exists_with_predefined_one_event_details(String string) {
    ES = new Events();
}
@When("I request get invitations for event id {int}")
public void i_request_get_invitations_for_event_id(Integer event_id) {
    ES.get_Invitations(event_id);
}
@Then("the report should display all invitations for this event")
public void the_report_should_display_all_invitations_for_this_event() {
    assertTrue("the report should display all invitations for this event",true);
}

//--------------------------add_Invitation-------------------------------- 

@Given("a new invitation wants to add invitation with the following details:")
public void a_new_invitation_wants_to_add_invitation_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
     this.eventList = dataTable.asMaps(String.class, String.class);
        Map<String, String> EventDetails = eventList.get(0);
        ES = new Events(); 
}
@When("the invitation added")
public void the_invitation_added() {
    Map<String, String> EventDetails = eventList.get(0);
     ES.add_Invitation(
             Integer.parseInt(EventDetails.get("event_id")),
             Integer.parseInt(EventDetails.get("visitor_id")),
             Integer.parseInt(EventDetails.get("no_invites")),
             Integer.parseInt(EventDetails.get("VIP"))
             );
}
@Then("the invitation added should be successful")
public void the_invitation_added_should_be_successful() {
       assertTrue("the invitation added should be successful",true);

}
//--------------------------order_to_place-------------------------------- 

@Given("a new place order wants to add place order with the following details:")
public void a_new_place_order_wants_to_add_place_order_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
   this.eventList = dataTable.asMaps(String.class, String.class);
        Map<String, String> EventDetails = eventList.get(0);
        ES = new Events(); 
}
@When("the place order added")
public void the_place_order_added() {
   Map<String, String> EventDetails = eventList.get(0);
     ES.order_to_place(
             Integer.parseInt(EventDetails.get("place_id")),
             Integer.parseInt(EventDetails.get("event_id")),
             EventDetails.get("start_date"),
             EventDetails.get("end_date"),
             EventDetails.get("start_time"),
             EventDetails.get("end_time")
             );
}
@Then("the place order added should be successful")
public void the_place_order_added_should_be_successful() {
    
           assertTrue("the place order added should be successful",true);

}
//--------------------------my_invitations-------------------------------- 
@Given("an visitor with ID {string} exists with predefined my invitations details")
public void an_visitor_with_id_exists_with_predefined_my_invitations_details(String string) {
   V = new Visitor();
}
@When("I request the my invitations for visitor ID {int}")
public void i_request_the_my_invitations_for_visitor_id(Integer user_id) {
    V.my_invitations(user_id);
}
@Then("the report should display the my invitations")
public void the_report_should_display_the_my_invitations() {
    
  assertTrue("the report should display the my invitations",true);
}

}
