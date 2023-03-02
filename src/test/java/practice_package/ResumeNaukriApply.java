package practice_package;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ResumeNaukriApply {

	@Test(dataProvider="options")
	public  void naukri(String search)throws Throwable {
		
	   WebDriver driver=new ChromeDriver();
   	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   	   driver.get("https://www.naukri.com/mnjuser/homepage");
   	   driver.findElement(By.id("usernameField")).sendKeys("vinodkumar193vn@gmail.com");
   	   driver.findElement(By.id("passwordField")).sendKeys("Vinod@7228");
   	   driver.findElement(By.xpath("//button[.='Login']")).click();
   	   
   	   driver.findElement(By.xpath("//div[@class=\"btn btn-block btn-large white-text\"]")).click();
   	  //  nithish anna genius  
   	File f=new File("./Automation-QA-Resume-Vinod.pdf");
    String absolute = f.getAbsolutePath();
    System.out.println(absolute); 
   
   	driver.findElement(By.xpath("//input[@class=\"fileUpload waves-effect waves-light btn-large\" and @id=\"attachCV\"]")).sendKeys(absolute);
	Thread.sleep(5000);
	 driver.navigate().back();
	 Thread.sleep(3000);
	   driver.findElement(By.id("qsb-keyskill-sugg")).sendKeys(search);
	   driver.findElement(By.xpath("//button[.='SEARCH']")).click();
	   WebElement circle = driver.findElement(By.className("cir"));
	   Actions act=new Actions(driver);
		act.moveToElement(circle).dragAndDropBy(circle, -258, 0).build().perform();
	   
		String	mainPage=driver.getWindowHandle();
		
		
	 List<WebElement> companies = driver.findElements(By.xpath("//a[contains(text(),'est') and @class='title ellipsis' ]"));
        
	int count= companies.size();
	 
	  
	 for(int i=0;i<count;i++)
	   {
		 companies.get(i).click();
		 Thread.sleep(5000);
		 Set<String> s = driver.getWindowHandles();
		 Iterator<String> itr = s.iterator();
		 itr.next();
		 driver.switchTo().window(itr.next());
		 try
		 {
		 driver.findElement(By.xpath("//button[@class=\"waves-effect waves-ripple btn apply-button\"]")).click();
		 Thread.sleep(3000);
		 driver.close();
		 driver.switchTo().window(mainPage);
		
		 }
		 catch(Exception e)
		 {
			 driver.close();
			 driver.switchTo().window(mainPage);
			 continue;
		 }

 	 }
  		 
	}
	
	  @DataProvider
	  public String[] options()
			  {
		  
		           String arr[]= {"testing","manual testing","java selenium tesing"};
		            
					return arr;
		  
		  
		  
			  }
			  

}
