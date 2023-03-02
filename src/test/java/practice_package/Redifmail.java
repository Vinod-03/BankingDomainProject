package practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Redifmail {

	public static void main(String[] args) {

		   WebDriver driver=new ChromeDriver();
		    driver.get("https://mypage.rediff.com/login/dologin");
		    
		    
		    PomRedifmail ra=new PomRedifmail(driver);
		    ra.getUsernametxt().sendKeys("user");
		    ra.getUsernametxt().sendKeys("password");
		    
		
		
	}

}
