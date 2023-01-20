package usinggenericlibcreate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.generiutilities.ExcelUtility;
import com.banking.generiutilities.FileUtility;
import com.banking.generiutilities.JavaUtility;
import com.banking.generiutilities.WebdriverUtility;
import com.bankingdomain.objectrepo.AddBenificiaryPagePom;
import com.bankingdomain.objectrepo.HomePage;
import com.bankingdomain.objectrepo.InternetBankingLoginPagePom;
import com.bankingdomain.objectrepo.OnlineCustomerProfilePagePom;

public class LoginToAddBenficiaryTest {

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
		ocp.clickfundtransferbtn();
		ocp.clickaddbenficiarybtn();

		//addbenficiary
		AddBenificiaryPagePom abn = new AddBenificiaryPagePom(driver);
		abn.addBenficiaryPageForm(wLib, exLib);
		wLib.acceptAlert(driver);
		
		
	}

}
