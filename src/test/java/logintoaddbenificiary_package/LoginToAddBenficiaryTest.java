package logintoaddbenificiary_package;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.banking.generiutilities.BaseClass;
import com.bankingdomain.objectrepo.AddBenificiaryPagePom;
import com.bankingdomain.objectrepo.HomePage;
import com.bankingdomain.objectrepo.InternetBankingLoginPagePom;
import com.bankingdomain.objectrepo.OnlineCustomerProfilePagePom;

public class LoginToAddBenficiaryTest extends BaseClass{

	@Test(priority = 3)
	public void LoginInterBanking() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.mouseHoverToLogin(driver, wLib);
		InternetBankingLoginPagePom ilp = new InternetBankingLoginPagePom(driver);
		ilp.internetBankLoginForm(exLib);
		OnlineCustomerProfilePagePom ocp = new OnlineCustomerProfilePagePom(driver);
		ocp.clickfundtransferbtn();
		ocp.clickaddbenficiarybtn();
		AddBenificiaryPagePom abn = new AddBenificiaryPagePom(driver);
		abn.addBenficiaryPageForm(wLib, exLib);
		wLib.acceptAlert(driver);
		Reporter.log("The Benficiary Account no is  addedd sucesfully",true);			
	}

}
