package com.ush.agentstore_testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ush.agentstore_pageobjects.AgentStore_LoginPage;

public class Login extends ReUsableLibraries{


	@Test
	public void LoginToAgentStore() {
		//		ReUsableLibraries instance = ReUsableLibraries.getInstance();
		//		WebDriver driver = instance.browserInstance("Chrome");
		AgentStore_LoginPage login = new AgentStore_LoginPage(driver);

		WriteLog().info("Entering username..");
		String uName=rConfig.getUsername();
		login.setUserName(uName);
		WriteLog().info("Clicking on Login button");
		login.clickLoginButton();
	}

}
