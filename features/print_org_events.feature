Feature: print org events

Scenario: Successfully print org events
    Given an place with org id "42" exists with predefined org events details
    When I request print org events for org id 42
    Then the report should display the org events
    