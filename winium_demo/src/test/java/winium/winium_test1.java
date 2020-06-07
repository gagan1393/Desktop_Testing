package winium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class winium_test1 
{
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("E:\\Exor_Builds\\4.1.0\\JMobile Suite 4.1.0.29\\HMIStudio.exe");
		
		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), option);
		Thread.sleep(5000);
		driver.findElement(By.name("New")).click();
		System.out.println("Created new project");
		Thread.sleep(2000);
		WebElement projectwizard = driver.findElement(By.name("Project Wizard"));
		String newproject = projectwizard.getAttribute("windowHandle");
		driver.switchTo().window(newproject);
		driver.findElement(By.className("Qt5QWindowIcon")).click();
		driver.findElement(By.className("Qt5QWindowIcon")).clear();
		driver.findElement(By.className("Qt5QWindowIcon")).sendKeys("bdcdb");
		
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
