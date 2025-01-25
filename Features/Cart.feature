#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Login
Background: 	
Given User launch browser
When User open url saucedemo

@VerifyAllItemsIfDisplayedOnCart
Scenario Outline: Verify Login with Valid Credentials
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
And Add Items to Cart
And Verify All Items if displayed on Cart
And Close the browser 
Examples:
|username                  |password    |
|standard_user           	 |secret_sauce|
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|
|visual_user  					   |secret_sauce|
|performance_glitch_user   |secret_sauce|

@VerifyRemoveButton
Scenario Outline: Verify Login with Valid Credentials
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
And Add Items to Cart
And Verify cart page remove button
And Close the browser 
Examples:
|username                  |password    |
|standard_user           	 |secret_sauce|
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|

@VerifyCheckoutBtnCoordinates
Scenario Outline: Verify Login with Valid Credentials
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
And Add Items to Cart
And Verify CheckoutBtn coordinates
And Close the browser 
Examples:
|username                  |password    |
|visual_user  					   |secret_sauce|

@VerifyIfAllItemsCanCheckout
Scenario Outline: Verify Login with Valid Credentials
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
And Add Items to Cart
And Verify If All Items Can Checkout
And Close the browser 
Examples:
|username                  |password    |
|standard_user           	 |secret_sauce|
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|
