Feature: Automated End2End Tests
Description: The purpose of this feature is to test End 2 End integration.

Scenario: Submitting the E-commerce Form
	Given User is on E-commerce demo page
	When User enters all the correct values in al the fields and clicks on submit button
	Then Form should be submitted successfully
	And quit the browser