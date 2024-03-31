Feature: place search with period

Scenario: Successfully place search with period for place period
    Given an place with start_date "2024-04-20" and start_time  "08:00:00" and end_time "20:00:00"  exists with predefined place details
    When I request shearch with one place for place period start_date "2024-04-20" and start_time  "08:00:00" and end_time "20:00:00"
    Then the report should display the one place details
    