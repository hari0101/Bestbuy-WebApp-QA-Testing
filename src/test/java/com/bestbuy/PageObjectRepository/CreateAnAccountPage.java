package com.bestbuy.PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class CreateAnAccountPage {
	
	private WebDriver driver;
	
	public CreateAnAccountPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div > h2")
	private WebElement firstnameField;
	
	@FindBy(id = "firstName")
	private WebElement lastnameField;
	
	@FindBy(name = "email")
	private WebElement emailaddressField;
	
	@FindBy(name = "password")
	private WebElement passwordField;
	
	@FindBy(css = ".show-hide-password")
	private WebElement showButton;
	
	@FindBy(id = "newsletter")
	private WebElement newsletterCheckBox;
	
	@FindBy(css = "button[data-automation='createAccountButton']")
	private WebElement createAccountButton;
	
	@FindBy(css = "div[data-testid='global-error-message']")
	private WebElement createAccountErrorMessage;
}
