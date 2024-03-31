Feature: print one events

Scenario: Successfully print one event
    Given an place with event id "11" exists with predefined one event details
    When I request print one event for event id 11
    Then the report should display the one event
    