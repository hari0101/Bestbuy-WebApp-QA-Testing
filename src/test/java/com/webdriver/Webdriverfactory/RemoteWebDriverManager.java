package com.webdriver.Webdriverfactory;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.utilities.Constants.BrowserType;
import com.utilities.Constants.PlatformType;
import com.utilities.Exceptions.WebDriverNotFoundException;
import com.utilities.Exceptions.WebDriverOptionsNotFoundException;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RemoteWebDriverManager {
	
	//==================================== FIELDS & CONSTRUCTOR =====================================
	
	private RemoteWebDriverManager() {}
	
	private static ThreadLocal<RemoteWebDriver> remotedriverThread = new ThreadLocal<>();
	
	private static volatile RemoteWebDriverManager remotedriverInstance;
	
	private DesiredCapabilities desiredCap; 
	//=========================================== METHODS ===========================================
	
	public static RemoteWebDriverManager getInstance() {
		
		if(remotedriverInstance == null) {
			synchronized(RemoteWebDriverManager.class) {
				if(remotedriverInstance == null) {
					remotedriverInstance = new RemoteWebDriverManager();
				}
			}
		}
		return remotedriverInstance;
	}
	
	//============== RemoteDriver Methods ==============
	
	/**
	 * @param url
	 * @param desiredCapability
	 * @return RemoteWebDriverManager
	 * 
	 * {@summary Initialize the RemoteDriver by getting the remoteHost URL also required capability }
	 */
	
	public RemoteWebDriverManager initRemoteWebDriver(String url, DesiredCapabilities desiredCapability) {
		
		if(remotedriverInstance != null) {
			try {
				remotedriverThread.set(new RemoteWebDriver(new URL(url), desiredCapability));
			} 
			catch (MalformedURLException mue) {
				System.out.println("Invalid RemoteHost URL" + mue.getMessage());
			}
		}
		
		return remotedriverInstance;
	}
	
	public RemoteWebDriver getRemoteDriver() {
		if(remotedriverThread != null) 
			return remotedriverThread.get();
		
		throw new WebDriverNotFoundException("RemoteDriver");
	}
	
	//Quit and Close of the browser window
	public void quitRemoteDriver() {
		if(this.getRemoteDriver() != null ) {
			this.getRemoteDriver().quit();
		}
	}
	
	public void closeRemoteDriver() {
		if(this.getRemoteDriver() != null ) {
			this.getRemoteDriver().close();
		}
	}
	
	
	/**
	 * @param browserName
	 * @param browserVersion
	 * @param platform
	 * @param platformVersion
	 * @return DesiredCapabilities
	 * 
	 * {@summary : setCapability have Risk of key typos or incorrect value! 
	 * 	
	 * 	SELENIUM GRID Test
	 * 	
	 * 	Best practice to implement the browserName and platformname include with predefined enumerations final String.
	 * 	{@link  constants.BrowserType, constants.PlatformType }
	 * 	Ex : BrowserType.CHROME.getBrowserName() @return String name.
	 * 	Ex : PlatformType.WINDOWS.getPlatformName() @return String name.
	 * }
	 */
	public DesiredCapabilities setSeleniumGridCapabilities(String platform, String browserName, FactoryDriverOptions options) {
		desiredCap = new DesiredCapabilities();
		
		//Set required platform to the capabilities
		if(platform.equalsIgnoreCase(PlatformType.WINDOWS.getPlatformName())) {
			desiredCap.setPlatform(Platform.WINDOWS);
		}
		else if(platform.equalsIgnoreCase(PlatformType.LINUX.getPlatformName())) {
			desiredCap.setPlatform(Platform.LINUX);
		}
		else if(platform.equalsIgnoreCase(PlatformType.MACOS.getPlatformName())) {
			desiredCap.setPlatform(Platform.MAC);
		}
		else
		{
			 throw new IllegalArgumentException("Unknown platform : " + platform + " Unable to configure Operating System!");
		}
			
			
		//Set required browser to the capabilities
		if(browserName.equalsIgnoreCase(BrowserType.CHROME.getBrowserName())) {
			desiredCap.setBrowserName(BrowserType.CHROME.getBrowserName());
		}
		else if(browserName.equalsIgnoreCase(BrowserType.EDGE.getBrowserName())) {
			desiredCap.setBrowserName(BrowserType.EDGE.getBrowserName());
		}
		else if(browserName.equalsIgnoreCase(BrowserType.FIREFOX.getBrowserName())) {
			desiredCap.setBrowserName(BrowserType.FIREFOX.getBrowserName());
		}
		else if(browserName.equalsIgnoreCase(BrowserType.SAFARI.getBrowserName())) {
			desiredCap.setBrowserName(BrowserType.SAFARI.getBrowserName());
		}
		else
		{
			 throw new IllegalArgumentException("Unknown browser : " + browserName + " Unable to configure BrowserType!");
		}
		
		//integrate Options for Webdriver
		if(options != null) {
			switch(browserName.toLowerCase()) {
			
			case "chrome"  : desiredCap.setCapability(ChromeOptions.CAPABILITY, options.getChromeOptions());
			break;
			case "edge"    : desiredCap.setCapability(EdgeOptions.CAPABILITY, options.getEdgeOptions());
			break;
			case "firefox" : desiredCap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.getFirefoxOptions());
			break;
			default : throw new WebDriverOptionsNotFoundException(browserName);
			}
		}
		
		return desiredCap;
	}

	/**
	 * {@summary Focus on the BrowserStack, LambdaTest and other cloud based test execution}
	 * 
	 */
	public void setCloudBase() {
		
		//Implementation will be handle at Future!!!
	}







}