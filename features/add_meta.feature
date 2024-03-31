Feature: add meta

  Scenario Outline: Successful add meta for event
    Given a new meat wants to add meta with the following details:
      | event_id   | link  | type  |
      | <event_id> | <link>| <type>| 
    When the umeta added
    Then the meta added should be successful

  Examples:
          | event_id | link     | type |
          | 11       | ABC.png  | 1    |
