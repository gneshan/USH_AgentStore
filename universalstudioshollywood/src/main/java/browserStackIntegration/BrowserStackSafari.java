package browserStackIntegration;

import java.util.Hashtable;

public class BrowserStackSafari implements Runnable{
	
	public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "safari");
		capsHashtable.put("browser_version", "14.1");
		capsHashtable.put("os", "OS X");
		capsHashtable.put("os_version", "Big Sur");
		capsHashtable.put("build", "BrowserStack-Safari");
		capsHashtable.put("name", "Thread 3");
		mainTestClass r3 = new mainTestClass();
    	r3.executeTest(capsHashtable);
  	}

}
