package winappdriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class notespad 
{
	public static WindowsDriver driver = null;
	
	@BeforeMethod
	public void setup()
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		caps.setCapability("platformname", "Windows");
		caps.setCapability("deviceName", "WindowsPC");
		
		try {
			driver = new  WindowsDriver(new URL("http://127.0.0.1:4723/"), caps);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test(priority = 0)
	public void checkHelpaboutnowTest() throws InterruptedException
	{
		driver.findElementByName("Help").click();
		driver.findElementByName("About Notepad").click();
		driver.findElementByName("OK").click();
		
	}
	
	@Test(priority = 1)
	public void sendtextTest()
	{
		driver.findElementByName("Text Editor").sendKeys("Hello this is window Testing and I am enjoying very much");
		driver.findElementByName("Text Editor").clear();
	}
	
	@Test(priority = 2)
	public void EditTest() throws InterruptedException
	{
		driver.findElementByName("Edit").click();
		driver.findElementByAccessibilityId("26").click();
		String value = driver.findElementByName("Text Editor").getAttribute("Value.Value");
		System.out.println(value);
		Assert.assertTrue(value.contains("30-05-2020"));
		Thread.sleep(2000);
	}
	
	

}
