package selectbenificaryfundtransfer_package;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.banking.generiutilities.BaseClass;
import com.bankingdomain.objectrepo.AddBenificiaryPagePom;
import com.bankingdomain.objectrepo.AmountTransferPagePom;
import com.bankingdomain.objectrepo.HomePage;
import com.bankingdomain.objectrepo.InternetBankingLoginPagePom;
import com.bankingdomain.objectrepo.OnlineCustomerProfilePagePom;

public class SelectBenficiaryFundTransferTest  extends BaseClass {


	
	  @Test(priority = 4)
	  public  void fundTransfer() throws Throwable
	  {
		HomePage hp=new HomePage(driver);
		hp.mouseHoverToLogin(driver, wLib);
		InternetBankingLoginPagePom ilp = new InternetBankingLoginPagePom(driver);
		ilp.internetBankLoginForm(exLib);
        OnlineCustomerProfilePagePom ocp = new OnlineCustomerProfilePagePom(driver);
		AddBenificiaryPagePom abn = new AddBenificiaryPagePom(driver);

		ocp.clickfundtransferbtn();
		abn.selectBenficiaryPageForm(wLib);

        Thread.sleep(2000);
		String textfromotp = ocp.getTextFromOtp();
		System.out.println(textfromotp);
		
		String str6 = jLib.otpNumberNoFromText(textfromotp);
		Reporter.log("The OTP number is "+str6);
		AmountTransferPagePom at = new AmountTransferPagePom(driver);
		at.otpFromTextMessage(str6);
		String succes = wLib.acceptAlertGetText(driver);
		Reporter.log(succes,true);
		ocp.clickOnLogoutBtn();
		
		
	}

}
