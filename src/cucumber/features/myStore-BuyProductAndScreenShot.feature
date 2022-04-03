Feature: Login user in mystore, buy product and take screenshot
  	Scenario Outline: User login to https://mystore-testlab.coderslab.pl, buy Hummingbird Printed Sweater and take screenshot
	  Given Page https://mystore-testlab.coderslab.pl open in browser <browser>
	  And Go to login page
	  And Login user on <email> and <passwd>
	  And Go to home page
	  Examples:
		| browser | email | passwd |
		| Firefox | yhffzfuiqdzpbilmep@kvhrr.com | zDOUWwpQj0 |