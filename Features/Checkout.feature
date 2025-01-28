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
Feature: Checkout
Background: 	
Given User launch browser
When User open url saucedemo

@VerifyIfCheckoutOnAllItemsIsComplete
Scenario Outline: Verify If Checkout On All Items Is Complete
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
When Add Items to Cart
And To checkout
And To Fill out information
Then Verify if checkout on all items is completed
And Close the browser 
Examples:
|username                  |password    |
|standard_user           	 |secret_sauce|
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|
|visual_user  					   |secret_sauce|
|performance_glitch_user   |secret_sauce|

@VerifyCancelButton
Scenario Outline: Verify Cancel Button
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
When Add Backpack to Cart
And To checkout
Then Verify cancel button
And Close the browser 
Examples:
|username                  |password    |
|standard_user           	 |secret_sauce|
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|
|visual_user  					   |secret_sauce|
|performance_glitch_user   |secret_sauce|

@VerifyResponseTimeOfCancelButton
Scenario Outline: Verify Response Time Of Cancel Button
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
When Add Backpack to Cart
And To checkout
And To Fill out information
Then Verify Response time of Cancel button
And Close the browser 
Examples:
|username                  |password    |
|performance_glitch_user   |secret_sauce|

@VerifyFinishButtonAndResponseTimeOfBackhomeButton
Scenario Outline: Verify Finish Button And Response Time Of Backhome Button
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
When Add Backpack to Cart
And To checkout
And To Fill out information
Then Verify finish button and Response time of Backhome button
And Close the browser 
Examples:
|username                  |password    |
|standard_user           	 |secret_sauce|
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|
|visual_user  					   |secret_sauce|
|performance_glitch_user   |secret_sauce|

@VerifyIfTxtboxIsWorking
Scenario Outline: Verify If Txtbox Is Working
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
When Add Backpack to Cart
And To checkout
Then Verify if Txtbox is working
And Close the browser 
Examples:
|username                  |password    |
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|
 
@VerifyErrorMessageWhenFirstNameIsMissing
Scenario Outline: Verify error message when First Name is missing
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
When Add Backpack to Cart
And To checkout
Then Verify error message when First Name is missing
And Close the browser 
Examples:
|username                  |password    |
|problem_user  						 |secret_sauce|
 
@VerifyErrorMessageWhenLastNameIsMissing
Scenario Outline: Verify error message when Last Name is missing
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
When Add Backpack to Cart
And To checkout
Then Verify error message when Last Name is missing
And Close the browser 
Examples:
|username                  |password    |
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|

