package com.webdriver.Interactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * ClickActions.class Handles all the click related method to used in the WebDriver,
 * To integrate with the test.
 */
public class ClickActions implements ClickActionsFacade {

	//==================================== FIELDS & CONSTRUCTOR ====================================
	
	private Actions action;
	private JavascriptExecutor js;
	
	public ClickActions(WebDriver driver) {
		this.action = new Actions(driver);
		this.js =  (JavascriptExecutor) driver;
	}
	
		
	//=========================================== METHODS ===========================================
	
	@Override
	public ClickActionsFacade click(WebElement element) {
		element.click();
		return this;
	}
	
	@Override
	public ClickActionsFacade doubleClick(WebElement element) {
		action.doubleClick(element).perform();
		return this;
	}
	
	@Override
	public ClickActionsFacade actionsClick(WebElement element) {
		action.click(element).perform();
		return this;
	}
	
	@Override
	public ClickActionsFacade mouseHover(WebElement element) {
		action.moveToElement(element).perform();
		return this;
	}
	
	@Override
	public ClickActionsFacade rightClick(WebElement element) {
		action.contextClick(element).perform();
		return this;
	}
	
	@Override
	public ClickActionsFacade releaseMouse(WebElement element) {
		action.release(element).perform();
		return this;
	}
	
	@Override
	public ClickActionsFacade jsClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);
		return this;
	}
	
	
}
