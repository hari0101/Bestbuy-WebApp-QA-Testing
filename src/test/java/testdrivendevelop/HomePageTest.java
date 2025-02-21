package testdrivendevelop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webdriver.Interactions.ClickActions;
import com.webdriver.Interactions.ClickActionsFacade;
import com.webdriver.Interactions.KeysActions;
import com.webdriver.Interactions.KeysActionsFacade;

public class HomePageTest {
	
	public WebDriver driver;
	
	@BeforeTest(enabled = false)
	public void setUpDriver(ITestContext context) {
		
		driver = new ChromeDriver();
		
		context.setAttribute("Driver", driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test
	@Parameters({"startMaximized", "headless", "disableGPU", "AutomationControlInfo", "remoteDebugging", "disableNotification", "incognito"})
	public void testparameters(String max, String less, String gpu, String info, String remote, String disablenoti, String ico) {
		
		System.out.println(max);
		System.out.println(less);
		System.out.println(gpu);
		System.out.println(info);
		System.out.println(remote);
		System.out.println(disablenoti);
		System.out.println(ico);
		
	}
	
	
	
	
	@Test(enabled = false)
	@Parameters({"Browser"})
	public void sauceLabsLogin(String username, String password) {
		
		ClickActionsFacade clicks = new ClickActions(driver);
		KeysActionsFacade keys = new KeysActions(driver);
		
		WebElement usernamefield = driver.findElement(By.id("user-name"));
		WebElement passwordfield = driver.findElement(By.id("password"));
		WebElement buttonclick = driver.findElement(By.name("login-button"));
		
		keys.sendKeys(usernamefield, username).sendKeys(passwordfield, password);
		
		System.out.println("PROPERTY" + usernamefield.getDomProperty("value"));
		System.out.println("PROPERTY" + passwordfield.getDomProperty("value"));
		clicks.click(buttonclick);
		
		try {
			WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
			
			if(error.isDisplayed()) {
				
				//WebElement uf = driver.findElement(By.id("user-name"));
			//	WebElement pf = driver.findElement(By.id("password"));
				usernamefield.clear();
				passwordfield.clear();
			}
		}
		catch(NoSuchElementException nsee) {
			System.out.println("No error message is Displayed! ");
		}
			
		try {
			WebElement ham = driver.findElement(By.cssSelector(".bm-burger-button"));
			clicks.click(ham);
			
			WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
			clicks.click(logout);
		}
		catch(NoSuchElementException nsee) {
			System.out.println("Hamburger menu is not clicked! ");
		}
		
	}
	
	
}	
