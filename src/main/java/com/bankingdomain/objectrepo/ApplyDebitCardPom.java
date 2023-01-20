package com.bankingdomain.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.generiutilities.ExcelUtility;
import com.banking.generiutilities.JavaUtility;
import com.banking.generiutilities.WebdriverUtility;

public class ApplyDebitCardPom {

	
	ExcelUtility exLib = new ExcelUtility();

	
	@FindBy(name="holder_name")
	private WebElement actholdernametxt;
	
	
	@FindBy(name="dob")
	private WebElement dateofbtext;
	
	@FindBy(name="mob")
	private WebElement mobilenotxt;
	
	@FindBy(name="pan")
	private WebElement pannotxt;
	
	@FindBy(name="acc_no")
	private WebElement accnotxt;
	
	@FindBy(name="dbt_crd_submit")
	private WebElement debitcardsubmit;
	
	@FindBy(xpath="//a[.='Home']")
	private WebElement  debithomebtn;
	
	public  ApplyDebitCardPom(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getActholdernametxt() {
		return actholdernametxt;
	}


	public WebElement getDateofbtext() {
		return dateofbtext;
	}


	public WebElement getMobilenotxt() {
		return mobilenotxt;
	}


	public WebElement getPannotxt() {
		return pannotxt;
	}


	public WebElement getAccnotxt() {
		return accnotxt;
	}


	public WebElement getDebitcardsubmit() {
		return debitcardsubmit;
	}

	
	public WebElement getDebithomeBtn() {
		return debithomebtn;
	}

	public void debitCardForm() throws Throwable
	{
		
		String acnoname = exLib.readDataFromExcel("CreateAccount", 0, 1);
		String panno = exLib.readDataFromExcel("CreateAccount", 4, 1);
		String Mno = exLib.readDataFromExcel("CreateAccount", 1, 2);
		String acnono = exLib.readDataFromExcel("SystemData", 1, 1);
		actholdernametxt.sendKeys(acnoname);
		mobilenotxt.sendKeys(Mno);
		pannotxt.sendKeys(panno);
		accnotxt.sendKeys(acnono);
	 	
	}
	
	
	public void Dob(ExcelUtility exLib) throws Throwable
    {
   	 
       	dateofbtext.click();
   	    dateofbtext.sendKeys("01-01-1998");
   	    debitcardsubmit.click();
    }

	
	public void debitCardNoDebitPinno(WebDriver driver,WebdriverUtility wLib,JavaUtility jLib) throws Throwable
	{
		
		String dbcnopin = wLib.acceptAlertGetText(driver);
        String dbtno = jLib.debitNoFromText(dbcnopin);
	    String pinno = jLib.pinNoFromText(dbcnopin);
		System.out.println(dbtno);
		System.out.println(pinno);

		exLib.setExcelData("SystemData", 2, 1, dbtno);
		exLib.setExcelData("SystemData", 3, 1, pinno);

	}
	public  void clickHomeBtdebit()
	{
		debithomebtn.click();
	}

}
