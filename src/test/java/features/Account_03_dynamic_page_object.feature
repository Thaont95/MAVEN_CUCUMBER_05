@account
Feature: Customer
  As merchant
  I want to loginto application

  @register
  Scenario: Register to application
    Given I get login page URL
    And I click to here link
    And I input to Email textbox with data "autorandom"
    And I click to submit button at Register page
    Then I get UserID info
    And I get Password info
    When open login page again

  @login
  Scenario: Login to system
    Given I input username textbox
    And I input password textbox
    And Click submit button at Login page
    Then Verify Home page is displayed with message "Welcome To Manager's Page of Guru99 Bank""

  @new_customer
  Scenario Outline: Create new customer
    Given I open "New Customer" page
    And I input to "name" textbox with data "<Name>"
    And I select "m" radio button
    And I input to "dob" textbox with data "<DateOfBirth>"
    And I input to "addr" textarea with data "<Address>"
    And I input to "city" textbox with data "<City>"
    And I input to "state" textbox with data "<State>"
    And I input to "pinno" textbox with data "<Pin>"
    And I input to "telephoneno" textbox with data "<Phone>"
    And I input to "emailid" textbox with "2" data "<Email>"
    And I input to "password" textbox with data "<Password>"
    And I click to "Submit" button
    And Verify message "Customer Registered Successfully!!!" displayed success
    And I sleep "30" times

    Examples: new customer info
      | Name       | Gender | DateOfBirth | Address | City     | State   | Pin    | Phone     | Email    | Password |message|
      | Automation | m      | 1995-01-01    | Address | Bac Ninh | Thu Duc | 123456 | 123456790 | autotest |   123456 |Customer Registered Successfully!!!|
