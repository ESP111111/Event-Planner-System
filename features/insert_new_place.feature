Feature: Insert place

  Scenario Outline: Successful insert for a new place
    Given a new place wants to add with the following details:
      | vendor_id    | name  | location  | capacity  | price_per_hour  | rate  |
      | <vendor_id> | <name> | <location>| <capacity>| <price_per_hour>| <rate>| 
    When the place added 
    Then the place should be successful added

  Examples:
     | vendor_id    | name  | location  | capacity  | price_per_hour  | rate  |
     | 7            | NewPP |  Nablus   | 800       | 900             | 3     | 
