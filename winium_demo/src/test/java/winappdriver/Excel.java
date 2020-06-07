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

public class Excel 
{
	public static WindowsDriver driver = null;
	
	@BeforeMethod
	public void setup()
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app", "Excel");
		caps.setCapability("platformName", "Windows");
		caps.setCapability("appArguments", "/e");
		caps.setCapability("deviceName", "WindowsPC");
		
		try {
			driver = new  WindowsDriver(new URL("http://127.0.0.1:4723/"), caps);
			Assert.assertNotNull(driver);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	@Test
	public void openstudio() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElementByName("File Tab").click();
		driver.findElementByName("New").click();
		driver.findElementByName("Blank workbook").click();
		Thread.sleep(2000);
		driver.findElementByName("\"A\" 1").sendKeys("Name");
		driver.findElementByName("\"B\" 1").click();
		driver.findElementByName("\"B\" 1").sendKeys("class");
		driver.findElementByName("\"C\" 1").click();
		driver.findElementByName("\"C\" 1").sendKeys("section");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	

}
