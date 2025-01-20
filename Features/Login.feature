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

Scenario Outline: Verify Login with Valid Credentials
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
And Close the browser 
Examples:
<<<<<<< HEAD
| username | password |
| standard_user | secret_sauce |
<<<<<<< HEAD
=======
| problem_user | secret_sauce |
=======
|username       |password    |
|standard_user  |secret_sauce|
|problem_user   |secret_sauce|
|error_user     |secret_sauce|
|locked_out_user|secret_sauce|

@ResponseTime
Scenario Outline: Verify Login Response Time
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Login response time should be < 2 seconds
And Close the browser
Examples:
|username       |password    |
|performance_glitch_user  |secret_sauce|
 
@LockedOutErrorMessage
Scenario Outline: Verify Locked out user error message
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Verify locked out error message
And Close the browser
Examples:
|username         |password    |
|locked_out_user  |secret_sauce|

@InvalidUserErrorMessage
Scenario Outline: Verify Locked out user error message
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Verify invalid user message
And Close the browser
Examples:
|username |password|
|jon      |jon12345|
>>>>>>> de715f0 (Added Login Scenarios)
>>>>>>> 2f49203 (Added Login Scenarios)








