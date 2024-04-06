Feature: User Login Logout

  
  Scenario: Organizer logs in successfully
    Given an organizer user exists with username "Rawand" and password "Rawand123"
    When the user logs in with username "Rawand" and password "Rawand123"
    Then the login should be successful with user id 51 and user type 2 and flag 1

  Scenario: Vendor logs in successfully
    Given an vendor user exists with username "Aya" and password "Aya12345"
    When the user logs in with username "Aya" and password "Aya12345"
    Then the login should be successful with user id 14 and user type 1 and flag 1

  Scenario: Visitor logs in successfully
    Given an visitor user exists with username "Oday" and password "Oday777"
    When the user logs in with username "Oday" and password "Oday777"
    Then the login should be successful with user id 16 and user type 3 and flag 1

  
  