Feature: get invitations

Scenario: Successfully get invitations
    Given an invitations with event id "11" exists with predefined one event details
    When I request get invitations for event id 11
    Then the report should display all invitations for this event
    