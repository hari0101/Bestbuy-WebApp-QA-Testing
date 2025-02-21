Feature: To valid the Sign In funtionality of the bestbuy application

  Scenario: To verify user can Sign In with the valid credentials
    Given the user is on the landing page
    When the user clicks the bestbuy account link
    And the user is redirected to the Sign In page
    And the user enters valid emailaddress and password
    And clicked the Sign In button 
    Then the user is redirected to the landing page

Scenario Outline: Login with different credentials
	Scenario: To verify user cannot Sign In with the Invalid credentials
		Given the user is on the home page
    When the user clicks the bestbuy account button
    And the user is redirected to Sign In page
    And the user enters valid <emailaddress> and <password>
    And the user is clicked the Sign In button 
    Then the user find the Error Message displayed

    Examples: 
      | emailaddress  				 | password  				| 
      | bestbuy.demo@          | BestBuyC@n@d@01  |	#Invalid <emailaddress> & Valid <password>
			| bestbuy.demo@gmail.com | BestBuy				  |	#Valid <emailaddress>   & Invalid <password>
			| bestbuy.demo           | BestBuy				  |	#Invalid <emailaddress> & Invalid <password>