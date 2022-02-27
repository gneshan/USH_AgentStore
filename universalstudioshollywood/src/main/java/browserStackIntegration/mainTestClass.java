package browserStackIntegration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mainTestClass {
	

	public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");//"anon672872";
	public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_USERNAME");//"LdQ6kbajmxekeqnzifbs";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static void main(String[] args) throws Exception {
		Thread ChromeThread = new Thread(new BrowserStackChrome());
		ChromeThread.start();
		Thread FireFoxThread = new Thread(new BrowserStackFirefox());
		FireFoxThread.start();
		Thread SafariThread = new Thread(new BrowserStackSafari());
		SafariThread.start();
}
	
	public void executeTest(Hashtable<String, String> capsHashtable) {
		String key;
		DesiredCapabilities caps = new DesiredCapabilities();
		// Iterate over the hashtable and set the capabilities
		Set<String> keys = capsHashtable.keySet();
		Iterator<String> itr = keys.iterator();
		while (itr.hasNext()) {
       		key = itr.next();
       		caps.setCapability(key, capsHashtable.get(key));
       		
//       		System.out.println(key);
//       		System.out.println(capsHashtable.get(key));       		
    	}
		
    	WebDriver driver;
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			// Searching for 'BrowserStack' on google.com
			driver.get("https://www.universalstudioshollywood.com/web/en/us");
////			WebElement element = driver.findElement(By.name("q"));
//			element.sendKeys("BrowserStack");
//			element.submit();
			// Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'BrowserStack'
			WebDriverWait wait = new WebDriverWait(driver, 5);
	    	try {
				wait.until(ExpectedConditions.titleContains("Universal Studios Hollywood"));
				jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
	    	}
	    	catch(Exception e) {
	    		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
	    	}
	    	System.out.println(driver.getTitle());
	    	driver.quit();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}