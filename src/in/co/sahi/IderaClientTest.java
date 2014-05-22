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
public class IderaClientTest extends TestCase {
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
	
	public void testIdera() throws ExecutionException, InterruptedException{
		b.navigateTo("http://localhost:9276/login.zul");
		b.textbox("j_username").setValue("WIN-RJ5UEHUAFU7\\Administrator2");
		b.password("j_password").setValue("Control123456");
		b.cell("LOG IN").click();
		do 
		{
			System.out.println("Processing");
		} while (!b.span("The user name or password you entered isn't correct. Contact your SQL Elements administrator to make sure you have permission to access SQL Elements.").exists());
		System.out.println(":: b.span(\"Error message with wrong password or used\") exists ? = " + b.span("The user name or password you entered isn't correct. Contact your SQL Elements administrator to make sure you have permission to access SQL Elements.").exists());
		b.textbox("j_username").setValue("WIN-RJ5UEHUAFU7\\Administrator");
		b.password("j_password").setValue("Control123");
		b.cell("LOG IN").click();
		do 
		{
			System.out.println("Processing");
		} while (!b.link("DASHBOARD").exists());
		System.out.println(":: b.link(\"DASHBOARD\") exists ? = " + b.link("DASHBOARD").exists());
		Thread.sleep(5000);
		
		
		
	}

	
		
	/**
	 * This closes the browser instance, stops the proxy and toggles back the IE proxy settings.
	 * This could be part of your JUnit tearDown.
	 */
	
	public void tearDown(){
		b.close();		
	}
		
}
