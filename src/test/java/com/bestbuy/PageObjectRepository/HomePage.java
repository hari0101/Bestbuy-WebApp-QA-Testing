package com.bestbuy.PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class HomePage {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[.='My Best Buy Account']")
	private WebElement mybestbuyaccountButton;
	
	@FindBy(className = "onetrust-close-btn-handler")
	private WebElement ontrustCloseButton;
}
