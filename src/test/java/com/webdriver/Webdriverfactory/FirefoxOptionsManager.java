package com.webdriver.Webdriverfactory;

import java.util.Map;
import org.openqa.selenium.firefox.FirefoxOptions;


/**
 * {@link com.webdriver.Webdriverfactory.FactoryDriverOptions.java} - Parent interface.
 *  
 * FirefoxOptionsManager.class all the member fields and methods are only belongs 
 * to [EdgeDrivers & EdgeOptions] instance. 
 * 
 * FirefoxOptionsManager.class is used singleton and SRP Pattern to initialize the instance.
 * Cannot inherited, No object creation, no second instance and allows Thread - safety for parallel browser.
 */
public class FirefoxOptionsManager implements FactoryDriverOptions {
	
	//=================================== FIELDS & CONSTRUCTOR ===================================
	/**
	 * private FirefoxOptionsManager()
	 * {@summary : Constructor, Cannot create object of the class }.
	 * 
	 * ThreadLocal<FirefoxOptions> firefoxOptionsThread;
	 * {@summary : Thread-Local for thread safety with chromeoptions generics}
	 * 
	 * FactoryDriverOptions firefoxOptionsInstance;
	 * {@summary : Parent interface to handle all the Options Factory class}
	 */
	
	private FirefoxOptionsManager() { }
	
	private static ThreadLocal<FirefoxOptions> firefoxOptionsThread = new ThreadLocal<>(); 
	
	private volatile static FactoryDriverOptions firefoxOptionsInstance;
	
	//========================================== METHODS ==========================================
	/**
	 * {@summary - METHODS
	 * 	getInstance() - Responsible for creating the class level single instance.
	 * 
	 * 	initDriverOptions() - Responsible for initialize the firefoxoptions object
	 * 						  to the THREAD-LOCAL instance to set.
	 * 		
	 *  setOptionsArguments() - Responsible to manipulate the arguments Map which
	 *  						passed inside and added the arguments based on 
	 *  						true or false of the Value.
	 *  
	 *  {@returns  firefoxOptionsInstance }
	 *  
	 *  getEdgeOptions() - @return EdgeOptions instance from the thread-local
	 *  					 instance.	
	 * }
	 */
	
	//Singleton class level object creation.
	public static FactoryDriverOptions getInstance() {
		if(firefoxOptionsInstance == null) {
			synchronized(FirefoxOptionsManager.class){
				if(firefoxOptionsInstance == null) {
					firefoxOptionsInstance = new FirefoxOptionsManager();
				}
			}
		}
		
		return firefoxOptionsInstance;
	}	
	
	@Override
	public FactoryDriverOptions initDriverOptions() {
		if(firefoxOptionsThread != null) {
			firefoxOptionsThread.set(new FirefoxOptions());
		}
		return firefoxOptionsInstance;
	}
	
	@Override
	public FirefoxOptions getFirefoxOptions() {
		return firefoxOptionsThread.get();
	}
	
	@Override
	public FactoryDriverOptions setOptionsArguments(Map<String, Object> optionsMap) {
		if(optionsMap != null) {
			for(Map.Entry<String, Object> option : optionsMap.entrySet()) {
				if(option.getValue() instanceof Boolean && (Boolean)option.getValue()) {
					getFirefoxOptions().addArguments(option.getKey());
				}
				else {
					//For the future Two-Strings keyvalue arguments config.
				}
			}
		}
		else
		{	
			//custom 
			throw new IllegalArgumentException("FirefoxOptions Map reference contains Invalid key arguments!! " + optionsMap);
		}
		
		return firefoxOptionsInstance;
	}

}
