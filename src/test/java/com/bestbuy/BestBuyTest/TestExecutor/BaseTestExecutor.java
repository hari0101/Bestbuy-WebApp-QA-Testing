package com.bestbuy.BestBuyTest.TestExecutor;

import org.openqa.selenium.WebDriver;

import com.webdriver.DriverUtils.WebElementUtils;
import com.webdriver.DriverUtils.WebElementUtilsFacade;
import com.webdriver.Interactions.ClickActions;
import com.webdriver.Interactions.ClickActionsFacade;
import com.webdriver.Interactions.KeysActions;
import com.webdriver.Interactions.KeysActionsFacade;

public class BaseTestExecutor {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	protected WebDriver driver;
	protected WebElementUtilsFacade elementUtil = null;
	protected ClickActionsFacade clickUtil = null;
	protected KeysActionsFacade keysUtil = null;
	
	
	public BaseTestExecutor(WebDriver driver) {
		if((this.driver == null && elementUtil == null && clickUtil == null && keysUtil == null)) {
			this.driver = driver;
			this.elementUtil = new WebElementUtils(driver);
			this.clickUtil = new ClickActions(driver);
			this.keysUtil = new KeysActions(driver);
		}
	
	}
	
}
