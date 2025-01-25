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

Feature: Product
Background: 	
Given User launch browser
When User open url saucedemo

@VerifyProductImages
Scenario Outline: Verify All product images
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Validate all products images
And Close the browser 
Examples:
|username       |password    |
|visual_user    |secret_sauce|
|problem_user   |secret_sauce|
 
@VerifyAddAndRemoveButtons
Scenario Outline: Verify All product images
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Verify Add and Remove buttons
And Close the browser 
Examples:
|username       |password    |
|error_user     |secret_sauce|
|problem_user   |secret_sauce|

@VerifyAllItemsOnCartBadge
Scenario Outline: Verify All Items on Cart badge
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Verify Cart badge
And Close the browser 
Examples:
|username                  |password    |
|performance_glitch_user   |secret_sauce|
|standard_user           	 |secret_sauce|
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|
|visual_user  					   |secret_sauce|

@VerifyCartCoordinates
Scenario Outline: Verify Cart coordinates
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Verify Cart coordinates
And Close the browser 
Examples:
|username       |password    |
|visual_user    |secret_sauce|
 
@VerifySortPriceLowToHigh
Scenario Outline: Verify Sort Price Low To High
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Verify Sort Price Low To High
And Close the browser 
Examples:
|username       |password    |
|problem_user   |secret_sauce|
|error_user     |secret_sauce|
|visual_user    |secret_sauce|

@VerifySortPriceHighToLow
Scenario Outline: Verify Sort Price High to Low
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Verify Sort Price High to Low
And Close the browser 
Examples:
|username       |password    |
|problem_user   |secret_sauce|
|error_user     |secret_sauce|
|visual_user    |secret_sauce|

@VerifySortAToZ
Scenario Outline: Verify Sort A to Z
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Verify Sort A to Z
And Close the browser 
Examples:
|username                  |password    |
|standard_user           	 |secret_sauce|
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|
|visual_user  					   |secret_sauce|
|performance_glitch_user   |secret_sauce|

@VerifySortZtoA
Scenario Outline: Verify Sort Z to A
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Verify Sort Z to A
And Close the browser 
Examples:
|username       |password    |
|problem_user   |secret_sauce|
|error_user     |secret_sauce|

@VerifyGlitchZtoASort
Scenario Outline: Verify Glitch Z to A Sort
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Verify Glitch Z to A Sort
And Close the browser 
Examples:
|username                  |password    |
|performance_glitch_user   |secret_sauce|
|error_user   					   |secret_sauce|

@VerifyGlitchHighToLowSort
Scenario Outline: Verify Glitch High to Low Sort
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Verify Glitch High to Low Sort
And Close the browser 
Examples:
|username                  |password    |
|performance_glitch_user   |secret_sauce|
|error_user   					   |secret_sauce|


@VerifyGlitchLowToHighSort
Scenario Outline: Verify Glitch Low to High Sort
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Verify Glitch Low to High Sort
And Close the browser 
Examples:
|username                  |password    |
|performance_glitch_user   |secret_sauce|
|error_user   					   |secret_sauce|

@VerifyLogout
Scenario Outline: Verify Logout
When User enter username as "<username>" and password as "<password>"
And Click Login
Then Verify Logout
And Close the browser 
Examples:
|username                  |password    |
|standard_user           	 |secret_sauce|
|problem_user  						 |secret_sauce|
|error_user   					   |secret_sauce|
|visual_user  					   |secret_sauce|
|performance_glitch_user   |secret_sauce|