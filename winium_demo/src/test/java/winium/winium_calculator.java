package winium;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.By;

import org.openqa.selenium.winium.DesktopOptions;

import org.openqa.selenium.winium.WiniumDriver;

public class winium_calculator {

public static void main(String[] args) throws MalformedURLException, InterruptedException {

	DesktopOptions option = new DesktopOptions();
	option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
	
	WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), option);
	Thread.sleep(5000);

	driver.findElement(By.name("One")).click();

	driver.findElement(By.id("plusButton")).click();

	driver.findElement(By.name("Two")).click();

	driver.findElement(By.name("Equals")).click();

	String output = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");

	System.out.println("Result after addition is: "+output);
driver.quit();
}
}
