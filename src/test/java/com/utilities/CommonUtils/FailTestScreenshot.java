package com.utilities.CommonUtils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class FailTestScreenshot implements ITestListener  {

	//==================================== FIELDS & CONSTRUCTOR ====================================
	private WebDriver driver;
	
	//=========================================== METHODS ===========================================	
	
	@Override
	public void onTestFailure(ITestResult result) {
		String browserType = result.getTestContext().getCurrentXmlTest().getParameter("Browser");
		//Get the driver instance from the actual BaseClass
		driver = (WebDriver) result.getTestContext().getAttribute("Driver");
		
		//Screenshot method
		TakesScreenshot capture = (TakesScreenshot) driver;
		String imagename = "Failed_" + FileNameBuilder.getScreenshotName(result.getName(), browserType);
		File temp = capture.getScreenshotAs(OutputType.FILE);
		
		File failImagepath = new File("./target/TakeFailScreenshot/" + imagename);
		try {
			FileHandler.copy(temp, failImagepath);
		} 
		catch (IOException io) {
			System.out.println("Unable to save the Fail Test Screenshot in path : " + failImagepath.getPath());
			io.printStackTrace();
		}
		System.out.println("FAILED Test Screenshot Saved Successfully!! [ path : " + failImagepath.getPath() + " ]" + "\n");
	}

}
