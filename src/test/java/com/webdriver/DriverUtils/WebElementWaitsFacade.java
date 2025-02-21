package com.webdriver.DriverUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * WebDriverWait handling for the WebElementWaits.class
 */
public interface WebElementWaitsFacade {

	public void elementToBeClickable(WebElement element);
	
	public void elementToBeSelected(WebElement element) ;
	
	public void visibilityOfElement(WebElement element);
	
	public void alertIsPresent();
	
	public void visibilityOfElementLocated(By locator);
	
	public boolean textToBePresentInElement(WebElement element, String message);
	
	public void implicitlyWaitSeconds(int seconds);
	
	public void implicitlyWaitMilliSeconds(int milliSeconds);
	
	public void pageLoadTimeoutSeconds(int seconds);
}
