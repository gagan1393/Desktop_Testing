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

public class JMstudio 
{
	public static WindowsDriver driver = null;
	
	@BeforeMethod
	public void setup()
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app", "C:\\Program Files (x86)\\Exor\\4.0.0.100\\HMIStudio.exe");
		//caps.setCapability("appArguments", "/e");
		caps.setCapability("platformname", "Windows");
		caps.setCapability("deviceName", "WindowsPC");
		
		try {
			driver = new  WindowsDriver(new URL("http://127.0.0.1:4723/"), caps);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	@Test
	public void openstudio() throws InterruptedException
	{
		driver.findElementByName("New").click();
		driver.findElementByName("New").click();
		driver.findElementByName("Project Wizard").click();
		driver.findElementByName("Project Wizard").sendKeys("project33");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	

}
