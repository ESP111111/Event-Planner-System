Feature: User Signup

  Scenario Outline: Successful signup for a new user
    Given a new user wants to sign up with the following details:
      | Username   | FirstName | LastName | Email          | Password  | Image   | Type |
      | <Username> | <First>   | <Last>   | <Email>        | <Password>| <Image> | <Type> |
    When the user signs up
    Then the signup should be successful and a new user id should be returned

  Examples:
    | Username | First   | Last    | Email           | Password   | Image      | Type |
    | jdoe     | John    | Doe     | jdoe@example.com| p@ssw0rd1  | avatar.jpg | 1    |
    | asmith   | Alice   | Smith   | asmith@example.com| p@ssword2 | avatar2.jpg| 2    |
    | bwayne   | Bruce   | Wayne   | bwayne@example.com| password3 | avatar3.jpg| 3    |
