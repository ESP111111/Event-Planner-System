Feature: add place order

  Scenario Outline: Successful add place order for event
    Given a new place order wants to add place order with the following details:
      | place_id   | event_id  | start_date  | end_date  |start_time  | end_time  |
      | <place_id> | <event_id>| <start_date>| <end_date>|<start_time>| <end_time>|
    When the place order added
    Then the place order added should be successful

  Examples:
        |place_id   | event_id   | start_date    | end_date      | start_time  | end_time   |
        |3          | 16         | "2024-05-01"  | "2024-05-03"  | "07:00:00"  | "22:00:00" |


