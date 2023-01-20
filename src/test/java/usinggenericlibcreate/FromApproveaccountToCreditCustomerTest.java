package usinggenericlibcreate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.generiutilities.ExcelUtility;
import com.banking.generiutilities.FileUtility;
import com.banking.generiutilities.JavaUtility;
import com.banking.generiutilities.WebdriverUtility;
import com.bankingdomain.objectrepo.CreditCustomerPom;
import com.bankingdomain.objectrepo.HomePage;
import com.bankingdomain.objectrepo.StaffLoginHomePagePom;
import com.bankingdomain.objectrepo.StaffLoginPom;

public class FromApproveaccountToCreditCustomerTest {

	public static void main(String[] args) throws Throwable {

		WebDriver driver ;

		FileUtility fLib = new FileUtility();
		ExcelUtility exLib = new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		JavaUtility jLib = new JavaUtility();
		String url = fLib.getPropertyFileData("url");
		driver=new ChromeDriver();
		driver.get(url);
		HomePage hp=new HomePage(driver);
		hp.staffloginlink();

		//stafflogin

		StaffLoginPom sl = new StaffLoginPom(driver);
		String stid = fLib.getPropertyFileData("staffid");
		String psw = fLib.getPropertyFileData("password");
		sl.staffLoginpage(driver, stid, psw);


		//staffloginHomePage

		StaffLoginHomePagePom  sh=new StaffLoginHomePagePom(driver);
		sh.creditcustbtnclick();

		//credit customer
		String acno = exLib.readDataFromExcel("SystemData", 1, 1);
		CreditCustomerPom ch = new  CreditCustomerPom(driver);
		ch.creaditcustomerAccount(acno, "10000");
	
		wLib.acceptAlert(driver);
		ch.homebtnclick();
		sh.staffLogout();
		sl.clickHomeBtnonStaffhm();
		driver.close();
		
	}

}
