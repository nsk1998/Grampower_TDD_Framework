package com.grampower.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.grampower.pageobject.validateMeterCount;

public class TC_MetercountTest extends BaseClass {
	
	
	@Test(priority = 1)
	public void verifyLogin() throws InterruptedException {
		
		LoginGramPower.Sendusername();
		logger.info("Entered Username");
		
		LoginGramPower.Sendpassword();
		logger.info("Entered password");
		
		LoginGramPower.ClickOnLogin();
		logger.info("Click on Sign In button");
		
	}
	
	@Test(priority = 1)
	public void validateTitle()
	{
		
		String title = LoginGramPower.getTitleOfPage();
		
		logger.info("Fetched the title of page");
		
		String expected = "Gram Power";
		
		boolean ispresent = title.contains(expected);
		
		Assert.assertEquals(ispresent, true);
		
		logger.info("Title of page has been validated");
		
	}
	
	@Test(priority = 2)
	public void SubscribeTextVerification(){
		
		ValidateMeterCount.subscribePopup();
		logger.info("Meter count should be more than assigned count");
	
		
	}
	
	
	@Test(priority = 3)
	public void verifyMeterCount(){
		
		ValidateMeterCount.compare_meter_count();
		logger.info("Meter count should be more than assigned count");
	
		
	}
	
	

}
