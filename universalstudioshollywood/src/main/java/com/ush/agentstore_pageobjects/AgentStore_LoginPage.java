package com.ush.agentstore_pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentStore_LoginPage {

	WebDriver localDriver;


	public AgentStore_LoginPage(WebDriver remoteDriver)
	{
		this.localDriver=remoteDriver;
		PageFactory.initElements(localDriver, this);

	}

	//Username TextBox
	@FindBy(id = "AgentTicketStoreContents_SalesCounselorLogin_TextEmployeeID")
	@CacheLookup
	public WebElement LoginTextBox;
	//Entering the Value in username text box
	public void setUserName(String uName) {
		LoginTextBox.clear();
		LoginTextBox.sendKeys(uName+Keys.TAB);	
	}
	
	
	//LoginButton
	@FindBy(id= "AgentTicketStoreContents_SalesCounselorLogin_EmployeeLogin")
	@CacheLookup
	public WebElement LoginButton;
	//Clicking on Login button
	public void clickLoginButton() {
		LoginButton.click();	
	}

}