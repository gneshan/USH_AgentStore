package browserStackIntegration;

import java.util.Hashtable;

import com.ush.agentstore_testcases.ReUsableLibraries;

public class BrowserStackChrome implements Runnable{

	
			public void run() {
			Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
			capsHashtable.put("browser", "chrome");
			capsHashtable.put("browser_version", "97.0");
			capsHashtable.put("os", "Windows");
			capsHashtable.put("os_version", "10");
	    	capsHashtable.put("build", "BrowserStack-Chrome");
			capsHashtable.put("name", "Thread 1");
//			ReUsableLibraries r1 = new ReUsableLibraries();
//			r1.executeTest(capsHashtable);
	    }
	}

//	class BrowserStackChrome implements Runnable {
//		public void run() {
//			Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
//			capsHashtable.put("browser", "safari");
//			capsHashtable.put("browser_version", "14.1");
//			capsHashtable.put("os", "OS X");
//			capsHashtable.put("os_version", "Big Sur");
//			capsHashtable.put("build", "browserstack-build-1");
//			capsHashtable.put("name", "Thread 3");
//			mainTestClass r3 = new mainTestClass();
//	    	r3.executeTest(capsHashtable);
//	  	}
//	}

		


