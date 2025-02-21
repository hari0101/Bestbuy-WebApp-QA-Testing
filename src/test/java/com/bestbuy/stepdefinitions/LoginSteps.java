package com.bestbuy.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bestbuy.BestBuyTest.TestExecutor.HomepageTestExecutor;
import com.bestbuy.BestBuyTest.TestExecutor.SignInTestExecutor;
import com.webdriver.DriverUtils.WebElementUtils;
import com.webdriver.DriverUtils.WebElementUtilsFacade;
import com.webdriver.Webdriverfactory.WebDriverManager;

import io.cucumber.java.en.*;

public class LoginSteps {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	private static WebDriver driver =  WebDriverManager.getInstance().getLocaldriver();
	
	private static WebElementUtilsFacade driverUtil;
	private static HomepageTestExecutor homepage;
	private static SignInTestExecutor signInPage;	
	
	
	public LoginSteps() {
		driverUtil = new WebElementUtils(driver);
	}
	
	
	//======================================== SCENARIO-METHODS =======================================
	//SCENARIO 1: To verify user can Sign In with the valid credentials
	@Given("the user is on the landing page")
	public void the_user_is_on_the_landing_page() {
		homepage = new HomepageTestExecutor(driver);
		String pageTitle = driverUtil.getTitle();
		homepage.clickOnTrustCloseButton()
				.verify(basepage -> {
			Assert.assertEquals(pageTitle, "Best Buy: Shop Online For Deals & Save | Best Buy Canada");
		});
	}

	@When("the user clicks the bestbuy account link")
	public void the_user_clicks_the_bestbuy_account_link() {
		homepage.verify(HomepageTestExecutor::isMyBestBuyAccountDisplayed)
				.clickBestBuyAccountLink();
	}

	@When("the user is redirected to the Sign In page")
	public void the_user_is_redirected_to_the_sign_in_page() {
		signInPage = new SignInTestExecutor(driver);
		signInPage.isPageHeaderDisplayed("Sign In");
	}

	@When("the user enters valid emailaddress and password")
	public void the_user_enters_valid_emailaddress_and_password() {
		signInPage.inputEmailAddress("bestbuy.demo@gmail.com")
				.inputPassword("BestBuyC@n@d@01");
	}

	@When("clicked the Sign In button")
	public void clicked_the_sign_in_button() {
		signInPage.clickSignInButton();
	}

	@Then("the user is redirected to the landing page")
	public void the_user_is_redirected_to_the_landing_page() {
		String pageTitle = driverUtil.getTitle();
		
		if(pageTitle.equalsIgnoreCase("Best Buy: Shop Online For Deals & Save | Best Buy Canada")) {
			Assert.assertTrue(true);
		}
		
		if(signInPage.isErrorMessage()) {
			Assert.assertTrue(false, "Warning message as displayed! Unable to Sign In with entered Emailaddress and Password");
		}
	}	
	
	//SCENARIO 2: To verify user cannot Sign In with the Invalid credentials 
	
	@Given("the user is on the landing page")
	public void the_user_is_on_the_home_page() {
		homepage = new HomepageTestExecutor(driver);
		String pageTitle = driverUtil.getTitle();
		homepage.clickOnTrustCloseButton()
				.verify(basepage -> {
			Assert.assertEquals(pageTitle, "Best Buy: Shop Online For Deals & Save | Best Buy Canada");
		});
	}
	
	@When("the user clicks the bestbuy account link")
	public void the_user_clicks_the_bestbuy_account_button() {
		homepage.verify(HomepageTestExecutor::isMyBestBuyAccountDisplayed)
		.clickBestBuyAccountLink();
	}
	
	@When("the user is redirected to the Sign In page")
	public void the_user_is_redirected_to_sign_in_page() {
		signInPage = new SignInTestExecutor(driver);
		signInPage.isPageHeaderDisplayed("Sign In");
	}
	@When("the user enters valid {string} and {string}")
	public void the_user_enters_valid_bestbuy_demo_gmail_com_and_best_buy_c_n_d(String emailaddress, String password) {
		signInPage.inputEmailAddress(emailaddress)
		.inputPassword(password);
	}
	
	@When("the user is clicked the Sign In button")
	public void the_user_is_clicked_the_sign_in_button() {
		signInPage.clickSignInButton();
	}
	
	@Then("the user find the Error Message displayed")
	public void the_user_find_the_error_message_displayed() {
		String pageTitle = driverUtil.getTitle();
		
		if(pageTitle.equalsIgnoreCase("Best Buy: Shop Online For Deals & Save | Best Buy Canada")) {
			Assert.assertTrue(false);
		}
		
		if(signInPage.isErrorMessage()) {
			Assert.assertTrue(true, "Warning message as displayed! Unable to Sign In with entered Emailaddress and Password");
		}
	}

	
}
