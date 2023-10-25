package com.grampower.utilities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener{
	
	//Enter this by creating new listner tag in testSuite.xml file :
	//   com.mystore.utilities.ExtentListenerClass

	ExtentSparkReporter  htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		ReadConfig readConfig = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm").format(new Date());
		String reportName = "TestReport-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		// htmlReporter =new ExtentSparkReporter("ExtentListenerReport.html");
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine:", "Nilesh's Lenovo");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("browser:", readConfig.getBrowser());
		reports.setSystemInfo("user name:", "Nilesh");
		
		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report");
		htmlReporter.config().setReportName("Grampower Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
	}

	//OnStart method is called when any Test starts.
	public void onStart(ITestContext Result)			//onFinish method is called after all Tests are executed
	{		
		configureReport();
		System.out.println("On Start method invoked....");  		
	}				
	
	
	public void onFinish(ITestContext Result) 			//it is mandatory to call flush method to ensure information is written to the started reporter.

	{		
		System.out.println("On Finished method invoked....");  	
		reports.flush();						
	}		



	// When Test case get failed, this method is called.		
	public void onTestFailure(ITestResult Result) {
	    System.out.println("Name of test method failed: " + Result.getName());
	    test = reports.createTest(Result.getName()); // Create an entry in the HTML report
	    test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.RED));

	    String testName = Result.getName(); // Assuming testName is obtained from the Result object
	    String screenShotPath = "C:/Users/Lenovo/Desktop/Grampower_DataDrivenFramework/Grampower_DataDrivenFramework.zip_expanded/Grampower_DataDrivenFramework/Screenshots" + File.separator;

	    // Create the `dest` file using the destination path and testName
	    File dest = new File(screenShotPath + testName + ".png");

	    // Check if the screenshot file exists before adding it to the report
	    if (dest.exists()) {
	        test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(dest.getAbsolutePath()));
	    }
	}
		

	public void onTestSkipped(ITestResult Result)					
	{		
		System.out.println("Name of test method skipped:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName() ,ExtentColor.YELLOW));
	}			

	// When Test case get Started, this method is called.		

	public void onTestStart(ITestResult Result)					
	{		
		System.out.println("Name of test method started:" + Result.getName() );  		

	}		

	// When Test case get passed, this method is called.		

	public void onTestSuccess(ITestResult Result)					
	{		
		System.out.println("Name of test method sucessfully executed:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
	}		


	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	{		

	}		


	
}

