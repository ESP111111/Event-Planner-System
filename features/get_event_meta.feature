Feature: print one event meta

Scenario: Successfully print one event
    Given an meta with event id "11" exists with predefined one event meta details
    When I request print one event meta for event id 11
    Then the report should display the one event meta
    