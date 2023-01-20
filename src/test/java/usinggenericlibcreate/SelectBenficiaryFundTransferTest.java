package usinggenericlibcreate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.generiutilities.ExcelUtility;
import com.banking.generiutilities.FileUtility;
import com.banking.generiutilities.JavaUtility;
import com.banking.generiutilities.WebdriverUtility;
import com.bankingdomain.objectrepo.AddBenificiaryPagePom;
import com.bankingdomain.objectrepo.AmountTransferPagePom;
import com.bankingdomain.objectrepo.HomePage;
import com.bankingdomain.objectrepo.InternetBankingLoginPagePom;
import com.bankingdomain.objectrepo.OnlineCustomerProfilePagePom;

public class SelectBenficiaryFundTransferTest {

	public static void main(String[] args) throws Throwable {

		
		WebDriver driver ;

		FileUtility fLib = new FileUtility();
		ExcelUtility exLib = new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		JavaUtility jLib = new JavaUtility();
		String url = fLib.getPropertyFileData("url");
		driver=new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(url);
       
		//homepage
		HomePage hp=new HomePage(driver);
		hp.mouseHoverToLogin(driver, wLib);
		InternetBankingLoginPagePom ilp = new InternetBankingLoginPagePom(driver);
		ilp.internetBankLoginForm(exLib);

		//customer profile
		OnlineCustomerProfilePagePom ocp = new OnlineCustomerProfilePagePom(driver);
		AddBenificiaryPagePom abn = new AddBenificiaryPagePom(driver);

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
