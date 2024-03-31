Feature: place search with location

Scenario: Successfully place search with location for place location
    Given an place with location "Nablus" exists with predefined place details
    When I request shearch with one place for place location "Nablus"
    Then the report should display the one place details
    