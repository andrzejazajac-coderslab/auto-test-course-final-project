Feature: Login user in mystore, set address and check address

  Scenario Outline: User login to https://mystore-testlab.coderslab.pl, set and check user address
	Given Page https://mystore-testlab.coderslab.pl open in browser <browser>
	And Go to login page
	And Login user on <email> and <passwd>
	And Check if there is already an address
	And If yes, go to site address manage and there click Add new address
	And If no, click Add new address on this page

	Examples:
	  | browser | email                        | passwd     |
	  | Firefox | yhffzfuiqdzpbilmep@kvhrr.com | zDOUWwpQj0 |