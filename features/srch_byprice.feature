Feature: place search with price

Scenario: Successfully place search with price for place price
    Given an place with price "1500" exists with predefined place details
    When I request shearch with one place for place price 1500
    Then the report should display the one place details
    