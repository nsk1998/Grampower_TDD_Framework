package com.grampower.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class dashBoardPage {
	
	//1. local driver initialization : 
	WebDriver ldriver;
	
	
	//2. Construction Initialization with remote driver and PageFactory
	public dashBoardPage(WebDriver rdriver) {
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//3. WebElements Initializations : 
	
	

	//Identifying Elements
	@FindBy (xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//*[@value='LOG IN']")
	private WebElement login;
	
	@FindBy(xpath = "//*[text()='Later']")
	private WebElement alert_popup;
	
	@FindBy(xpath = "//*[@id='ul_assigned_list']")
	private WebElement recently_assigned_user;
	
	@FindBy(xpath="//*[text()='Later']")
	private WebElement hoverelement; 
	
	//4. Method Creation According to relative action of webElements
	
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
	
	}

	public String getTitleOfPage()
	{
		String titleofpage = ldriver.getTitle();
		
		return titleofpage;
	}

	
	public void handlePopup() throws InterruptedException {
		
		//ldriver.manage().deleteAllCookies();
		
		alert_popup.click();
		
//		Thread.sleep(100);
//		
//		ldriver.navigate().refresh();
//	
//		//alert_popup.click();
		
		
		

	}

	public void recentlyAssignedUsers() throws InterruptedException {
		
		Thread.sleep(100);
		
		// Get all text within the element
		String allText = recently_assigned_user.getText();
		
		System.out.println(allText);

		// Split the text if needed
		String[] textLines = allText.split("\n"); // Split by newline character

		// Process and print each line of text
		for (String line : textLines) {
		    System.out.println(line);
		}


	}


}



