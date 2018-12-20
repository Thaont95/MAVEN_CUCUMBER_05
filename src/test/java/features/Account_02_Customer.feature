#@demo
Feature: Account
  As merchant
  I want to loginto application

 # @new_customer
  Scenario Outline: Create new customer
    Given I open new customer page
    And Input to new customer form with data
      | Name   | Gender | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <Name> | m      | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And Click submit button at New customer page
    Then Verify message display with data "Customer Registered Successfully!!!"
    And I veify all above informationcreate success
      | Name       | Gender | DateOfBirth | Address | City     | State   | Pin    | Phone     | Email    |
      | <Name> | male      | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    When I get Customer ID at New customer page
    And I close browser

    Examples: new customer info
      | Name       | Gender | DateOfBirth | Address | City     | State   | Pin    | Phone     | Email    | Password |
      | Automation | m      | 1995/1/1    | Address | Bac Ninh | Thu Duc | 123456 | 123456790 | autotest |   123456 |

 # @edit_customer
  Scenario Outline: Edit new customer
    Given Open application
    When I input username textbox
    And I input password textbox
    And Click submit button at Login page
    Then Verify Home page is displayed with message "Welcome To Manager's Page of Guru99 Bank "
    When I open edit customer page
    And Input customer ID to textbox
    And I click Submit button at Edit customer page
    And I input to new customer form with data
      | Address   | City   | State   | Pin   | Phone   | Email   |
      | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> |
    And I click Submit button at Edit customer page
    Then Verify message display with data "Customer details updated Successfully!!!"
    And I veify all above informationcreate success
      | Address   | City   | State   | Pin   | Phone   | Email   |
      | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> |
    And I close browser

    Examples: User and password table
      | Address | City          | State   | Pin    | Phone     | Email    |
      | Address | Bac Ninh edit | Thu Duc | 123456 | 123456790 | autotest |
#Examples: User and password table
    # | username  | password |
   # | mngr163633 | hEjApuz |
   # | testuser_2 | Test@153 |
