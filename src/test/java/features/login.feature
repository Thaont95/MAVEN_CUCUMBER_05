#@account
Feature: Customer
  As merchant
  I want to loginto application

 #@register
  Scenario: Register to application
    Given I get login page URL
    And I click to here link
    And I input to Email textbox with data "autorandom"
    And I click to submit button at Register page
    Then I get UserID info
    And I get Password info
    When open login page again

  #@login
  Scenario: Login to system
    Given I input username textbox
    And I input password textbox
    And Click submit button at Login page
    Then Verify Home page is displayed with message "Welcome To Manager's Page of Guru99 Bank""

 # @new_customer
  Scenario Outline: Create new customer
    Given I open new customer page
    And Input to new customer form with data
      | Name   | Gender | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <Name> | m      | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And Click submit button at New customer page
    Then Verify message display with data "<message>"
    And I veify all above informationcreate success
      | Name   | Gender | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   |            |
      | <Name> | male   | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    When I get Customer ID at New customer page
    And I sleep some time

    Examples: new customer info
      | Name       | Gender | DateOfBirth | Address | City     | State   | Pin    | Phone     | Email    | Password |message|
      | Automation | m      | 1995/1/1    | Address | Bac Ninh | Thu Duc | 123456 | 123456790 | autotest |   123456 |Customer Registered Successfully!!!|
