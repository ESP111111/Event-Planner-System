Feature: print all places

Scenario: Successfully print all places for an vendor
    Given an vendor with ID "7" exists with predefined place details
    When I request the all places for vendor ID 7
    Then the report should display the all places details
    
