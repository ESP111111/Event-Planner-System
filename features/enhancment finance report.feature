Feature: Generate Event enhancment Financial Report

Scenario: Successfully generating a enhancment financial report for an event
    Given an event with ID "11" exists with predefined enhancment details
    When I request the enhancment report for event ID 11
    Then the report should display the enhancment report
    
