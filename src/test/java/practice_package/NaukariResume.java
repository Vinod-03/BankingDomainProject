package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaukariResume {

	public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.naukri.com/mnjuser/homepage");
        driver.findElement(By.id("usernameField")).sendKeys("vinodkumar193vn@gmail.com");
        driver.findElement(By.id("passwordField")).sendKeys("Vinod@7228");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		driver.findElement(By.xpath("//div[text()='UPDATE PROFILE']")).click();
		
		driver.findElement(By.id("attachCV")).click();
	}
}
