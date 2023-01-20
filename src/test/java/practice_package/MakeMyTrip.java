package practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MakeMyTrip {
      static{
    	 System.setProperty("webdriver.gecko.driver", "./geckodriver.exe"); 
      }
	public static void main(String[] args) {

		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.className("chNavIcon appendBottom2 chSprite chBuses active")).click();
		
		
		
	}

}
