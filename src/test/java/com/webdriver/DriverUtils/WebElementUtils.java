package com.webdriver.DriverUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementUtils implements WebElementUtilsFacade {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	private WebDriver driver;
	
	public WebElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	//=========================================== METHODS ===========================================
	
	//Delete all the cookies in the webpage
	@Override
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}
	
	//Pass URL
	@Override
	public void getURL(String url) {
		driver.get(url);
	}
	
	//maxmize the browser
	@Override
	public void maximize() {
		driver.manage().window().maximize();
	}
	
	//Get the text of the element
	@Override
	public String getText(WebElement element) {
		return element.getText();
	}
	
	//Get the inputted value of the any attribute in Tag.
	@Override
	public String getDomProperty(WebElement element, String attributeValue) {
		return element.getDomProperty(attributeValue);
	}
	
	//Get the default value of the any attribute in Tag.
	@Override
	public String getDomAttribute(WebElement element, String attributeValue) {
		return element.getDomAttribute(attributeValue);
	}
	
	//Check whether element is displayed or not.
	@Override
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	//Check whether element is Enabled or not to click.
	@Override
	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	//Check whether element is Selected or not.
	@Override
	public boolean isSelected(WebElement element) {
		return element.isSelected();
	}
	
	//Submit the form directly without clicking the button.
	@Override
	public void submit(WebElement element) {
		element.submit();
	}
	
	//get the current page title
	@Override
	public String getTitle() {
		return driver.getTitle();
	}
	
}
