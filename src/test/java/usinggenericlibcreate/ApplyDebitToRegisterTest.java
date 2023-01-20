package usinggenericlibcreate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.generiutilities.ExcelUtility;
import com.banking.generiutilities.FileUtility;
import com.banking.generiutilities.JavaUtility;
import com.banking.generiutilities.WebdriverUtility;
import com.bankingdomain.objectrepo.ApplyDebitCardPom;
import com.bankingdomain.objectrepo.HomePage;
import com.bankingdomain.objectrepo.InternetBankingRegistrationPage;

public class ApplyDebitToRegisterTest {

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
		
		hp.clickonApplyDebit();
		ApplyDebitCardPom ad = new  ApplyDebitCardPom(driver);
		ad.debitCardForm();
		ad.Dob(exLib);
		wLib.waitAlertPresent(driver);
		String dbcnopin = wLib.acceptAlertGetText(driver);
		System.out.println(dbcnopin);
		
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
		Thread.sleep(5000);
		irp.Dob(exLib);
		String cid = wLib.acceptAlertGetText(driver);
		String str4 = jLib.cidNoFromText(cid);
		System.out.println(str4);
		exLib.setExcelData("SystemData", 4, 1, str4);
		irp.clickOnHomeRegisterBtn();

	}

}
