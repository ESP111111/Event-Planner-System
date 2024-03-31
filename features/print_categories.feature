Feature: print all cats

Scenario: Successfully print all cats
    Given an place with cat "0" exists with predefined cats details
    When I request shearch with one place for cats "0"
    Then the report should display the all cats
    