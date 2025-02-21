package com.webdriver.Interactions;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * KeysActions.class Handles all the keyboard related method to used in the WebDriver,
 * To integrate with the test.
 */
public class KeysActions implements KeysActionsFacade {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	private Actions action;
	private JavascriptExecutor js;
	
	public KeysActions(WebDriver driver) {
		this.action = new Actions(driver);
		this.js = (JavascriptExecutor) driver;
	}
	
	//=========================================== METHODS ===========================================
	
	//webdriver element sendkeys [pass input]
	@Override
	public KeysActions sendKeys(WebElement element, String input) {
		element.sendKeys(input);
		return this;
	}
	
	//Actions class sendkeys [click and pass input]
	@Override
	public KeysActions actionSendKeys(WebElement element, String input) {
		action.sendKeys(element, input).perform();
		return this;
	}
	
	@Deprecated
	@Override
	public KeysActions jsSendKeys(WebElement element, String input) {
		js.executeScript("arguments[0].value = arguments[1];", element, input);
		return this;
	}
	
	
	
	
}
