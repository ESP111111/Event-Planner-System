Feature: Insert Event

  Scenario Outline: Successful insert for a new Event
    Given a new Event wants to add with the following details:
      | organizer_id    | event_category_id  | name  | event_date  | event_time  | description   | no_visitor  | price_per_person  | no_meals   | meal_price   | no_drinks  | drink_price  |
      | <organizer_id> | <event_category_id>| <name>| <event_date>| <event_time>| <description> | <no_visitor>| <price_per_person>| <no_meals> | <meal_price> | <no_drinks>| <drink_price>|
    When the Event added 
    Then the Event should be successful added

  Examples:
     | organizer_id    | event_category_id  | name  | event_date  | event_time  | description   | no_visitor  | price_per_person  | no_meals   | meal_price   | no_drinks  | drink_price  |
     | 42              | 1                  | Test  | 2024-04-15  | 10:30:00    | Hello         | 1300        | 2.5               | 1100       | 1.5          | 1700       | 1            |
