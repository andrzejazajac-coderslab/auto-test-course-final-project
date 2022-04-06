Feature: Login user in mystore, buy product and take screenshot
  	Scenario Outline: User login to https://mystore-testlab.coderslab.pl, buy Hummingbird Printed Sweater and take screenshot
	  Given Page https://mystore-testlab.coderslab.pl open in browser <browser>
	  And Go to login page
	  And Login user on <email> and <passwd>
	  And Go to home page
	  When Select product <product>.
	  And Select size.
	  Examples:
		| browser | email | passwd | product |
		| Firefox | yhffzfuiqdzpbilmep@kvhrr.com | zDOUWwpQj0 | Hummingbird Printed Sweater |