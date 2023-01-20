package RegisterAccoungtTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplyDebitCardToRegister {

	public static void main(String[] args) throws Throwable {

		
		FileInputStream Fil = new  FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(Fil);
		String url = p.getProperty("url");


		//open  the browser
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		// get the data  from   excel

				FileInputStream exfil = new FileInputStream("./src/test/resources/TestData.xlsx");
				Workbook wb = WorkbookFactory.create(exfil);
				Sheet sh = wb.getSheet("CreateAccount");
      
				

				FileOutputStream fo = new  FileOutputStream("./src/test/resources/TestData.xlsx");

				

		
		
		//  getting data from property file
		String staffid = p.getProperty("staffid");
		String pwd=p.getProperty("password");



		//login to stafflogin
		driver.findElement(By.xpath("//a[.='Staff Login']")).click();

		driver.findElement(By.name("staff_id")).sendKeys(staffid);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("staff_login-btn")).click();


		driver.findElement(By.name("apprvac")).click();

       // Aprove account
		String apno = wb.getSheet("SystemData").getRow(0).getCell(1).getStringCellValue();
		System.out.println(apno);
		driver.findElement(By.name("application_no")).sendKeys(apno);
		driver.findElement(By.name("search_application")).click();

		
		
	}

}
