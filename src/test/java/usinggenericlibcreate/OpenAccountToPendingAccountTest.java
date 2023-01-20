package usinggenericlibcreate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.generiutilities.ExcelUtility;
import com.banking.generiutilities.FileUtility;
import com.banking.generiutilities.JavaUtility;
import com.banking.generiutilities.WebdriverUtility;
import com.bankingdomain.objectrepo.AccountOpeningPomPage;
import com.bankingdomain.objectrepo.ApproveAccountPagePom;
import com.bankingdomain.objectrepo.HomePage;
import com.bankingdomain.objectrepo.StaffLoginHomePagePom;
import com.bankingdomain.objectrepo.StaffLoginPom;

public class OpenAccountToPendingAccountTest {

	public static void main(String[] args) throws Throwable {

		WebDriver driver ;
        FileUtility fLib = new FileUtility();
		ExcelUtility exLib = new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		JavaUtility jLib = new JavaUtility();
		String url = fLib.getPropertyFileData("url");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(url);
        //homepage
		HomePage hp=new HomePage(driver);
		hp.getOpenaccountBtn().click();
		//open account
		AccountOpeningPomPage ac=new AccountOpeningPomPage(driver);
		ac.userData(driver, exLib);
	    ac.Dob();
		ac.selectData(driver, exLib);
		String applicationno = wLib.acceptAlertGetText(driver);
		String aplino = jLib.aplicationFromText(applicationno);
		System.out.println("the applivcation no is"+aplino);
		exLib.setExcelData("SystemData", 0, 1, aplino);
		hp.staffloginlink();
        //stafflogin

		StaffLoginPom sl = new StaffLoginPom(driver);
		String stid = fLib.getPropertyFileData("staffid");
		String psw = fLib.getPropertyFileData("password");
		sl.staffLoginpage(driver, stid, psw);
		//staffloginHomePage
        StaffLoginHomePagePom sh=new StaffLoginHomePagePom(driver);
		sh.approveAc();
		String apno=exLib.readDataFromExcel("SystemData", 0, 1);

		//Approve Account
		ApproveAccountPagePom ap = new ApproveAccountPagePom(driver);
		ap.aplnofromexcel(driver, apno);
		String actualrs = driver.findElement(By.xpath("//tbody/tr/th[.='Mobile']/../../tr[2]/td[5]")).getText();
        String expectedrs = exLib.readDataFromExcel("CreateAccount", 1, 1);
		System.out.println(expectedrs);
 	    ap.approveaccount();
		String accno = wLib.acceptAlertGetText(driver);
		String str1 = jLib.accountFromText(accno);
		System.out.println(str1);
		exLib.setExcelData("SystemData", 1, 1, str1);
		ap.homebtnclick();
	    driver.close();
	}

}
