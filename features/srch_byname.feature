Feature: place search with name

Scenario: Successfully place search with name for place name
    Given an place with name "Aya" exists with predefined place details
    When I request shearch with one place for place name "Aya"
    Then the report should display the one place details
    