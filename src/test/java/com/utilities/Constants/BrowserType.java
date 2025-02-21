package com.utilities.Constants;

//BROWSER for validate all browser String validation in constant 
public enum BrowserType {
	
	CHROME("chrome"), 
	EDGE("edge"), 
	FIREFOX("firefox"),
	SAFARI("safari");

	private final String browserType;
	
	BrowserType(String browserType) {
		this.browserType = browserType;
	}

	public String getBrowserName() {
		return this.browserType;
	}

}