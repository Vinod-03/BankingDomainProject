package practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook {

	public static void main(String[] args) {
		

		
		   WebDriver driver =new ChromeDriver();
		   driver.get("https://facebook.com");
		   driver.findElement(By.xpath("//input[@id='u_0_b_m+']")).sendKeys("vinod");
	}

}
