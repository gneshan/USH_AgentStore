package browserStackIntegration;

import java.util.Hashtable;

public class BrowserStackFirefox implements Runnable {
	

	public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "firefox");
		capsHashtable.put("browser_version", "97.0");
		capsHashtable.put("os", "Windows");
		capsHashtable.put("os_version", "10");
		capsHashtable.put("build", "browserstack-Firefox");
		capsHashtable.put("name", "Thread 2");
		mainTestClass r2 = new mainTestClass();
    	r2.executeTest(capsHashtable);
  	}


}
