package com.bestbuy.BestBuyTest.TestExecutor;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.bestbuy.PageObjectRepository.SignInPage;

public class SignInTestExecutor extends BaseTestExecutor {
	
	/** Parent BaseTestExecutor
	*common WEBDRIVER instance shared [driver].
	*common ELEMENT interact instance [ elementUtil ].
	*common KEY interact instance [ keysUtil ].
	*common CLICK interact instance [ clickUtil ].	
	*/

	//==================================== FIELDS & CONSTRUCTOR ====================================
	private SignInPage signInLocators;
	
	public SignInTestExecutor(WebDriver driver) {
		super(driver);
		
		if(signInLocators == null)
			signInLocators = new SignInPage(driver);
	}
	
	//=========================================== METHODS ===========================================
	
	//Enter the emailaddress
	public SignInTestExecutor inputEmailAddress(String emailaddress) {
		keysUtil.sendKeys(signInLocators.getEmailAddressField(), emailaddress);
		return this;
	}
	
	//Enter the password.
	public SignInTestExecutor inputPassword(String password) {
		keysUtil.sendKeys(signInLocators.getPasswordField(), password);
		return this;
	}
	
	//Click the signin button.
	public SignInTestExecutor clickSignInButton() {
		clickUtil.click(signInLocators.getSignInButton());
		return this;
	}
	
	//Returns true or false based on error message displayed.
	public boolean isErrorMessage() {
		return elementUtil.isDisplayed(signInLocators.getSignInErrorMessage());
		
	}
	
	//click the create account button
	public void clickCreateAccountLink() {
		clickUtil.click(signInLocators.getCreateAnAccountLink());
		new CreateAnAccountTestExecutor(this.driver);
	}
	
	//In page header validation
	public SignInTestExecutor isPageHeaderDisplayed(String assertion) {
		Assert.assertEquals("Sign In", assertion);
		return this;
	}
	
	
}
