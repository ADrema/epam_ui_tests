Feature: JDI Home Page

  Scenario: JDI Different Elements Page Testing

    Given I'm on the Home Page
    Then The browser title is HomePage
    When I am logged in as PITER_CHAILOVSKII
    Then The user name PITER_CHAILOVSKII is displayed on the left-side of the screen
    And Home Page contains Benefits
    And Home Page contains texts above the benefits
    And Home Page navigation bar contains respective options
    And Home Page side bar also contains the respective options

    When I'm on Different elements page
    Then Different elements page contains checkboxed
    And Different elements page contains radiobuttons
    And Different elements page contains dropdown menu
    And Different elements page contains buttons
    And Different elements page contains right section
    And Different elements page contains left section

    When WATER checkbox is clicked
    And WIND checkbox is clicked
    Then  2 logrow contains WATER and true condition
    And 1 logrow contains WIND and true condition

    When SELEN radioButton is selected
    Then 1 logrow contains SELEN value

    When YELLOW color is selected in dropdown menu
    Then 1 logrow contains value YELLOW

    When WATER checkbox is clicked
    And WIND checkbox is clicked
    Then 2 logrow contains WATER and false condition
    And 1 logrow contains WIND and false condition

    Then Logout