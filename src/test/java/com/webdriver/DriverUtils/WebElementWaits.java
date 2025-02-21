package com.webdriver.DriverUtils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * WebElement Waits helps to synchronized & Communicate to the element in the DOM using different wait methods.
 * WebElementWaits.class provide the varieties of wait methods.
 * 
 */
public class WebElementWaits implements WebElementWaitsFacade {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	private WebDriver driver;
	private WebDriverWait wait;
	
	public WebElementWaits(WebDriver driver, int DEFAULT_TIME) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME));
	}
	
	
	//=========================================== METHODS ===========================================
	
	//Implict wait in Seconds
	@Override
	public void implicitlyWaitSeconds(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	//Implict wait in Milli-Seconds
	@Override
	public void implicitlyWaitMilliSeconds(int milliSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(milliSeconds));
	}
	
	//Pageload timeout if the page takes more than the given timeunit throws exception
	@Override
	public void pageLoadTimeoutSeconds(int seconds) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}
	
	//Waits for the element is both present in the DOM and clickable.
	@Override
	public void elementToBeClickable(WebElement element) throws TimeoutException {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//Waits until the element is selected (useful for checkboxes or radio buttons).
	@Override
	public void elementToBeSelected(WebElement element) throws TimeoutException {
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	
	//Wait for element should visible
	@Override
	public void visibilityOfElement(WebElement element) throws TimeoutException {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//Wait for the alert should present in the page
	@Override
	public void alertIsPresent() throws TimeoutException {
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	//Wait for an element to be located and become visible
	@Override
	public void visibilityOfElementLocated(By locator) throws TimeoutException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//Wait until the message or text available in the page.
	@Override
	public boolean textToBePresentInElement(WebElement element, String message) throws TimeoutException {
		return wait.until(ExpectedConditions.textToBePresentInElement(element, message));
	}
	
	
}
