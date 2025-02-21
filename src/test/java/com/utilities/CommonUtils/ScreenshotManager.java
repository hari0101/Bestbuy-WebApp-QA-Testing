package com.utilities.CommonUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotManager {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
		//NULL
		
	//=========================================== METHODS ===========================================
	
	/**
	 * @param webdriver driver respective to the running driver.
	 * @return byte[] and Base64 type output
	 * 
	 * {@summary : Specifically used for the reports image.png attachments }
	 * {@link ExtentReportManager.class }
	 */
	//byte[] format
	public static byte[] takeScreenshotByte(WebDriver driver) {
		
		TakesScreenshot capture = (TakesScreenshot) driver;
		return capture.getScreenshotAs(OutputType.BYTES);
	}
	
	//Base64 format
	public static String takeScreenshotBase64(WebDriver driver) {
		TakesScreenshot capture = (TakesScreenshot) driver;
		return capture.getScreenshotAs(OutputType.BASE64);
		
	}
	
	//Element-Screenshot
	public static String takeElementScreenshotBase64(WebElement element) {
		return element.getScreenshotAs(OutputType.BASE64);
	}
	
	
	/**
	 * @param respective driver to take the screenshot.
	 * @param testname is whichever test we are running EX : Homepage, LoginTest
	 * @param browserType respective browser in which it takes the screenshot
	 */
	public static void takeScreenshotFile(WebDriver driver, String testname, String browserType) {
		TakesScreenshot capture = (TakesScreenshot) driver;
		File temp = capture.getScreenshotAs(OutputType.FILE);
		
		String imageName = FileNameBuilder.getScreenshotName(testname, browserType);
		File image = new File("./target/TakeScreenshot/" + imageName);
		
		try {
			FileHandler.copy(temp, image);
		} 
		catch (IOException io) {
			System.out.println("Unable to save the Screenshot in path : " + image.getPath());
			io.printStackTrace();
		}
		
		System.out.println("Screenshot Saved Successfully!! [ path : " + image.getPath() + " ]" + "\n");
	}
	
	//Capture specific Webelement screenshot
	public static void takeElementScreenshot(WebElement element, String testname, String browserType) {
		File temp = element.getScreenshotAs(OutputType.FILE);
		
		String imagename = "WebElement_"+FileNameBuilder.getScreenshotName(testname, browserType);
		File image = new File("./target/TakeElementScreenshot/" + imagename);
	
		try {
			FileHandler.copy(temp, image);
		} 
		catch (IOException io) {
			System.out.println("Unable to save the WebElement Screenshot in path : " + image.getPath());
			io.printStackTrace();
		}
		
		System.out.println("WebElement Screenshot Saved Successfully!! [ path : " + image.getPath() + " ]" + "\n");
	}
	
	
}
