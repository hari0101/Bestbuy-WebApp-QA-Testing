package com.webdriver.Webdriverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utilities.Exceptions.WebDriverNotFoundException;

/**WebDriverManager.class initialize the single instance of all the execution.
 * 
 * {@summary : Responsible to create and manage all the WebDriver instances 
 * 			   ChromeDriver(), EdgeDriver() and FirefoxDriver();				
 * 
 * RemoteWebDriver() will be handle here in the future execution, when the selenium grid pluged. 
 * }
 * 
 */
public final class WebDriverManager {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	/**
	 * private WebDriverManager()
	 * {@summary : Constructor, Cannot create object of the class }.
	 * 
	 * ThreadLocal<WebDriver> tldriver;
	 * {@summary : Thread-Local for thread safety with WebDriver generics}
	 * 
	 * WebDriverManager driverInstance;
	 * {@summary : In WebDriverManager.class single instance to handle the Specific driver }
	 */
	
	private WebDriverManager() { }
	
	private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	private static volatile WebDriverManager driverInstance;
	
	//=========================================== METHODS ===========================================
	
	public static WebDriverManager getInstance() {
		if(driverInstance == null)
		{
			synchronized(WebDriverManager.class) {
				if(driverInstance == null) {
					driverInstance = new WebDriverManager();
				}
			}
		}
		
		return driverInstance;
	}
	
	//================== CHROME,EDGE,FIREFOX DRIVER-METHODS ==================
	/**
	 * @param String browserType
	 * @param FactoryDriverOptions driverOptions
	 * @return WebDriverManager
	 * 
	 * {@summary setBrowserDriver based on the browserType and also inject specific driveroptions which 
	 * 			 is inbuilt reference type 
	 * 
	 * check for more {@link com.webdriver.Webdriverfactory.FactoryDriverOptions}
	 * }
	 */
	public WebDriverManager initLocalWebDriver(String browserType, FactoryDriverOptions driverOptions) {
		if(driverInstance != null) {
			driverInstance.initBrowserDriver(browserType, driverOptions);
		}
		return this;
	}
	
	/**
	 * getdriver()
	 * @return webdriver in the thread-local instance
	 */
	public WebDriver getLocaldriver() {
		return tldriver.get();
	}
	
	/**
	 * quitWebDriver() and closeWebDriver()
	 * {@summary : Both responsible for the quitting the specific window of the driver or
	 * 			   Close complete driver instance itself
	 * }
	 */
	public void quitLocalDriver() {
		if(tldriver.get() != null) {
			tldriver.get().quit();
			tldriver.remove();
		}
	}
	
	public void closeLocalDriver() {
		if(tldriver.get() != null) {
			tldriver.get().close();
		}
	}
	
	/**
	 * @param String browserType
	 * @param FactoryDriverOptions driverOptions
	 * 
	 * {@summary initBrowserDriver will set the instance to the Thread-local instance}
	 */
	private void initBrowserDriver(String browserType, FactoryDriverOptions driverOptions) {
		
		switch(browserType.toLowerCase()) {
		case "chrome" : tldriver.set(new ChromeDriver(driverOptions.getChromeOptions()));
		break;
		case "edge" : tldriver.set(new EdgeDriver(driverOptions.getEdgeOptions()));
		break;
		case "firefox" : tldriver.set(new FirefoxDriver(driverOptions.getFirefoxOptions()));
		break;
		default : throw new WebDriverNotFoundException(browserType);
		}
	}
	
//========================================== END-OF-DRIVER-METHODS ==========================================
}
	
	
	
	
	
	
	
	
