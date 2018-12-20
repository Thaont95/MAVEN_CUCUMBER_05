
Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: Common steps
  #--------------Action-----------------
  And I input to "name" textbox with data "autotest"
  And I input to "city" textbox with data "Ha Noi"
  And I input to "state" textbox with data "HaNoi"
  And I input to "emailid" textbox with random data "autoemail"
  #0 = fix data | 1 = random data
  And I input to "city" textbox with "0" data "Hanoi"
  And I input to "city" textbox with "1" data "Hanoi"
  And I input to "email" textbox with "2" data "Autotest"
  
  And I input to "addr" textarea with data "15 Pham Hung"
  
  And I select item in "selaccount" dropdown with data "Current"
  And I select item in "selaccount" dropdown with data "Saving"
  
  And I select "m" radio button
  And I select "f" radio button
  
  And I open "New Customer" page
  And I open "Edit Customer" page
  
  #regex
  And I input first Account ID
  And I input second Account ID
  And I transfer to "<Amount>" USD
  And I withdraw to "<Amount>" USD

 And I click to "" button
   #--------------Verify-----------------
   
   And Verify message "Customer Registered Successfully!!!" displayed success
   And Verify message "Customer details updated Successfully!!!" displayed success
   And Verify message "Account Generated Successfully!!!" displayed success
    #--------------Wait-----------------
 And I sleep "30" times