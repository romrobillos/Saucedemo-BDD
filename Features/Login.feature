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

Scenario Outline: Succesful Login with Valid Credentials

Given User launch browser
When User open url saucedemo
And User enter username as "<username>" and password as "<password>"
And Click Login
Then Page Title should be on Product Page
And Close the browser 
Examples:
| username | password |
| standard_user | secret_sauce |








