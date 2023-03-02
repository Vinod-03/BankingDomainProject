package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseClick {

	
	
	
		public static void main(String[] args) {
			  

			  WebDriver driver=new ChromeDriver();
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  driver.get("https://magento2.algolia.com/women.html");
			WebElement e = driver.findElement(By.xpath("//span[text()='Women']/..//span[@class='ui-menu-icon ui-icon ui-icon-caret-1-e']"));
			
			    Actions a=new Actions(driver);
			    a.moveToElement(e).perform();
			    
			    
		}

	
}
