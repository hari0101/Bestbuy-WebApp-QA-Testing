package com.bestbuy.hooks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.webdriver.DriverUtils.*;
import com.webdriver.Webdriverfactory.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class DriverHooks {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	protected static WebDriver driver;
	protected static WebElementUtilsFacade driverUtil;
	
	/**===================================== LOCAL-DRIVER-METHODS ====================================
	 * @param context
	 * @param browserType
	 * 
	 * initializeLocalDriver - helps to initialize the webdriver based on testng.xml requirement.
	 */
	@Before
	public void initializeLocalDriver() {
		Map<String, Object> driverOptions = this.chromedriverOptions();
		FactoryDriverOptions desiredOptions = DriverOptionsManager.setBrowserdriverOptions("Chrome", driverOptions);
		driver = WebDriverManager.getInstance().initLocalWebDriver("Chrome", desiredOptions).getLocaldriver();
		
		driverUtil = new WebElementUtils(driver);
		driverUtil.maximize();
		driverUtil.getURL("https://www.bestbuy.ca/en-ca");
		driverUtil.deleteAllCookies();
	}
	
	//Closes all the LocalDriver current instance.
	//@After
	public void shutdownLocalDriver() {
		if(driver != null) {
			WebDriverManager.getInstance().quitLocalDriver();
		}
	}
	
	/**
	 * ====================================== REMOTE-DRIVER-METHODS =====================================
	 * @param context
	 * @param browserType
	 * @param os
	 * 
	 * initializeLocalDriver - helps to initialize the Remote webdriver based on testng.xml requirement.
	 */
	public void initializeRemoteDriver() {
		Map<String, Object> driverOptions = this.chromedriverOptions();
		FactoryDriverOptions desiredOptions = DriverOptionsManager.setBrowserdriverOptions("Chrome", driverOptions);
		DesiredCapabilities remotecap = RemoteWebDriverManager.getInstance().setSeleniumGridCapabilities("Windows", "Chrome", desiredOptions);
		driver = RemoteWebDriverManager.getInstance().initRemoteWebDriver("http://localhost:4444", remotecap).getRemoteDriver();
		
		driverUtil = new WebElementUtils(driver);
		driverUtil.maximize();
		driverUtil.getURL("https://magento.softwaretestingboard.com/");
	}
	
	//Closes all the RemoteDriver current instance.
	public void shutdownRemoteDriver() {
		if(driver != null) {
			RemoteWebDriverManager.getInstance().quitRemoteDriver();
		}
	}
	
	//Driver options setup method for both LOCAL and REMOTE Drivers.
	private Map<String, Object> chromedriverOptions() {
		//note : DEFAULT BROWSER ARGUMENTS ARE ALREADY SET IN THEIR OWN OPTIONSCLASSES [ex : ChromeOptionsManager]
		Map<String, Object> map = new ConcurrentHashMap<>();
		map.put("--headless", false);
		map.put("--disable-gpu", true);
		map.put("--disable-notifications", true);
		map.put("--incognito", false);
		map.put("excludeSwitches", new String[] {"enable-automation"});
		
		return map;
	}
	
}
