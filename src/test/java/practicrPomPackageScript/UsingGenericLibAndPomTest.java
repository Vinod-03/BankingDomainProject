package practicrPomPackageScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.banking.generiutilities.ExcelUtility;
import com.banking.generiutilities.FileUtility;
import com.banking.generiutilities.JavaUtility;
import com.banking.generiutilities.WebdriverUtility;
import com.bankingdomain.objectrepo.AccountOpeningPomPage;
import com.bankingdomain.objectrepo.AddBenificiaryPagePom;
import com.bankingdomain.objectrepo.AmountTransferPagePom;
import com.bankingdomain.objectrepo.ApplyDebitCardPom;
import com.bankingdomain.objectrepo.ApproveAccountPagePom;
import com.bankingdomain.objectrepo.CreditCustomerPom;
import com.bankingdomain.objectrepo.HomePage;
import com.bankingdomain.objectrepo.InternetBankingLoginPagePom;
import com.bankingdomain.objectrepo.InternetBankingRegistrationPage;
import com.bankingdomain.objectrepo.OnlineCustomerProfilePagePom;
import com.bankingdomain.objectrepo.StaffLoginHomePagePom;
import com.bankingdomain.objectrepo.StaffLoginPom;

public class UsingGenericLibAndPomTest {

	public static void main(String[] args) throws Throwable {


		WebDriver driver ;

		FileUtility fLib = new FileUtility();
		ExcelUtility exLib = new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		JavaUtility jLib = new JavaUtility();
		String url = fLib.getPropertyFileData("url");
		driver=new ChromeDriver();
		driver.get(url);

		
		               
		
		//homepage
		HomePage hp=new HomePage(driver);
		hp.getOpenaccountBtn().click();

		//open account
		AccountOpeningPomPage ac=new AccountOpeningPomPage(driver);
		//ac.excelData(exLib.getList("CreateAccount", 0, 1), driver);
		ac.userData(driver, exLib);
//		ac.Dob();         
//		ac.selectData(driver, exLib);
		String applicationno = wLib.acceptAlertGetText(driver);
		String aplino = jLib.aplicationFromText(applicationno);
		System.out.println(aplino);
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
		System.out.println(apno);

		//Approve Account
		ApproveAccountPagePom ap = new ApproveAccountPagePom(driver);
		ap.aplnofromexcel(driver, apno);
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
		ap.approveaccount();

		String accno = wLib.acceptAlertGetText(driver);
		String str1 = jLib.accountFromText(accno);
		System.out.println(str1);
		exLib.setExcelData("SystemData", 1, 1, str1);
		ap.homebtnclick();
		sh.creditcustbtnclick();

		//credit customer
		String acno = exLib.readDataFromExcel("SystemData", 1, 1);
		CreditCustomerPom ch = new  CreditCustomerPom(driver);
		ch.creaditcustomerAccount(acno, "10000");
		wLib.acceptAlert(driver);
		ch.homebtnclick();
		sh.staffLogout();
		sl.clickHomeBtnonStaffhm();


		//apply debit card
		hp.clickonApplyDebit();
		ApplyDebitCardPom ad = new  ApplyDebitCardPom(driver);
		ad.debitCardForm();
		ad.Dob(exLib);
		wLib.waitAlertPresent(driver);
		String dbcnopin = wLib.acceptAlertGetText(driver);
        String dbtno = jLib.debitNoFromText(dbcnopin);
	    String pinno = jLib.pinNoFromText(dbcnopin);
		System.out.println(dbtno);
		System.out.println(pinno);

		exLib.setExcelData("SystemData", 2, 1, dbtno);
		exLib.setExcelData("SystemData", 3, 1, pinno);

		
		ad.clickHomeBtdebit();


		//internetBanking Registration
		hp.mouseHoverToRegister(driver, wLib);
		InternetBankingRegistrationPage irp = new InternetBankingRegistrationPage(driver);
		irp.getExcelDataToRegister(exLib);
		irp.Dob(exLib);
		String cid = wLib.acceptAlertGetText(driver);
		String str4 = jLib.cidNoFromText(cid);
		System.out.println(str4);
		exLib.setExcelData("SystemData", 4, 1, str4);
		irp.clickOnHomeRegisterBtn();

		//InternetLoginpage
		hp.mouseHoverToLogin(driver, wLib);
		InternetBankingLoginPagePom ilp = new InternetBankingLoginPagePom(driver);
		ilp.internetBankLoginForm(exLib);

		//customer profile
		OnlineCustomerProfilePagePom ocp = new OnlineCustomerProfilePagePom(driver);
		ocp.clickfundtransferbtn();
		ocp.clickaddbenficiarybtn();

		//addbenficiary
		AddBenificiaryPagePom abn = new AddBenificiaryPagePom(driver);
		abn.addBenficiaryPageForm(wLib, exLib);
		wLib.acceptAlert(driver);
		ocp.clickfundtransferbtn();
		abn.selectBenficiaryPageForm(wLib);


		String t = driver.findElement(By.xpath(" //label[@class='OTP_msg']")).getText();
		System.out.println(t);
		String str6 = jLib.otpNumberNoFromText(t);
		System.out.println(str6);
		AmountTransferPagePom at = new AmountTransferPagePom(driver);
		at.otpFromTextMessage(str6);
		String succes = wLib.acceptAlertGetText(driver);
		System.out.println(succes);
		driver.close();
	}

}
