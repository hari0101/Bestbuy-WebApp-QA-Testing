package com.webdriver.Interactions;

import org.openqa.selenium.WebElement;

/**
 * Abstract methods for the Keyboard interaction class KeysActions.class
 */

public interface KeysActionsFacade {

	public KeysActions sendKeys(WebElement element, String input);	
	
	public KeysActions actionSendKeys(WebElement element, String input);
	
	public KeysActions jsSendKeys(WebElement element, String input);
	
}
