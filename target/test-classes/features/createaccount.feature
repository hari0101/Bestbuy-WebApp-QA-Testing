Feature: To verify the Create new Account functionality is working as expected

	Background:
		Given the user is on the landing page
		Then the user click My Best Buy Account button
		And the user is navigated to the Sign In page 
		
	Scenario: To verify the user can create new account with valid credentials
		Given the user is on the Sign In page
		When the user click the Create an account hyperlink
		And the user enter the valid firstname, lastname, Email and Password
		And the user click the newsletter checkbox and Create Account button
		Then the user successfully created the new Account   
		
		Scenario Outline:
		Scenario: To verify the user should not create account using the invalid credentials
		Given the user is on the Sign In page
		When the user click the Create an account hyperlink
		And the user enter the valid <Firstname>, <Lastname>, <Email> and <Password>
		And the user click the newsletter checkbox and Create Account button
		Then the user should see the error message displayed
		
		Examples: 
      Firstname |Lastname   | Email 				            | Password  				| 
      Mick12    |James      | bestbuy.account@gmail.com | BestbuyerU$@12    |	
      Mick      |James12    | bestbuy.account@gmail.com | BestbuyerU$@12    |	
      Mick      |James      | bestbuy.account           | BestbuyerU$@12    |	
      Mick      |James      | bestbuy.account@gmail.com | Bestbuyer         |	
		
		
		
		