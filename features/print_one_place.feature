Feature: print one place

Scenario: Successfully print one place for place id
    Given an place with ID "3" exists with predefined one place details
    When I request the one place for place ID 3
    Then the report should display the one place details
    