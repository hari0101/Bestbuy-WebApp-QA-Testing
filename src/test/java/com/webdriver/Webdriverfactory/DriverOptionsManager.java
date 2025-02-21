package com.webdriver.Webdriverfactory;

import java.util.Map;

import com.utilities.Exceptions.WebDriverOptionsNotFoundException;

/**
 * Options Base class to handle the all Webdriver options Managers 
 * {@link 
 * 		com.webdriver.Webdriverfactory.ChromeOptionsManager.java 
 * 		webdriverfactory.EdgeOptionsManager.java		
 * 		webdriverfactory.FirefoxOptionsManager.java
 * }
 * 
 * DriverOptionsManager.class 
 * {@summary : To manage all the options manager to initialize by browsertype }
 */

public class DriverOptionsManager {
	//=================================== FIELDS & CONSTRUCTOR ===================================
	/**
	 *		NULL 
	 */
	//========================================== METHODS ==========================================
	
	/**
	 * @param String browsername
	 * @param Map<String, Objects> optionsMap
	 * @return FactoryDriverOptions
	 */
	public static FactoryDriverOptions setBrowserdriverOptions(String browsertype, Map<String, Object> optionsMap) {
		
		switch(browsertype.toLowerCase()) {
		case "chrome" : 
			return ChromeOptionsManager.getInstance().initDriverOptions().setOptionsArguments(optionsMap);
		
		case "edge" : 
			return EdgeOptionsManager.getInstance().initDriverOptions().setOptionsArguments(optionsMap);
		
		case "firefox" : 
			return FirefoxOptionsManager.getInstance().initDriverOptions().setOptionsArguments(optionsMap);
		
		default : throw new WebDriverOptionsNotFoundException(browsertype);
		}
	}
}
