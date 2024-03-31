Feature: add invitation

  Scenario Outline: Successful add invitation for event
    Given a new invitation wants to add invitation with the following details:
      | event_id   | visitor_id  | no_invites  | VIP  |
      | <event_id> | <visitor_id>| <no_invites>| <VIP>|
    When the invitation added
    Then the invitation added should be successful

  Examples:
         | event_id   | visitor_id  | no_invites  | VIP  |
         | 11         |     1       | 4           | 1    |
