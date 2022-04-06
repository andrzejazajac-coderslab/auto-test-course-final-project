Feature: Login user in mystore, buy product and take screenshot
  	Scenario Outline: User login to https://mystore-testlab.coderslab.pl, buy Hummingbird Printed Sweater and take screenshot
	  Given Page https://mystore-testlab.coderslab.pl open in browser <browser>
	  And Go to login page
	  And Login user on <email> and <passwd>
	  And Go to home page
	  When Select product <product>.
	  And Select size <size>.
	  And Select quantity <quantity>.
	  And Add to cart.
	  And Click link "Proceed to checkout".
	  And Click link "Proceed to checkout" in cart.
	  And Confirm address.
	  And Select shipping method.
	  And Select payment.
	  And Click "Order with an obligation to pay".
	  Examples:
		| browser | email | passwd | product | size | quantity |
		| Firefox | yhffzfuiqdzpbilmep@kvhrr.com | zDOUWwpQj0 | Hummingbird Printed Sweater | M| 5|