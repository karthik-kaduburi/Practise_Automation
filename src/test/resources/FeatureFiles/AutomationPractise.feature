@Automation-Practise
Feature: Acceptance testing to register on the website, in order
to validate landing screen,form fields, personal information, cart, checkout page, payments page.
  

  @Register-a-user
  Scenario Outline: Register on website
    Given I am on the Home Page "<url>" of AutomationPractise Website
    When clicked on "Sign in" link
    Then user enters "<email>" on "<page>" page
    And clicked on "create an account" link
    When I enter the "personalInfo" on "<page>"
      | Title					|Mr						|
      | firstName			|Tom					|
      | lastName			|Jerry				|
      | password			|12345				|
      | dob						|6/7/1994			|
   Then I enter the "addressInfo" on "<page>"
      | fName					|Tom					|
      | lName					|Jerry				|
      | company				|disney				|
      | address1			|US						|   
      | address2			|NA						|
      | city					|NY						|
      | state					|Arizona			|
      | postalCode		|90001				|
      | mobileNo			|9034542243		|
    When clicked on "Register" link
    Then verify the "info" displayed on "<page>"
    	| firstName			|Tom					|
      | lastName			|Jerry				|
    And clicked on "Sign out" link
    Examples:
    |url																		|email								|page								|
    |http://automationpractice.com/index.php|karthik@gl.com				|AutomationPractise	|
  
    
    @Login-Add-to-cart
  Scenario Outline: Register on website
    Given I am on the Home Page "<url>" of AutomationPractise Website
    When clicked on "Sign in" link
    Then I enter the "credInfo" on "<page>"
      |userName				|karthik@gl.com					|
      |pass						|12345									|
    When clicked on "Log in" link  
    Then clicked on "T-Shirts" link
    And moved to "add to cart" element
    When clicked on "add to cart" link
    Then clicked on "proceed to checkout" link
    And continue till payments
    And verify the "info" displayed on "<page>"
    	| product			|T-shirts				|
    Examples:
    |url																		|page								|
    |http://automationpractice.com/index.php|AutomationPractise	|