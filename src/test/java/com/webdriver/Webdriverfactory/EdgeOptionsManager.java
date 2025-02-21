package com.webdriver.Webdriverfactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.edge.EdgeOptions;

/**
 * {@link com.webdriver.Webdriverfactory.FactoryDriverOptions.java} - Parent interface.
 *  
 * EdgeOptionsManager.class all the member fields and methods are only belongs 
 * to [EdgeDrivers & EdgeOptions] instance. 
 * 
 * EdgeOptionsManager.class is used singleton and SRP Pattern to initialize the instance.
 * Cannot inherited, No object creation, no second instance and allows Thread - safety for parallel browser.
 */
public class EdgeOptionsManager implements FactoryDriverOptions {
	
	//=================================== FIELDS & CONSTRUCTOR ===================================
	/**
	 * private EdgeOptionsManager()
	 * {@summary : Constructor, Cannot create object of the class }.
	 * 
	 * ThreadLocal<EdgeOptions> edgeOptionsThread;
	 * {@summary : Thread-Local for thread safety with chromeoptions generics}
	 * 
	 * FactoryDriverOptions edgeOptionsInstance;
	 * {@summary : Parent interface to handle all the Options Factory class}
	 */
	
	private EdgeOptionsManager() { }
	
	private static ThreadLocal<EdgeOptions> edgeOptionsThread = new ThreadLocal<>(); 
	
	private volatile static FactoryDriverOptions edgeOptionsInstance;
	
	//========================================== METHODS ==========================================
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
	 *  {@returns  edgeOptionsInstance }
	 *  
	 *  getEdgeOptions() - @return EdgeOptions instance from the thread-local
	 *  					 instance.	
	 * }
	 */
	
	//Singleton class level object creation.
	public static FactoryDriverOptions getInstance() {
		if(edgeOptionsInstance == null) {
			synchronized(EdgeOptionsManager.class){
				if(edgeOptionsInstance == null) {
					edgeOptionsInstance = new EdgeOptionsManager();
				}
			}
		}
		
		return edgeOptionsInstance;
	}	
	
	@Override
	public FactoryDriverOptions initDriverOptions() {
		if(edgeOptionsThread != null) {
			edgeOptionsThread.set(new EdgeOptions());
		}
		
		return edgeOptionsInstance;
	}
	
	@Override
	public EdgeOptions getEdgeOptions() {
		return edgeOptionsThread.get();
	}
	
	@Override
	public FactoryDriverOptions setOptionsArguments(Map<String, Object> optionsMap) {
		//Default ChromeOptions SetUp
		Map<String, Object> defaultMapPrefs = new ConcurrentHashMap<>(); 
		defaultMapPrefs.put("credentials_enable_service", false);
		defaultMapPrefs.put("profile.password_manager_enabled", false);
		getEdgeOptions().setExperimentalOption("prefs", defaultMapPrefs);
		
		if(optionsMap != null) {
			for(Map.Entry<String, Object> option : optionsMap.entrySet()) {
				if(option.getValue() instanceof Boolean && (Boolean)option.getValue()) {
					getEdgeOptions().addArguments(option.getKey());
				}
				else if(option.getValue() instanceof String[]) {
					getEdgeOptions().setExperimentalOption(option.getKey(), (String[])option.getValue());
				}
				else{
					//For the future Two-Strings key:value arguments configs.
					//Example : proxy arguments
				}
			}
		}
		else
		{	
			//custom 
			throw new IllegalArgumentException("EdgeOptions Map reference contains Invalid key arguments!! " + optionsMap);
		}
		
		return edgeOptionsInstance;
	}

}
