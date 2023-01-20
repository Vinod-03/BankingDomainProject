package usinggenericlibcreate;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.banking.generiutilities.ExcelUtility;
import com.banking.generiutilities.FileUtility;
import com.banking.generiutilities.JavaUtility;
import com.banking.generiutilities.WebdriverUtility;

public class CreateAccountTest {


	public static void main(String[] args) throws Throwable {

		WebDriver driver=null;

		//genric lib refernce varaible
		FileUtility fLib = new FileUtility();
		ExcelUtility exLib = new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		JavaUtility jLib = new JavaUtility();

		String url = fLib.getPropertyFileData("url");
		driver=new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(url);

		driver.findElement(By.xpath("//li[.='Open Account']")).click();

		ArrayList<String> list = new ArrayList<String>();
		list.add("name");
		list.add("mobile");
		list.add("email");
		list.add("landline");
		list.add("pan_no");
		list.add("citizenship");
		list.add("homeaddrs");
		list.add("officeaddrs");
		list.add("pin");
		list.add("arealoc");
		list.add("nominee_name");
		list.add("nominee_ac_no");

		int leno = exLib.getRowCount("CreateAccount");

		for(int i=0;i<=leno;i++)
		{

			String data = exLib.readDataFromExcel("CreateAccount", i, 1);
			driver.findElement(By.name(list.get(i))).sendKeys(data);
		}


		String dd = exLib.readDataFromExcel("date", 0, 1);
		String month = exLib.readDataFromExcel("date", 1, 1);
		String year = exLib.readDataFromExcel("date", 2, 1);

		String date = dd+"-"+month+"-"+year;
		driver.findElement(By.name("dob")).click();
		driver.findElement(By.name("dob")).sendKeys(date);

           
         WebElement gender = driver.findElement(By.name("gender"));
	     wLib.select(gender, "Male");
        WebElement state = driver.findElement(By.name("state"));
		wLib.select(state, "Washington");

		WebElement city = driver.findElement(By.name("city"));
		wLib.select(city, "San Diego");

		WebElement acctype = driver.findElement(By.name("acctype"));
		wLib.select(acctype, "Saving");


		driver.findElement(By.name("submit")).click();
		driver.findElement(By.name("cnfrm-submit")).click();


		String aplno = wLib.acceptAlertGetText(driver);

        String str = jLib.aplicationFromText(aplno);
		System.out.println(str);

		exLib.setExcelData("SystemData", 0, 1, str);


		String staffid = fLib.getPropertyFileData("staffid");
		String pwd=fLib.getPropertyFileData("password");


		driver.findElement(By.xpath("//a[.='Staff Login']")).click();

		driver.findElement(By.name("staff_id")).sendKeys(staffid);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("staff_login-btn")).click();


		driver.findElement(By.name("apprvac")).click();


		String apno=exLib.readDataFromExcel("SystemData", 0, 1);
		System.out.println(apno);


		driver.findElement(By.name("application_no")).sendKeys(apno);
		driver.findElement(By.name("search_application")).click();

		String actualrs = driver.findElement(By.xpath("//tbody/tr/th[.='Mobile']/../../tr[2]/td[5]")).getText();

		String expectedrs = exLib.readDataFromExcel("CreateAccount", 1, 1);
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


		String accno = wLib.acceptAlertGetText(driver);
    	 String str1 = jLib.accountFromText(accno);
		System.out.println(str1);
		exLib.setExcelData("SystemData", 1, 1, str1);

		driver.findElement(By.name("home")).click();
		driver.findElement(By.name("credit_cust_ac")).click();
        String acno = exLib.readDataFromExcel("SystemData", 1, 1);

		driver.findElement(By.name("customer_account_no")).sendKeys(acno);
		driver.findElement(By.name("credit_amount")).sendKeys("10000");
		driver.findElement(By.name("credit_btn")).click();
		wLib.acceptAlert(driver);

		driver.findElement(By.name("logout_btn")).click();
        driver.findElement(By.xpath("//a[.='Home']")).click();
        driver.findElement(By.xpath("//li[.='Apply Debit Card']")).click();


		String acnoname = exLib.readDataFromExcel("CreateAccount", 0, 1);
		String panno = exLib.readDataFromExcel("CreateAccount", 4, 1);
		String Mno = exLib.readDataFromExcel("CreateAccount", 1, 1);
		String acnono = exLib.readDataFromExcel("SystemData", 1, 1);
		driver.findElement(By.name("holder_name")).sendKeys(acnoname);
		driver.findElement(By.name("dob")).click();
		driver.findElement(By.name("dob")).sendKeys(date);
		driver.findElement(By.name("pan")).sendKeys(panno);
		driver.findElement(By.name("mob")).sendKeys(Mno);
		driver.findElement(By.name("acc_no")).sendKeys(acnono);




		driver.findElement(By.name("dbt_crd_submit")).click();
		wLib.waitAlertPresent(driver);
		String dbcnopin = wLib.acceptAlertGetText(driver);
        String dbtno = jLib.debitNoFromText(dbcnopin);
	    String pinno = jLib.pinNoFromText(dbcnopin);
		System.out.println(dbtno);
		System.out.println(pinno);

		exLib.setExcelData("SystemData", 2, 1, dbtno);
		exLib.setExcelData("SystemData", 3, 1, pinno);

		driver.findElement(By.xpath("//a[.='Home']")).click();
		
		

		
		
		

		WebElement inter = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		wLib.mousehover(driver, inter);
		driver.findElement(By.xpath("//li[.='Register']")).click();

		String accname = exLib.readDataFromExcel("CreateAccount",0,1);
		String accnumber = exLib.readDataFromExcel("SystemData",1,1);
		String debitno = exLib.readDataFromExcel("SystemData",2,1);
		String debitpin = exLib.readDataFromExcel("SystemData",3,1);
		String registermno = exLib.readDataFromExcel("CreateAccount",1,1);
		String pno = exLib.readDataFromExcel("CreateAccount",4,1);
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

		String cid = wLib.acceptAlertGetText(driver);
		String str4 = jLib.cidNoFromText(cid);
        System.out.println(str4);
		exLib.setExcelData("SystemData", 4, 1, str4);

		driver.findElement(By.xpath("//a[.='Home']")).click();
		WebElement interban = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		wLib.mousehover(driver, interban);
		driver.findElement(By.xpath("//li[.='Login ']")).click();

		String cuid =exLib.readDataFromExcel("SystemData", 4, 1);
		driver.findElement(By.name("customer_id")).sendKeys(cuid);
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("login-btn")).click();



		driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
		driver.findElement(By.name("add_beneficiary")).click();


		driver.findElement(By.name("beneficiary_name")).sendKeys("vino");
		driver.findElement(By.name("beneficiary_acno")).sendKeys("1011821011632");
		driver.findElement(By.name("Ifsc_code")).sendKeys("1011");
		WebElement actype = driver.findElement(By.name("beneficiary_acc_type"));

		wLib.select(actype, "Saving");
		driver.findElement(By.name("add_beneficiary_btn")).click();
		wLib.acceptAlert(driver);

		driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
		WebElement beni = driver.findElement(By.name("beneficiary"));
		wLib.select(beni, 1);
		driver.findElement(By.name("trnsf_amount")).sendKeys("10000");
		driver.findElement(By.name("fnd_trns_btn")).click();

     	String t = driver.findElement(By.xpath(" //label[@class='OTP_msg']")).getText();
		System.out.println(t);		        



		  String str6 = jLib.otpNumberNoFromText(t);
		  System.out.println(str6);
		driver.findElement(By.name("otpcode")).sendKeys(str6);
		driver.findElement(By.name("verify-btn")).click();
		String succes = wLib.acceptAlertGetText(driver);
		System.out.println(succes);
		driver.close();
	} 

}
