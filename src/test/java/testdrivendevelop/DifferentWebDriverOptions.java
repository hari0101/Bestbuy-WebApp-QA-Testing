package testdrivendevelop;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DifferentWebDriverOptions {
	
	@Test
	public void setuptest(ITestContext context) {
		
		this.getParameter(context);
		
	}
	
	
	
	
	private void getParameter(ITestContext context) {
		String browser = context.getCurrentXmlTest().getParameter("Browser");
		String browser1 = context.getCurrentXmlTest().getParameter("headless");
		String browser2 = context.getCurrentXmlTest().getParameter("disableGPU");
		String browser3 = context.getCurrentXmlTest().getParameter("AutomationControlInfo");
		String browser4 = context.getCurrentXmlTest().getParameter("disableNotification");
		String browser5 = context.getCurrentXmlTest().getParameter("incognito");
		
		System.out.println(browser);
		System.out.println(browser1);
		System.out.println(browser2);
		System.out.println(browser3);
		System.out.println(browser4);
		System.out.println(browser5);
	}
		

}
