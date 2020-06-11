Feature: Green Kart Shopping Site
Description: The purpose of this feature is to test Green Kart Shopping Site

Scenario Outline: Place order
	Given user is on Home Page
	When user search for "<product>"
	When user selects quantity of product as "<quantity>"
	When choose to buy the first item
	When moves to checkout from mini cart
	When select "<country>" on checkout page
	When place the order
	Then close the browser
	
Examples:
	|product|			|quantity| 		|country|
	|cauliflower|		| 1|			|India|
#	|carrot|			| 5 |			|Japan|
#	|cucumber|			| 10 |			|India|
#	|potato|			| 21 |			|Australia|