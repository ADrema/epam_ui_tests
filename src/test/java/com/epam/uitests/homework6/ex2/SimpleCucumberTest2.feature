Feature: JDI Simple Test

  Scenario: User Table Page test

    Given I'm on the Home Page
    And I am logged in as PITER_CHAILOVSKII
    And I open User Table Page through the header menu Service -> USER_TABLE
    And I am on Users Table Page
    And User Table Page is Active
    And User Table Page's interface contains correct elements

    When I check Number and User columns of Users table
    Then User table contains correct values for numbers and users
      | Number | User |
      | 1 | Roman |  
      | 2 | Sergey Ivan |
      | 3 | Vladzimir |
      | 4 | Helen Bennett |
      | 5 | Yoshi Tannamuri |
      | 6 | Giovanni Rovelli |

    When I check Desciption column of Users table
    Then All cells of 'Description' column contains text
      | Number | Desciption |
      | 1 | Lorem ipsum |
      | 2 | Lorem ipsum |
      | 3 | Lorem ipsum |
      | 4 | Lorem ipsum\nsome description|
      | 5 | Lorem ipsum\nsome description|
      | 6 | Lorem ipsum\nsome description|

    When I set 'Vip' status to Sergey Ivan
    Then 'Log' section shows a log row in format: Vip: condition changed to true

    When I click on dropdown in column Type for user Roman
    Then droplist for Roman contains values
      | Dropdown Values |
      | Admin |
      | User |
      | Manager |