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
Feature: Cart
Background: 	
Given User launch browser
When User open url saucedemo

@VerifyAllItemsIfDisplayedOnCart
Scenario Outline: Verify All Items if displayed on Cart
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
When Add Items to Cart
Then Verify All Items if displayed on Cart
And Close the browser 
Examples:
|username                  |password    |
|standard_user           	 |secret_sauce|
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|
|visual_user  					   |secret_sauce|
|performance_glitch_user   |secret_sauce|

@VerifyRemoveButton
Scenario Outline: Verify cart page remove button
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
When Add Items to Cart
Then Verify cart page remove button
And Close the browser 
Examples:
|username                  |password    |
|standard_user           	 |secret_sauce|
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|

@VerifyCheckoutBtnCoordinates
Scenario Outline: Verify CheckoutBtn coordinates
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
When Add Items to Cart
Then Verify CheckoutBtn coordinates
And Close the browser 
Examples:
|username                  |password    |
|visual_user  					   |secret_sauce|

@VerifyIfAllItemsCanCheckout
Scenario Outline: Verify If All Items Can Checkout
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
When Add Items to Cart
Then Verify If All Items Can Checkout
And Close the browser 
Examples:
|username                  |password    |
|standard_user           	 |secret_sauce|
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|
