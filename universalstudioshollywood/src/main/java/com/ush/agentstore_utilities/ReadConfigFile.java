package com.ush.agentstore_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

//import org.testng.annotations.Test;

public class ReadConfigFile {

	Properties prop;

	public ReadConfigFile() {

		try {
			File file = new File("./config.properties");
			FileInputStream fis;
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	public String getAgentStoreUrl() {
		String AGLink=prop.getProperty("AgentStoreLink");
		return AGLink;

	}

	public String getUsername() {
		String uname= prop.getProperty("Username");
		return uname;
	}


	public String getBrowserStackUsername() {
		String BSuname= prop.getProperty("BSUsername");
		return BSuname;
	}

	
	public String getBrowserStackAccessKey() {
		String BSAccessKey= prop.getProperty("BSAccessKey");
		return BSAccessKey;
	}
	
	public String getDriverPath() {
		String drPath=prop.getProperty("DriverPath");
		return drPath;
	}

//	@Test
//	public void test() {
//		
//		System.out.println(getBrowserStackUsername());
//		System.out.println(getAgentStoreUrl());
//		System.out.println(getUsername());
//		System.out.println(getBrowserStackAccessKey());
//		System.out.println(getDriverPath());
//		
//	}


}
