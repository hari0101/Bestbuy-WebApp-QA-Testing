package com.webdriver.Interactions;

import org.openqa.selenium.WebElement;

/**
 * ClickActionsFacade.interface for handling the different kinds of click actions methods by the web elements
 * 
 * {@link  ClickActions.class }
 */

public interface ClickActionsFacade {
	
	public ClickActionsFacade click(WebElement element);
	
	public ClickActionsFacade actionsClick(WebElement element);
	
	public ClickActionsFacade mouseHover(WebElement element);

	public ClickActionsFacade doubleClick(WebElement element);
	
	public ClickActionsFacade rightClick(WebElement element);
	
	public ClickActionsFacade releaseMouse(WebElement element);
	
	public ClickActionsFacade jsClick(WebElement element);
}
