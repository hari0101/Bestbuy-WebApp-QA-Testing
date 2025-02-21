package com.webdriver.DriverUtils;

import org.openqa.selenium.WebElement;

// Abstract method relates to the WebElementUtils.class
public interface WebElementUtilsFacade {

	public String getText(WebElement element) ;
	
	public String getDomProperty(WebElement element, String attributeValue);

	public String getDomAttribute(WebElement element, String attributeValue);

	public boolean isDisplayed(WebElement element);
	
	public boolean isEnabled(WebElement element);
	
	public boolean isSelected(WebElement element);
	
	public void deleteAllCookies();
	
	public void submit(WebElement element);
	
	public String getTitle();
	
	public void maximize();
	
	public void getURL(String url);
}
