package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MicTesting {

	public static void main(String[] args) throws Throwable {
		
		
	
		
		
		
		
		
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disble-notifications");

		WebDriver driver=new ChromeDriver(option);
		driver.get("https://mictests.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.id("mic-launcher")).click();
		
		
		
	}

}
