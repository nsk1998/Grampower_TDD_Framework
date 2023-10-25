package com.grampower.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.grampower.pageobject.dashBoardPage;
//import com.grampower.pageobject.registeredUsersAccount;
import com.grampower.utilities.*;

public class TC_GrampowerLoginPageTest extends BaseClass {

	
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
	
}
