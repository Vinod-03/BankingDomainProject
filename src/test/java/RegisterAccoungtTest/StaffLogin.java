package RegisterAccoungtTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class StaffLogin {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
         WebDriver driver=new ChromeDriver();
    		   driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
    		   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    		     FileInputStream file = new FileInputStream("./src/test/resources/CommonData.properties");
    		   
    		    Properties p=new Properties();
    		     p.load(file);
    		     String staffid = p.getProperty("staffid");
    		     String pwd=p.getProperty("password");
    		     
    		     
    		     
    		     
    		     driver.findElement(By.xpath("//a[.='Staff Login']")).click();
    		     
               driver.findElement(By.name("staff_id")).sendKeys(staffid);
               driver.findElement(By.name("password")).sendKeys(pwd);
               driver.findElement(By.name("staff_login-btn")).click();
               
               
               driver.findElement(By.name("apprvac")).click();
               
               FileInputStream exfile = new FileInputStream("./src/test/resources/TestData.xlsx");
              Workbook wb = WorkbookFactory.create(exfile);
            String apno = wb.getSheet("CreateAccount").getRow(11).getCell(1).getStringCellValue();
                System.out.println(apno);
               driver.findElement(By.name("application_no")).sendKeys(apno);
               driver.findElement(By.name("search_application")).click();
               
           String actualrs = driver.findElement(By.xpath("//tbody/tr/th[.='Mobile']/../../tr[2]/td[5]")).getText();
           
         String expectedrs = wb.getSheet("CreateAccount").getRow(1).getCell(1).getStringCellValue();
         
         System.out.println(expectedrs);
         
         if(actualrs.contains(expectedrs))
         {
        	 
        	 
        	 System.out.println("test  case  is passed");
        	 
         }
         else
         {
        	 System.out.println("test  case  is failed");

         }

	}

}
