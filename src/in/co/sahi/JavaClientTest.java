package in.co.sahi;

import junit.framework.TestCase;
import net.sf.sahi.client.Browser;
import net.sf.sahi.client.ExecutionException;
import net.sf.sahi.config.Configuration;

/**
 * 
 * This is a sample class to get started with Sahi Java.<br/> 
 * Have a look at DriverClientTest.java in sample_java_project dir for more detailed use of APIs.<br/>
 * You need sahi/lib/sahi.jar in your classpath.</br>
 * 
 */
public class JavaClientTest extends TestCase {
	private Browser b;
	private String userDataDirectory;

	/**
	 * This starts the Sahi proxy, toggles the proxy settings on Internet Explorer
	 * and starts a browser instance. This could be part of your setUp method in a JUnit test.
	 * 
	 */
	public void setUp(){
		String sahiBase = "C:\\sahi_pro"; // where Sahi is installed or unzipped
		userDataDirectory = "myuserdata"; 
		Configuration.initJava(sahiBase, userDataDirectory); // Sets up configuration for proxy. Sets Controller to java mode.

		b = new Browser("firefox");	
		b.open();
	}	
	
	public void testGoogle() throws ExecutionException{
		b.navigateTo("http://www.google.com");
		b.textbox("q").setValue("sahi forums");
		b.submit("btnG").click();
		b.waitFor(1000);
		b.link("All Discussions - Sahi Forums").click();
		System.out.println(":: b.link(\"Sign In\").exists() = " + b.link("Sign In").exists());
		System.out.println(":: b.link(\"sign in test2 using near\").exists() = " + b.link("Sign In").near(b.link("Activity")).exists());
		System.out.println(":: b.textbox(\"req_username\").exists() = " + b.textbox("req_username").exists());
		
		
	}

	
	public void testSahiDemoSite(){
		b.navigateTo("http://sahi.co.in/demo/training/");
		b.textbox("user").setValue("test");
		b.password("password").setValue("secret");
		b.submit("Login").click();
		b.textbox("q").setValue("2");
		b.textbox("q[1]").setValue("9");
		b.textbox("q[2]").setValue("4");
		b.button("Add").click();	
		System.out.println(":: b.textbox(\"total\").value()=" + b.textbox("total").value());
	}
	
	/**
	 * This closes the browser instance, stops the proxy and toggles back the IE proxy settings.
	 * This could be part of your JUnit tearDown.
	 */
	
	public void tearDown(){
		b.close();		
	}
		
}
