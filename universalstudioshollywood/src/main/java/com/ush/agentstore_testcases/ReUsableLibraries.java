package com.ush.agentstore_testcases;

import java.time.Duration;
import java.util.function.Function;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ush.agentstore_pageobjects.AgentStore_LoginPage;
import com.ush.agentstore_utilities.ReadConfigFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReUsableLibraries {

	ReadConfigFile rConfig=new ReadConfigFile();
	//private static ReUsableLibraries instance = null;//Singleton
	//private WebDriver driver; //For Singleton
	public WebDriver driver;
	public WebDriverWait wait;
	public final String USERNAME = rConfig.getBrowserStackUsername();
	public final String AUTOMATE_KEY = rConfig.getBrowserStackAccessKey();
	public final String BSURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	private Logger logger;
	public DesiredCapabilities caps;
	public String driverPath=rConfig.getDriverPath();

	//For Singleton
	//	private ReUsableLibraries() {
	//		
	//		
	//	}

	//For Singleton
	//	public static ReUsableLibraries getInstance() {
	//		if(instance == null) {
	//			instance = new ReUsableLibraries();
	//			return instance;			
	//		}
	//		return instance;
	//	}




	public Logger WriteLog() {		
		logger = Logger.getLogger("USH_AgentStore");
		PropertyConfigurator.configure("./log4j.properties");
		return logger;
	}

	public void getPageTitle() {
		WriteLog().info("Waiting for Page load....");
		ImplicitWait(30);
		WriteLog().info("Getting the Title");
		driver.getTitle();
	}

	public void ImplicitWait(long secs) {
		WriteLog().info("Implicit Waiting ....");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public void ExplicitWait(long secs, WebElement WebElement) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
		WriteLog().info("Explicit Waiting based on the visibility of webelement....");
		wait.until(ExpectedConditions.visibilityOf(WebElement));
	}

	public void FluentWait(long timeOutSecs, long pollingSecs,  final String Xpath) {

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutSecs))
				.pollingEvery(Duration.ofSeconds(pollingSecs))
				.ignoring(Exception.class);
		WriteLog().info("Explicit Fluent Wait");
		WebElement foo = wait.until(new Function <WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(Xpath));
			}
		});
	}

	//	public void executeTest(Hashtable<String, String> capsHashtable) {
	//		String key;
	//		caps = new DesiredCapabilities();
	//		// Iterate over the hashtable and set the capabilities
	//		Set<String> keys = capsHashtable.keySet();
	//		Iterator<String> itr = keys.iterator();
	//		while (itr.hasNext()) {
	//			key = itr.next();
	//			caps.setCapability(key, capsHashtable.get(key));
	//		}
	//	}
	
	public DesiredCapabilities getCaps(String BrowserName, String browserVersion,String osName, String osVersion,String buildName ) {
		Proxy proxy = new Proxy();
		
		Proxy p=proxy.setHttpProxy("//http://proxy.inbcu.com:7070/proxy.pac");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", BrowserName);//"chrome"
		caps.setCapability("browser_version", browserVersion);//"97.0"
		caps.setCapability("os", osName);//"windows"
		caps.setCapability("os_version", osVersion);//"10"
		caps.setCapability("build", buildName);//"Build# 2.14.8"
		caps.setCapability(CapabilityType.PROXY, p);
	//	caps.setCapability("name", "Thread 1");
		//http://proxy.inbcu.com:7070/proxy.pac
		return caps;
	}

	@Parameters({"Browser"})
	@BeforeMethod
	public void browserInstance(@Optional("Chrome") String Br) {		
		if(Br.equalsIgnoreCase("Chrome"))
		{
			WriteLog().info("Setting up the Chrome driver");			
			//System.setProperty("webdriver.chrome.driver",driverPath);
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
//			WriteLog().info("Defining capabilities...");
//			DesiredCapabilities capabilities=getCaps("Chrome", "latest", "windows", "10", "TestBuild");
//			try {
//				DesiredCapabilities caps = new DesiredCapabilities();
//				caps.setCapability("browser", "chrome");
//				caps.setCapability("browser_version", "97.0");
//				caps.setCapability("os", "Windows");
//				caps.setCapability("os_version", "10");
//				caps.setCapability("build", "BrowserStack-Chrome");
//				caps.setCapability("name", "Thread 1");
//				driver = new RemoteWebDriver(new URL(BSURL), capabilities);
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			WriteLog().info("Entering the URL");
			driver.get(rConfig.getAgentStoreUrl());
			WriteLog().info("Window is maximized");
			driver.manage().window().maximize();
			WriteLog().info("Getting the Window Handle of Login Screen");
			String launchWindow=driver.getWindowHandle();
			WriteLog().info("Login Window handle is " + launchWindow);
			AgentStore_LoginPage login = new AgentStore_LoginPage(driver);
			ExplicitWait(30, login.LoginTextBox );
			System.out.println(driver.getTitle());	
			//return driver;
		}
		else if(Br.equalsIgnoreCase("FireFox"))
		{
			//		Thread ChromeThread = new Thread(new BrowserStackChrome());
			//		ChromeThread.start();
			WriteLog().info("Setting up the Firefox driver");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	

						WriteLog().info("Entering the URL");
						driver.get(rConfig.getAgentStoreUrl());
			
						WriteLog().info("Window is maximized");
						driver.manage().window().maximize();
			
						WriteLog().info("Getting the Window Handle of Login Screen");
						String launchWindow=driver.getWindowHandle();
			
						WriteLog().info("Login Window handle is " + launchWindow);
			//return driver;
		}

		else if(Br.equalsIgnoreCase("IE"))
		{
			//		Thread ChromeThread = new Thread(new BrowserStackChrome());
			//		ChromeThread.start();
			WriteLog().info("Setting up the InternetExplorer driver");
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();	

						WriteLog().info("Entering the URL");
						driver.get(rConfig.getAgentStoreUrl());
			
						WriteLog().info("Window is maximized");
						driver.manage().window().maximize();
			
						WriteLog().info("Getting the Window Handle of Login Screen");
						String launchWindow=driver.getWindowHandle();
			
						WriteLog().info("Login Window handle is " + launchWindow);
			//return driver;
		}

		else if(Br.equalsIgnoreCase("Edge"))
		{
			//		Thread ChromeThread = new Thread(new BrowserStackChrome());
			//		ChromeThread.start();
			WriteLog().info("Setting up the Edge driver");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();	

						WriteLog().info("Entering the URL");
						driver.get(rConfig.getAgentStoreUrl());
			
						WriteLog().info("Window is maximized");
						driver.manage().window().maximize();
			
						WriteLog().info("Getting the Window Handle of Login Screen");
						String launchWindow=driver.getWindowHandle();
			
						WriteLog().info("Login Window handle is " + launchWindow);
			//return driver;
		}

		else if (Br.equalsIgnoreCase("Safari"))
		{
			//		Thread ChromeThread = new Thread(new BrowserStackChrome());
			//		ChromeThread.start();
			WriteLog().info("Setting up the Safari driver");
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();	

						WriteLog().info("Entering the URL");
						driver.get(rConfig.getAgentStoreUrl());
			
						WriteLog().info("Window is maximized");
						driver.manage().window().maximize();
			
						WriteLog().info("Getting the Window Handle of Login Screen");
						String launchWindow=driver.getWindowHandle();
			
						WriteLog().info("Login Window handle is " + launchWindow);
			//return driver;
		}
		//return driver;
	}


	@AfterTest
	public void tearDown() {
		WriteLog().info("Quitting the browser");
		driver.quit();
	}


}
