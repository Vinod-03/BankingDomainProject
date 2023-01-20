package approvetocreditcus_package;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.banking.generiutilities.BaseClass;
import com.bankingdomain.objectrepo.CreditCustomerPom;
import com.bankingdomain.objectrepo.HomePage;
import com.bankingdomain.objectrepo.StaffLoginHomePagePom;
import com.bankingdomain.objectrepo.StaffLoginPom;

public class FromApproveaccountToCreditCustomerTest extends BaseClass {

	@Test(priority = 0)
	public void creditCustomer() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.staffloginlink();
		StaffLoginPom sl = new StaffLoginPom(driver);
		String stid = fLib.getPropertyFileData("staffid");
		String psw = fLib.getPropertyFileData("password");
		sl.staffLoginpage(driver, stid, psw);
        StaffLoginHomePagePom  sh=new StaffLoginHomePagePom(driver);
		sh.creditcustbtnclick();
		String acno = exLib.readDataFromExcel("SystemData", 1, 1);
		String amt = exLib.readDataFromExcel("CreateAccount", 10, 1);
		CreditCustomerPom ch = new  CreditCustomerPom(driver);
		ch.creaditcustomerAccount(acno, amt);
		wLib.acceptAlert(driver);
		Reporter.log("Customer Account no "+acno +" credited sucessfulljy of Rs "+amt,true);
		ch.homebtnclick();
		sh.staffLogout();
		sl.clickHomeBtnonStaffhm();	
	
	}
			}


