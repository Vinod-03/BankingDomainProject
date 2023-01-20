package RegisterAccoungtTest;

import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class OpenAccountToPendingAccount {

	public static void main(String[] args) throws Throwable {
		//  Properties files data 
		FileInputStream Fil = new  FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(Fil);
		String url = p.getProperty("url");


		//open  the browser
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//li[.='Open Account']")).click();

		//  to get a find multiple data from application

		ArrayList<String> list = new ArrayList<String>();
		list.add("name");
		list.add("mobile");
		list.add("email");
		list.add("landline");
		//list.add("dob");
		list.add("pan_no");
		list.add("citizenship");
		list.add("homeaddrs");
		list.add("officeaddrs");
		list.add("pin");
		list.add("arealoc");
		list.add("nominee_name");
		list.add("nominee_ac_no");


		// get the data  from   excel

		FileInputStream exfil = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(exfil);
		Sheet sh = wb.getSheet("CreateAccount");

		// Copying the excel data and sending to the application
		for(int i=0;i<=sh.getLastRowNum();i++)
		{
			String data = sh.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.name(list.get(i))).sendKeys(data);

		}

		//  getting date from the excel;


		Sheet sh1 = wb.getSheet("date");
		String dd = sh1.getRow(0).getCell(1).getStringCellValue(); 
		String month=sh1.getRow(1).getCell(1).getStringCellValue();
		String year=sh1.getRow(2).getCell(1).getStringCellValue();

		String date = dd+"-"+month+"-"+year;
		driver.findElement(By.name("dob")).click();
		driver.findElement(By.name("dob")).sendKeys(date);

		//  find elements for select class
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("gender");
		list2.add("state");
		list2.add("city");
		list2.add("acctype");

		//data from excel for find elements
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("Male");
		list3.add("Washington");
		list3.add("San Diego");
		list3.add("Saving");


		//matching findelements data with  excel data and adding to select class
		for(int i=0;i<list2.size();i++)
		{
			WebElement data = driver.findElement(By.name(list2.get(i)));

			Select sel=new Select(data); 
			sel.selectByValue(list3.get(i));

		}




		driver.findElement(By.name("submit")).click();
		driver.findElement(By.name("cnfrm-submit")).click();


		//  alertb pop
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		al.accept();
		// System.out.println(text);  
		//   getting the application no  from   whole text	  
		char ch[]=text.toCharArray();
		char ch1[]=new char[9];
		int j=0;
		for (int i = 0; i < ch.length; i++) {

			if(ch[i]>='0'&&ch[i]<='9') {
				ch1[j]=(ch[i]);
				j++;
			} 
		}
		String str= new String (ch1);
		System.out.println(str);



		//  pasting the application no in excel
		wb.getSheet("SystemData").getRow(0).createCell(1).setCellValue(str);




		FileOutputStream fo = new  FileOutputStream("./src/test/resources/TestData.xlsx");

		wb.write(fo);




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

		driver.findElement(By.name("approve_cust")).click();

		WebDriverWait wait=new WebDriverWait(driver,10 );
		wait.until(ExpectedConditions.alertIsPresent());

		Alert ale = driver.switchTo().alert();

		String text1 = ale.getText();
		ale.accept();
		System.out.println(text1);


		char[] ach = text1.toCharArray();
		String astr="";
		for(int i=0;i<ach.length;i++)
		{
			if(ach[i]>='0' && ach[i]<='9')
			{
				astr=astr+ach[i];
			}
		}

		System.out.println(astr);

		String acstr = astr;
		wb.getSheet("SystemData").getRow(1).createCell(1).setCellValue(acstr);

		FileOutputStream fos = new  FileOutputStream("./src/test/resources/TestData.xlsx");

		wb.write(fos);

		driver.findElement(By.name("home")).click();


		driver.findElement(By.name("credit_cust_ac")).click();

		String acno = wb.getSheet("SystemData").getRow(1).getCell(1).getStringCellValue();


		driver.findElement(By.name("customer_account_no")).sendKeys(acno);
		driver.findElement(By.name("credit_amount")).sendKeys("10000");
		driver.findElement(By.name("credit_btn")).click();

		driver.switchTo().alert().accept();

		driver.findElement(By.name("logout_btn")).click();

		driver.findElement(By.xpath("//a[.='Home']")).click();

		driver.findElement(By.xpath("//li[.='Apply Debit Card']")).click();





		String acnoname = wb.getSheet("CreateAccount").getRow(0).getCell(1).getStringCellValue();

		//date
		String panno = wb.getSheet("CreateAccount").getRow(4).getCell(1).getStringCellValue();
		String Mno = wb.getSheet("CreateAccount").getRow(1).getCell(1).getStringCellValue();
		String acnono = wb.getSheet("SystemData").getRow(1).getCell(1).getStringCellValue();


		driver.findElement(By.name("holder_name")).sendKeys(acnoname);
		driver.findElement(By.name("dob")).click();
		driver.findElement(By.name("dob")).sendKeys(date);
		driver.findElement(By.name("pan")).sendKeys(panno);
		driver.findElement(By.name("mob")).sendKeys(Mno);
		driver.findElement(By.name("acc_no")).sendKeys(acnono);




		driver.findElement(By.name("dbt_crd_submit")).click();

		WebDriverWait wait1=new WebDriverWait(driver,10 );
		wait1.until(ExpectedConditions.alertIsPresent());

		Alert dal = driver.switchTo().alert();
		String dbno = dal.getText();
		//System.out.println(dbno);

		char dbch[]=dbno.toCharArray();	         	
		String dbtno="";
		String pinno="";
		int count=0;

		for(int i=0;i<dbch.length;i++)
		{
			if(dbch[i]>='0' && dbch[i]<='9')
			{

				if(count<12)
				{


					dbtno=dbtno+dbch[i];
					count++;

				}
				else {
					pinno=pinno+dbch[i];
				}

			}


		}
		System.out.println(dbtno);
		System.out.println(pinno);



		wb.getSheet("SystemData").getRow(2).createCell(1).setCellValue(dbtno);
		wb.getSheet("SystemData").getRow(3).createCell(1).setCellValue(pinno);


		FileOutputStream fose = new  FileOutputStream("./src/test/resources/TestData.xlsx");

		wb.write(fose);

		dal.accept();



		driver.findElement(By.xpath("//a[.='Home']")).click();


		Actions a1=new Actions(driver);




		WebElement inter = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		a1.moveToElement(inter).perform();

		driver.findElement(By.xpath("//li[.='Register']")).click();

		String accname = wb.getSheet("CreateAccount").getRow(0).getCell(1).getStringCellValue();
		String accnumber = wb.getSheet("SystemData").getRow(1).getCell(1).getStringCellValue();
		String debitno = wb.getSheet("SystemData").getRow(2).getCell(1).getStringCellValue();
		String debitpin = wb.getSheet("SystemData").getRow(3).getCell(1).getStringCellValue();	
		String registermno = wb.getSheet("CreateAccount").getRow(1).getCell(1).getStringCellValue();
		String pno = wb.getSheet("CreateAccount").getRow(4).getCell(1).getStringCellValue();     


		driver.findElement(By.name("holder_name")).sendKeys(accname);
		driver.findElement(By.name("accnum")).sendKeys(accnumber);
		driver.findElement(By.name("dbtcard")).sendKeys(debitno);
		driver.findElement(By.name("dbtpin")).sendKeys(debitpin);
		driver.findElement(By.name("mobile")).sendKeys(registermno);
		driver.findElement(By.name("pan_no")).sendKeys(pno);
		driver.findElement(By.name("dob")).click();
		driver.findElement(By.name("dob")).sendKeys(date);
		driver.findElement(By.name("last_trans")).sendKeys("10000");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("cnfrm_password")).sendKeys("password");

		driver.findElement(By.name("submit")).click();



		Alert cidal = driver.switchTo().alert();
		String text3 = cidal.getText();
		cidal.accept();
		System.out.println(text3);



		char[]  ch3=text3.toCharArray();
		String str4="";

		for(int i=0;i<ch3.length;i++)
		{
			if(ch3[i]>='0' && ch3[i]<='9')
			{
				str4=str4+ch3[i];
			}


		}

		System.out.println(str4);

		wb.getSheet("SystemData").getRow(4).createCell(1).setCellValue(str4);



		driver.findElement(By.xpath("//a[.='Home']")).click();


		Actions a2=new Actions(driver);




		WebElement interban = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		a1.moveToElement(interban).perform();

		driver.findElement(By.xpath("//li[.='Login ']")).click();


		String cid = wb.getSheet("SystemData").getRow(4).getCell(1).getStringCellValue();

		driver.findElement(By.name("customer_id")).sendKeys(cid);
		driver.findElement(By.name("password")).sendKeys("password");


		driver.findElement(By.name("login-btn")).click();


		driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();

		driver.findElement(By.name("add_beneficiary")).click();


		driver.findElement(By.name("beneficiary_name")).sendKeys("vino");
		driver.findElement(By.name("beneficiary_acno")).sendKeys("1011821011632");
		driver.findElement(By.name("Ifsc_code")).sendKeys("1011");
		WebElement actype = driver.findElement(By.name("beneficiary_acc_type"));
		Select s1=new Select(actype);
		s1.selectByValue("Saving");

		driver.findElement(By.name("add_beneficiary_btn")).click();

		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
		WebElement beni = driver.findElement(By.name("beneficiary"));
		Select s3=new Select(beni);
		s3.selectByIndex(1);

		driver.findElement(By.name("trnsf_amount")).sendKeys("10000");

		driver.findElement(By.name("fnd_trns_btn")).click();



		String t = driver.findElement(By.xpath(" //label[@class='OTP_msg']")).getText();
		System.out.println(t);		        



		char ch5[]=t.toCharArray();
		String str5="";
		String str6="";
		int count1=0;

		for(int i=0;i<ch5.length;i++)
		{
			if(ch5[i]>='0'  && ch5[i]<='9')
			{


				if(count1<10)
				{
					str5=str5+ch5[i];
					count1++;
				}
				else
					str6=str6+ch5[i];
			}

		}


		System.out.println(str5);
		System.out.println(str6);


		driver.findElement(By.name("otpcode")).sendKeys(str6);
		driver.findElement(By.name("verify-btn")).click();



		String suces = driver.switchTo().alert().getText();

		System.out.println(suces);












	}	
}

