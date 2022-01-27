Feature: Train Search Functions
  Background:
    Given the user navigates to home page
    When the user enters the following destination and arrival stations
      | From | KATOWICE |
      | To   | POZNAN-  |

  @TC-1 @TC-2
  Scenario Outline:The user can make search with valid locations
    And the user selects any date in the future
    And the user selects "<time>" option
    And the user clicks on "Search Connection" button
    Then the related results appear
    Examples:
      | time      |
      | Departure |
      | Arrival   |

  @TC-4
  Scenario: The user can add an intermediate station
    And the user clicks on "Add Intermediate Station" icon
    And the user enters "SOPOT-" to VIA station
    And the user selects any date in the future
    And the user clicks on "Search Connection" button
    Then the related results appear

  @TC-7
  Scenario: The user can select connections options
    And the user selects any date in the future
    And the user selects "DISABLED TRAVELLERS" connection option
    And the user clicks on "Search Connection" button
    Then the related results appear

  @TC-8
  Scenario: The user can select connections options
    And the user selects any date in the future
    And the user selects "Provider" dropdown
    And the user select just "PKP INTERCITY" provider
    And the user clicks on "Search Connection" button
    Then the related results appear