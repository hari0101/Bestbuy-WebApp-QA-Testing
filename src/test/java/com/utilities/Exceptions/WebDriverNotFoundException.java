package com.utilities.Exceptions;

@SuppressWarnings("serial")
public class WebDriverNotFoundException extends RuntimeException {

	public WebDriverNotFoundException(String message) {
		super(String.format("Invalid BrowserType : %s, Cannot initialize any WebDriver!", message));
	}
}
