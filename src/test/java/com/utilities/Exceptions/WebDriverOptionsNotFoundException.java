package com.utilities.Exceptions;

@SuppressWarnings("serial")
public class WebDriverOptionsNotFoundException extends RuntimeException {
	
public WebDriverOptionsNotFoundException(String browsertype) {
	super(String.format("Invalid Browsertype :  %s, Unable to invoke the WebdriverOptions!", browsertype));
}



}
