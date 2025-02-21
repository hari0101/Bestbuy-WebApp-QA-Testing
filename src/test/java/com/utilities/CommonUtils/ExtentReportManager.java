package com.utilities.CommonUtils;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @version ExtentReports 5.1.2
 * 
 * {@summary : ExtentReportManager.class implements the ITestListener for generating reports parallelly. 
 * 		
 * 	ExtentReportManager.class is a Listener class must run with the testNG file for report generation.
 * 
 * }
 */
public class ExtentReportManager implements ITestListener {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	private ExtentSparkReporter sparkUI;
	private ExtentReports report;
	private ExtentTest test;
	private File extentReportPath;
	
	private Properties property;
	private static final String PROPERTIESFILE = "config";
	
	private String classname;
	//=========================================== METHODS ===========================================
	
	
	// File location : /Luma-WebApplication/target/Extent-Reports/extentreports.html
	@Override
	public void onStart(ITestContext context) {
		
		property = ConfigProperties.loadProperties(PROPERTIESFILE);
		
		String machine = context.getCurrentXmlTest().getParameter("Machine");
		String OS = context.getCurrentXmlTest().getParameter("OS");
		String browserName = context.getCurrentXmlTest().getParameter("Browser");
		
		extentReportPath = new File("./target/Extent-Reports/" + FileNameBuilder.getExtentReportName("Smaple", browserName));
		sparkUI = new ExtentSparkReporter(extentReportPath);
		sparkUI.config().setTheme(Theme.STANDARD);
		sparkUI.config().setDocumentTitle(property.getProperty("DocumentTitle"));
		sparkUI.config().setReportName(property.getProperty("ReportName"));
		
		report = new ExtentReports();
		report.attachReporter(sparkUI);
		
		if(machine.equalsIgnoreCase("Remote")) {
			
			report.setSystemInfo("MACHINE ", machine);
			report.setSystemInfo("IP ADDRESS ", property.getProperty("hostURI"));
			report.setSystemInfo("OPERATING SYSTEM ", OS);
			report.setSystemInfo("BROWSER NAME ", browserName);
			report.setSystemInfo("WEBSITE URL", property.getProperty("URL"));
			report.setSystemInfo("AUTHORNAME", property.getProperty("Authorname"));
		}
		else {
					report.setSystemInfo("MACHINE ", machine);
					report.setSystemInfo("OPERATING SYSTEM ", System.getProperty("os.name"));
					report.setSystemInfo("OPERATING SYSTEM VERSION ", System.getProperty("os.version"));
					report.setSystemInfo("WEBSITE URL", property.getProperty("URL"));
					report.setSystemInfo("BROWSER NAME ", browserName);
					report.setSystemInfo("AUTHORNAME", property.getProperty("Authorname"));                                     
		}	

		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			report.setSystemInfo("Groups", includedGroups.toString());
		}		
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test = report.createTest(result.getTestClass().getName() +" : "+ result.getName());
		test.assignCategory(result.getMethod().getGroups());
		
		//test.assignAuthor(property.getProperty("Authorname"));
		//test.assignDevice(property.getProperty("Device"));
		classname = result.getTestClass().getName();
		test.log(Status.PASS, result.getName()+ " TEST PASSED!");
		
	}
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getTestClass().getName() +" : "+ result.getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+ " TEST FAILED!");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		//Attach-Screenshots
		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("Driver");
		if(driver != null) {
			String imageformat = ScreenshotManager.takeScreenshotBase64(driver);
			test.fail(result.getName() + " : Failed Image", MediaEntityBuilder.createScreenCaptureFromBase64String(imageformat).build());
		}
		
	}
	
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getTestClass().getName() +" : "+ result.getName());
		test.assignCategory(result.getMethod().getGroups());
		
		//test.assignAuthor(property.getProperty("Authorname"));
		//test.assignDevice(property.getProperty("Device"));
		test.log(Status.SKIP, result.getName()+ " TEST SKIPPED!");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
	}
	
	
	@Override
	public void onFinish(ITestContext context) {
		
		String browserType = context.getCurrentXmlTest().getParameter("Browser");

		report.flush();
		
		this.renameReportFile(extentReportPath, browserType);
//		//Opens report after the report created.
//		try {
//			Desktop.getDesktop().browse(extentReportPath.toURI());
//		} catch (IOException io) {
//			System.out.println("HTML ExtentReport Not Found!!" + io.getMessage());
//		}
	}
	
	
	//rename the file
	private void renameReportFile(File oldfile, String browserType) {
		
		String testClassName = this.classname;
		int index = testClassName.indexOf(".");
		String result = testClassName.substring(index + 1, testClassName.length());
		
		extentReportPath = new File("./target/Extent-Reports/" + FileNameBuilder.getExtentReportName(result, browserType));
		
		oldfile.renameTo(extentReportPath);
	}
	
	
	
}
