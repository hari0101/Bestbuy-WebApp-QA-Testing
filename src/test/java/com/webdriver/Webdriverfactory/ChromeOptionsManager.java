package com.webdriver.Webdriverfactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.chrome.ChromeOptions;

/**
 * {@link com.webdriver.Webdriverfactory.FactoryDriverOptions.java} - Parent interface.
 * 
 * ChromeOptionsManager.class all the member fields and methods are only belongs 
 * to [ChromeDrivers & ChromeOptions] instance. 
 * 
 * ChromeOptionsManager.class is used singleton and SRP Pattern to initialize the instance.
 * Cannot inherited, No object creation, no second instance and allows Thread - safety for parallel browser.
 */

public class ChromeOptionsManager implements FactoryDriverOptions  {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	
	/**
	 * private ChromeOptionsManager()
	 * {@summary : Constructor, Cannot create object of the class }.
	 * 
	 * ThreadLocal<ChromeOptions> chromeOptionsThread;
	 * {@summary : Thread-Local for thread safety with chromeoptions generics}
	 * 
	 * FactoryDriverOptions chromeOptionsInstance;
	 * {@summary : Parent interface to handle all the Options Factory class}
	 */
	private ChromeOptionsManager() {  }
	
	private static ThreadLocal<ChromeOptions> chromeOptionsThread = new ThreadLocal<ChromeOptions>();
	
	private static volatile FactoryDriverOptions chromeOptionsInstance;
	
	//=========================================== METHODS ===========================================
	
	/**
	 * {@summary - METHODS
	 * 	getInstance() - Responsible for creating the class level single instance.
	 * 
	 * 	initDriverOptions() - Responsible for initialize the chromeoptions object
	 * 						  to the THREAD-LOCAL instance to set.
	 * 		
	 *  setOptionsArguments() - Responsible to manipulate the arguments Map which
	 *  						passed inside and added the arguments based on 
	 *  						true or false of the Value.
	 *  
	 *  {@returns  chromeOptionsInstance }
	 *  
	 *  getChromeOptions() - @return ChromeOptions instance from the thread-local
	 *  					 instance.	
	 * }
	 */
	
	//Singleton class level object creation.
	public static FactoryDriverOptions getInstance() {
		if(chromeOptionsInstance == null) {
			//checks one-by-one if the instance is null or already initialized.
			synchronized(ChromeOptionsManager.class){
				if(chromeOptionsInstance == null) {
					chromeOptionsInstance = new ChromeOptionsManager();
				}
			}
		}
		
		return chromeOptionsInstance;
	}
	
	@Override
	public FactoryDriverOptions initDriverOptions() {
		if(chromeOptionsThread != null) {
			chromeOptionsThread.set(new ChromeOptions());
		}
		
		return chromeOptionsInstance;
	}
	
	@Override
	public ChromeOptions getChromeOptions() {
		return chromeOptionsThread.get();
	}
	
	
	@Override
	public FactoryDriverOptions setOptionsArguments(Map<String, Object> optionsMap) {
		//Default ChromeOptions SetUp
		Map<String, Object> defaultMapPrefs = new ConcurrentHashMap<>(); 
		defaultMapPrefs.put("credentials_enable_service", false);
		defaultMapPrefs.put("profile.password_manager_enabled", false);
		getChromeOptions().setExperimentalOption("prefs", defaultMapPrefs);
		
		if(optionsMap != null) {
			for(Map.Entry<String, Object> option : optionsMap.entrySet()) {
				if(option.getValue() instanceof Boolean && (Boolean)option.getValue()) {
					getChromeOptions().addArguments(option.getKey());
				}
				else if(option.getValue() instanceof String[]){
					getChromeOptions().setExperimentalOption(option.getKey(), (String[])option.getValue());	
				}
			}
		}
		else
		{	
			//Might change the custom exceptions
			throw new IllegalArgumentException("ChromeOptions Map reference contains Invalid key arguments!! " + optionsMap);
		}
		return chromeOptionsInstance;
	}
	
	//========================================== END-OF-METHODS ==========================================
	
}
