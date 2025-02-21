package com.bestbuy.PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class SignInPage {

	private WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div > h1")
	private WebElement signInTitle;
	
	@FindBy(css = "input[aria-label='Enter account email address']")
	private WebElement emailAddressField;
	
	@FindBy(css = "input[aria-label='Enter account password']")
	private WebElement passwordField;
	
	@FindBy(css = "div > .show-hide-password")
	private WebElement showPasswordButton;
	
	@FindBy(css = "button > span:first-child")
	private WebElement signInButton;
	
	@FindBy(xpath = "(//a)[4]")
	private WebElement createAnAccountLink;
	
	@FindBy(css = "div[data-testid='global-error-message']")
	private WebElement signInErrorMessage;
}


