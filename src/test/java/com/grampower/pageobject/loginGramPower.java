package com.grampower.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class loginGramPower {
	
	WebDriver ldriver;
	
	public loginGramPower(WebDriver rdriver) {
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

}
