package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeClass {

	public static void main(String[] args) throws Throwable {

		
		 WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.get("https://demo.actitime.com/login.do");
//		 driver.findElement(By.id("username")).sendKeys("admin");
//		 Thread.sleep(2000);
//		 driver.findElement(By.name("pwd")).sendKeys("manager");
//		 Thread.sleep(2000);
//		 driver.findElement(By.id("loginButton")).click();
		 driver.findElement(By.partialLinkText("actiTIME")).click();
		 
	}

}
