package practice_package;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.banking.generiutilities.ExcelUtility;

public class DeleteCust {
	static {
		System.setProperty("webdriver.edge.driver", "./msedgedriver.exe");
	}
	public static void main(String[] args) throws Throwable {

		ExcelUtility exLib = new ExcelUtility();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    HashMap<String, String> ha = new HashMap<String, String>();
		  
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/delete_customer.php");
		driver.findElement(By.name("staff_id")).sendKeys("210001");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("staff_login-btn")).click();
		
//		driver.findElement(By.name("viewdet")).click();
//		
//        List<WebElement> cname = driver.findElements(By.xpath("//tbody/tr/th[1]/../../tr/td[2]"));
//        List<WebElement> cid = driver.findElements(By.xpath("//tbody//tr/th[3]/../..//tr/td[3]"));
//        List<WebElement> cacc = driver.findElements(By.xpath("//tbody//tr/th[4]/../../tr/td[4]"));
//        
//        
//       
//
//		for( int i=0;i<1500;i++)
//		{
//			   	
//			String t1 = cname.get(i).getText();
//			       String t = cid.get(i).getText();
//			       String t3 = cacc.get(i).getText();
//			System.out.println(t1+" "+t+" "+t3);
//			  exLib.setExcelData("Sheet3", i, 2, t3);
//			 
//			
//		}
		
		
		
		driver.findElement(By.name("del_cust")).click();
		for( int i=0;i<700;i++)
		{
			driver.findElement(By.name("Cust_ac_no")).sendKeys(exLib.readDataFromExcel("Sheet3", i, 2));
			driver.findElement(By.name("Cust_ac_Id")).sendKeys(exLib.readDataFromExcel("Sheet3", i, 1));
			driver.findElement(By.name("reason")).sendKeys("aa");
			driver.findElement(By.name("delete")).click();
			Thread.sleep(1000);
			try
			{
			driver.switchTo().alert().accept();
			}
			catch(Exception e)
			{
				
			}
		}
           
        	   
        	   
		
           
				
				
	}

}
