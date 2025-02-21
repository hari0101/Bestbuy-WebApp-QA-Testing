package com.bestbuy.BestBuyTest.TestExecutor;

import java.util.function.Consumer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bestbuy.PageObjectRepository.HomePage;

public class HomepageTestExecutor extends BaseTestExecutor {
	
	/** Parent BaseTestExecutor
	*common WEBDRIVER instance shared [driver].
	*common ELEMENT interact instance [ elementUtil ].
	*common KEY interact instance [ keysUtil ].
	*common CLICK interact instance [ clickUtil ].	
	*/
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	
	private HomePage hpLocators;
	
	public HomepageTestExecutor(WebDriver driver) {
		super(driver);
		if(hpLocators == null)
		hpLocators = new HomePage(driver);
	}
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	
	//To make any assertion check
	public HomepageTestExecutor verify(Consumer<HomepageTestExecutor> assertion) {
		assertion.accept(this);
		return this;
	}
	
	public boolean isMyBestBuyAccountDisplayed() {
		return elementUtil.isDisplayed(hpLocators.getMybestbuyaccountButton());
	}
	//Click the MYBESTBUY Account page from the homepage.
	public HomepageTestExecutor clickBestBuyAccountLink() {
		clickUtil.click(hpLocators.getMybestbuyaccountButton());
		return this;
	}
	
	//Privacy cookies dialog box close button.
	public HomepageTestExecutor clickOnTrustCloseButton() {
		WebElement trustCloseButton = hpLocators.getOntrustCloseButton();
		
		if(elementUtil.isDisplayed(trustCloseButton))
			clickUtil.click(trustCloseButton);
		
		return this;
	}
	
	
}
