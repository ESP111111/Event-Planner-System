Feature: Generate Event Financial Report

Scenario: Successfully generating a financial report for an event
    Given an event with ID "11" exists with predefined financial details
    When I request the financial report for event ID 11
    Then the report should display the total earnings from visitors, meals, and drinks
    
