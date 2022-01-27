Feature: Train Search Functions
 @US-1
  Scenario Outline:The user can make search with valid locations
    Given the user navigates to home page
    When the user enters the following destination and arrival stations
      | From | KATOWICE |
      | To   | POZNAŃ-  |
    And the user selects any date in the future
    And the user selects "<time>" option
    And the user clicks on "Search Connection" button
    Then the related results appear
    Examples:
      | time      |
      | Departure |
      | Arrival   |

@US-3 @firefox
  Scenario: The user can add an intermediate station
    Given the user navigates to home page
    When the user enters the following destination and arrival stations
       | From | KATOWICE |
       | To   | POZNAŃ-  |
    And the user clicks on "Add Intermediate Station" icon
    And the user enters "SOPOT-" to VIA station
    And the user selects any date in the future
    And the user clicks on "Search Connection" button
    Then the related results appear

  @US-5 @wip
  Scenario: The user can select connections options
    Given the user navigates to home page
    When the user enters the following destination and arrival stations
      | From | KATOWICE |
      | To   | POZNAŃ-  |
    And the user selects any date in the future
    And the user selects "DISABLED TRAVELLERS" connection option
    And the user clicks on "Search Connection" button
    Then the related results include option