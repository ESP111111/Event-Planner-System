Feature: print my invitations

Scenario: Successfully print my invitations for an visitor
    Given an visitor with ID "1" exists with predefined my invitations details
    When I request the my invitations for visitor ID 1
    Then the report should display the my invitations
    
