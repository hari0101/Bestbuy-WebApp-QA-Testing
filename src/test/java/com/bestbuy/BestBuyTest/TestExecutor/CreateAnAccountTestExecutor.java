package com.bestbuy.BestBuyTest.TestExecutor;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.bestbuy.PageObjectRepository.CreateAnAccountPage;

public class CreateAnAccountTestExecutor extends BaseTestExecutor {
	
	/** Parent BaseTestExecutor
	*common WEBDRIVER instance shared [driver].
	*common ELEMENT interact instance [ elementUtil ].
	*common KEY interact instance [ keysUtil ].
	*common CLICK interact instance [ clickUtil ].	
	*/
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	private CreateAnAccountPage newAccountLocators;
	
	public CreateAnAccountTestExecutor(WebDriver driver){
		super(driver);
		this.driver = driver;
		
		if(newAccountLocators == null)
			newAccountLocators = new CreateAnAccountPage(driver);
	}
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	
	//In Page header displayed validation
	public CreateAnAccountTestExecutor isPageHeaderDisplayed(String assertion) {
		Assert.assertEquals("Create a My Best Buy account", assertion);
		return this;
	}
	
	public CreateAnAccountTestExecutor inputFirstName(String firstname) {
		keysUtil.sendKeys(newAccountLocators.getFirstnameField(), firstname);
		return this;
	}
	
	public CreateAnAccountTestExecutor inputLastName(String lastname) {
		keysUtil.sendKeys(newAccountLocators.getLastnameField(), lastname);
		return this;
	}
	
	public CreateAnAccountTestExecutor inputEmailAddress(String emailaddress) {
		keysUtil.sendKeys(newAccountLocators.getEmailaddressField(), emailaddress);
		return this;
	}
	
	public CreateAnAccountTestExecutor inputPassword(String password) {
		keysUtil.sendKeys(newAccountLocators.getPasswordField(), password);
		return this;
	}
	
	public CreateAnAccountTestExecutor clickShowPassword() {
		clickUtil.click(newAccountLocators.getShowButton());
		return this;
	}
	
	public CreateAnAccountTestExecutor clickNewsletterCheckbox() {
		clickUtil.click(newAccountLocators.getNewsletterCheckBox());
		return this;
	}
	
	public CreateAnAccountTestExecutor clickCreateAccountButton() {
		clickUtil.click(newAccountLocators.getCreateAccountButton());
		return this;
	}
	
	public boolean isCreateAccountErrorDisplayed() {
		return elementUtil.isDisplayed(newAccountLocators.getCreateAccountErrorMessage());
	}
}
