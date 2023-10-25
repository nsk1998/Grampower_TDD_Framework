package com.grampower.testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.grampower.pageobject.loginGramPower;
import com.grampower.pageobject.validateMeterCount;
import com.grampower.pageobject.dashBoardPage;
//import com.grampower.pageobject.myAccount;
//import com.grampower.pageobject.registeredUsersAccount;
//import com.grampower.pageobject.searchResultPage;
import com.grampower.utilities.ExtentListenerClass;
import com.grampower.utilities.ReadConfig;
import com.grampower.utilities.ReadExcelFile;
import com.grampower.utilities.takeScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//For configClass[@utilities] mapping with base class
	ReadConfig readConfig = new ReadConfig();
	
	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	
	
	// Util classes object creation - A
	ExtentListenerClass eLClass ;
	takeScreenshot TakeScreenshot;
	ReadExcelFile Excel;
	
	
	
	//Driver & Logger Initialization 
	public static WebDriver driver;
	public static Logger logger;
	//public static WebElement alert_popup;
	
	
	// PageObject classes object creation - A
	
	dashBoardPage DashBoardPage;
	validateMeterCount ValidateMeterCount;
	loginGramPower LoginGramPower;
	Actions act;
//	registeredUsersAccount RegisteredUsersAccount;
//	searchResultPage SearchResultPage;
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup() {
		
		//Browser Selection : 
		
		switch (browser.toLowerCase()) {
			case "chrome" : 
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOption = new ChromeOptions();
			   // chromeOption.addArguments("--remote-allow-origins=*");
			    driver = new ChromeDriver(chromeOption);
				break;		
		
			case "firefox" : 
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
		
			case "msedge" : 
				WebDriverManager.edgedriver().setup();
				EdgeOptions edgeOption = new EdgeOptions();
				//edgeOption.addArguments("--remote-allow-origins=*");
				driver = new EdgeDriver(edgeOption);
				break;	
				
			default : 
				driver = null;
				break;
		}
		
		
		
		// Automation prerequisite
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Logging
		logger = LogManager.getLogger("Grampower");
		
		
		// PageObject classes object creation - B
		
		LoginGramPower = new loginGramPower(driver);
		DashBoardPage = new dashBoardPage(driver);
		ValidateMeterCount = new validateMeterCount(driver);
		act = new Actions(driver);
	//	DashBoardMeterCountPage = new dashBoardMeterCountPage();
	//	DashBoardRecentlyAssigned = new dashBoardRecentlyAssigned(driver);
	//	RegisteredUsersAccount = new registeredUsersAccount(driver);
//		SearchResultPage = new searchResultPage(driver);
		
		
		
		TakeScreenshot = new takeScreenshot();
		eLClass = new ExtentListenerClass() ;
		Excel = new ReadExcelFile();
		
		
		
		//Open URL = 
		driver.get(readConfig.getBaseUrl());
		logger.info("URL opened");

	}
	
	
	
	
	@AfterClass
	public void teardown() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	

}
