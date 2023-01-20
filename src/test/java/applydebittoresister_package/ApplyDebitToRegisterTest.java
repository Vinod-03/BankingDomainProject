package applydebittoresister_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.banking.generiutilities.BaseClass;
import com.banking.generiutilities.ExcelUtility;
import com.banking.generiutilities.FileUtility;
import com.banking.generiutilities.JavaUtility;
import com.banking.generiutilities.WebdriverUtility;
import com.bankingdomain.objectrepo.ApplyDebitCardPom;
import com.bankingdomain.objectrepo.HomePage;
import com.bankingdomain.objectrepo.InternetBankingRegistrationPage;

public class ApplyDebitToRegisterTest extends BaseClass {


	@Test(priority = 1)
	public void applyDebitCard() throws Throwable
	{
	   HomePage hp=new HomePage(driver);
		hp.clickonApplyDebit();
		ApplyDebitCardPom ad = new  ApplyDebitCardPom(driver);
		ad.debitCardForm();
		ad.Dob(exLib);
		wLib.waitAlertPresent(driver);
		String dbcnopin = wLib.acceptAlertGetText(driver);
	    String dbtno = jLib.debitNoFromText(dbcnopin);
	    String pinno = jLib.pinNoFromText(dbcnopin);
	    Reporter.log("The debit card no is"+dbtno,true);
	    Reporter.log("The debit card pin no is"+pinno,true);
		exLib.setExcelData("SystemData", 2, 1, dbtno);
		exLib.setExcelData("SystemData", 3, 1, pinno);
		ad.clickHomeBtdebit();  
		
	}
	
	@Test(priority=2)
	public void internetBankingLogin() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.mouseHoverToRegister(driver, wLib);
		InternetBankingRegistrationPage irp = new InternetBankingRegistrationPage(driver);
		irp.getExcelDataToRegister(exLib);
		irp.Dob(exLib);
		String cid = wLib.acceptAlertGetText(driver);
		String str4 = jLib.cidNoFromText(cid);
		Reporter.log("The Customer Id is "+str4,true);
		exLib.setExcelData("SystemData", 4, 1, str4);
		irp.clickOnHomeRegisterBtn();

	}

}
