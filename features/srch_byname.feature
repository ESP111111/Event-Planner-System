Feature: place search with name

Scenario: Successfully place search with name for place name
    Given an place with name "7alt_Nablus" exists with predefined place details
    When I request shearch with one place for place name "7alt_Nablus"
    Then the report should display the one place details
    