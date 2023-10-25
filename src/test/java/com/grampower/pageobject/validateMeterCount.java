package com.grampower.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class validateMeterCount {

	WebDriver ldriver;
	
	public validateMeterCount(WebDriver rdriver) {
		ldriver= rdriver;
		
		PageFactory.initElements(rdriver, this);
		}
	


	//==========================================================
	
	//Identifying Elements
	@FindBy (xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//*[@value='LOG IN']")
	private WebElement login;
	
	By elementLocator = By.xpath("//*[@id='onesignal-slidedown-dialog']");
	WebElement popupelement = ldriver.findElement(elementLocator);
	
	//Identifying Elements
	@FindBy (xpath="//*[@class='pull-right']")
	private WebElement total_meter_count;
	
	@FindBy (xpath="//*[@id='div_assign_count']")
	private WebElement assigned_meter_count;
	
	//==========================================================
	
	//Actions to Methods =>
	public void Sendusername() {
		username.click();
		
		username.sendKeys("automationuser");
		
		password.click();

	}
	
	public void Sendpassword() {
		
		password.click();
		
		password.sendKeys("grampower");
		
		password.click();
		
	}
	
	public void ClickOnLogin(){
		
		login.click();
		
		ldriver.navigate().refresh();
		
	}
	
	public String getTitleOfPage()
	{
		String titleofpage = ldriver.getTitle();
		
		return titleofpage;
	}
	
	public void subscribePopup(){
			
			ldriver.navigate().refresh();
		
			popupelement.click();
		
		
		
	}
	

	public void compare_meter_count() {
			
			String meterCountText = total_meter_count.getText();
			System.out.println("Total Meter Count: " + meterCountText);
			
			String assignedmeterCountText = assigned_meter_count.getText();
			System.out.println("Assigned Meter Count: " + assignedmeterCountText);
			
		    int totalMeterCount = Integer.parseInt(meterCountText);
		    int assignedMeterCount = Integer.parseInt(assignedmeterCountText);
		    
		    if (totalMeterCount < assignedMeterCount) {
	        System.out.println("Total Meter Count is greater than Assigned Meter Count.");
		    }
		    else if (totalMeterCount == assignedMeterCount) {
	        System.out.println("Total Meter Count is equal to Assigned Meter Count.");
		    } 
		    else {
	        System.out.println("Total Meter Count is less than Assigned Meter Count.");
		    
		    }

		}

	}


