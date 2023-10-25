package com.grampower.testcases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.grampower.utilities.ReadExcelFile;

public class TC_DashboardPageTest extends BaseClass{
	

	@Test(priority = 1)
	public void dashLogin() throws InterruptedException
	{
		LoginGramPower.Sendusername();
		
		logger.info("Entered Username");
		
		LoginGramPower.Sendpassword();
		
		logger.info("Entered password");
		
		LoginGramPower.ClickOnLogin();
		
		logger.info("Click on Sign In button");
		
	}
	
	@Test(priority = 2)
	public void dashHandlePopup() throws InterruptedException {

		//	    // Create a WebDriverWait instance with a specific timeout
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    // Locate the popup element using its locator
//	    By popupLocator = By.xpath("//*[text()='Later']"); // Replace with the actual locator of the popup element
//
//	    // Wait for the popup to become clickable (you can use other conditions as needed)
//	    WebElement popupElement = wait.until(ExpectedConditions.elementToBeClickable(popupLocator));
//	    
//		WebElement hoverelement = driver.findElement(By.xpath("//*[text()='Later']"));
//		
//		
//		WebElement hoverelement = driver.findElement(By.xpath("//*[@id='onesignal-slidedown-cancel-button']"));
//		
//		act.click(hoverelement).build().perform();
		
	    // Now you can interact with the popup or perform actions that depend on it
	    DashBoardPage.handlePopup();
		
	    logger.info("Popup window handled properly.");
	}
	
	
	@Test(priority = 3)
	public void recentlyAssigned() throws InterruptedException
	{
		
		DashBoardPage.recentlyAssignedUsers();
		
		logger.info("Total recently assigned user count");
		
	}
}

	
	
	
