package openacctostaffapprove_package;

import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.banking.generiutilities.BaseClass;
import com.bankingdomain.objectrepo.AccountOpeningPomPage;
import com.bankingdomain.objectrepo.ApproveAccountPagePom;
import com.bankingdomain.objectrepo.HomePage;
import com.bankingdomain.objectrepo.StaffLoginHomePagePom;
import com.bankingdomain.objectrepo.StaffLoginPom;

@Listeners(com.banking.generiutilities.ListenerImplementationClass.class)
public class OpenAccountToPendingAccountTest extends BaseClass{

	@Test(priority = -2)
	public void OpenAccount() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.getOpenaccountBtn().click();
		AccountOpeningPomPage ac=new AccountOpeningPomPage(driver);
		ac.userData(driver, exLib);
		ac.Dob();
		ac.selectData(driver, exLib);
		String applicationno = wLib.acceptAlertGetText(driver);
		String aplino = jLib.aplicationFromText(applicationno);
		Reporter.log("the applivcation no is"+aplino,true);
		exLib.setExcelData("SystemData", 0, 1, aplino);
		
	}


	@Test(priority = -1)
	public void approveAccount() throws Throwable
	{
	
		HomePage hp=new HomePage(driver);
		hp.staffloginlink();
		StaffLoginPom sl = new StaffLoginPom(driver);
		String staff = fLib.getPropertyFileData("staffid");
		String psw = fLib.getPropertyFileData("password");
        sl.staffLoginpage(driver,staff,psw);
		StaffLoginHomePagePom sh=new StaffLoginHomePagePom(driver);
		sh.approveAc();
		String apno=exLib.readDataFromExcel("SystemData", 0, 1);
		ApproveAccountPagePom ap = new ApproveAccountPagePom(driver);
		ap.aplnofromexcel(driver, apno);
		String actualaplicationo = ap.getTextFromTable();
		Reporter.log("The Actual  Application no"+actualaplicationo,true);
		Assert.assertEquals(actualaplicationo,apno );
		String expectedrs = exLib.readDataFromExcel("CreateAccount", 1, 1);
		Reporter.log("The Expected Application no "+expectedrs,true);
		ap.approveaccount();
		String accno = wLib.acceptAlertGetText(driver);
		String str1 = jLib.accountFromText(accno);
		Reporter.log("the Account no is "+str1,true);
		exLib.setExcelData("SystemData", 1, 1, str1);
		ap.homebtnclick();
	}

}


