Feature: Update User Information

  Scenario: Successfully update all user information fields
    Given a user exists with id 1
    When I update all the user's information fields
    | Username | First   | Last    | Email           | Password   | Image          |
    | Ahmad_11 | Ahmad   | Mohammad| Ahm1@example.com| Ahma12345  | Asdsaddsac.jpg | 

    Then the update should be successful with flag 1
