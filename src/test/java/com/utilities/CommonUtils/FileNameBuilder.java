package com.utilities.CommonUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



/**
 * FileNameBuilder.class generates multiple file type names such as
 * 	.png
 *  .html
 */

public class FileNameBuilder {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	//null
	
	//=========================================== METHODS ===========================================
	
	/**
	 * @param testType which is actual test class execute
	 * @param browserType is in which browser the test runs. 
	 * @return String reportname
	 * Ex : [ HomePageTest_Report_chrome_01 Jan 25_10:40:39 PM ]
	 */
	public static String getExtentReportName(String testType, String browserType) {
		DateTimeFormatter dtFormat = getDateTimeFormat();
		return testType+"_Report_"+ browserType +"_" + LocalDateTime.now().format(dtFormat)+".html";
		
	}
	
	//Generates names for the screenshots
	public static String getScreenshotName(String testType, String browserType) {
		DateTimeFormatter dtFormat = getDateTimeFormat();
		return testType+"_"+browserType +"_" + LocalDateTime.now().format(dtFormat)+".png";
	}
	
	
	/**
	 * @return DateTimeFormatter with pattern of 01 Jan 2025_10:10:10 PM
	 */
	private static DateTimeFormatter getDateTimeFormat() {
		return DateTimeFormatter.ofPattern("d-MMM-YY_hh-mm-ss_a");
		
	}
	



}
