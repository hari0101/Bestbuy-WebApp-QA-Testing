package com.webdriver.Webdriverfactory;

import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * FactoryDriverOptions is the Main interface of all the DriverOptions Injection to the WebDriver instance.
 * 
 * Implemented classes
 * {@link
 * 		com.webdriver.Webdriverfactory.ChromeOptionsManager.java 
 * 		webdriverfactory.EdgeOptionsManager.java		
 * 		webdriverfactory.FirefoxOptionsManager.java
 * }
 * 
 */

public interface FactoryDriverOptions {
	
	//Common abstract methods implemented all the classes.
	public FactoryDriverOptions initDriverOptions();
	
	public FactoryDriverOptions setOptionsArguments(Map<String, Object> options);
	
	
	//Specific concrete method for specific classes.
	default ChromeOptions getChromeOptions() {
		return null;
	};
	
	default EdgeOptions getEdgeOptions() {
		return null;
	};
	
	default FirefoxOptions getFirefoxOptions() {
		return null;
	};

}
