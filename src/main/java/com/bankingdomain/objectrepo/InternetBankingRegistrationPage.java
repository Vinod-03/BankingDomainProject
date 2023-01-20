package com.bankingdomain.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.generiutilities.ExcelUtility;

public class InternetBankingRegistrationPage {

	@FindBy(name="holder_name")
	private WebElement holdernametext;
 
	@FindBy(name="accnum")
	private WebElement accnumtxt;

	@FindBy(name="dbtcard")
	private WebElement dbtcardtxt;

	@FindBy(name="dbtpin")
	private WebElement dbtpintxt;

	@FindBy(name="mobile")
	private WebElement mobiletxt;

	@FindBy(name="pan_no")
	private WebElement pan_notxt;

	@FindBy(name="dob")
	private WebElement dobtxt;

	@FindBy(name="last_trans")
	private WebElement last_transtxt;
  
	@FindBy(name="password")
	private WebElement passwordtxt;

	@FindBy(name="cnfrm_password")
	private WebElement cnfrm_passwordtxt;

	@FindBy(name="submit")
	private WebElement regsitersubmitbtn;
	
	
	
	@FindBy(xpath="//a[.='Home']")
	private WebElement regsiterhomebtn;
	
	public InternetBankingRegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getHoldernametext() {
		return holdernametext;
	}



	public WebElement getAccnumtxt() {
		return accnumtxt;
	}



	public WebElement getDbtcardtxt() {
		return dbtcardtxt;
	}



	public WebElement getDbtpintxt() {
		return dbtpintxt;
	}



	public WebElement getMobiletxt() {
		return mobiletxt;
	}



	public WebElement getPan_notxt() {
		return pan_notxt;
	}



	public WebElement getDobtxt() {
		return dobtxt;
	}



	public WebElement getLast_transtxt() {
		return last_transtxt;
	}



	public WebElement getPasswordtxt() {
		return passwordtxt;
	}



	public WebElement getCnfrm_passwordtxt() {
		return cnfrm_passwordtxt;
	}



	public WebElement getRegsitersubmitbtn() {
		return regsitersubmitbtn;
	}
	
	
	public WebElement getRegsiterhomebtn() {
		return regsiterhomebtn;
	}



	public void getExcelDataToRegister(ExcelUtility exLib) throws Throwable
	{
		
		String accname = exLib.readDataFromExcel("CreateAccount",0,1);
		String accnumber = exLib.readDataFromExcel("SystemData",1,1);
		String debitno = exLib.readDataFromExcel("SystemData",2,1);
		String debitpin = exLib.readDataFromExcel("SystemData",3,1);
		String registermno = exLib.readDataFromExcel("CreateAccount",1,2);
		String peeno = exLib.readDataFromExcel("CreateAccount",4,1);
		holdernametext.sendKeys(accname);
		accnumtxt.sendKeys(accnumber);
		dbtcardtxt.sendKeys(debitno);
		dbtpintxt.sendKeys(debitpin);
		mobiletxt.sendKeys(registermno);
		pan_notxt.sendKeys(peeno);
		last_transtxt.sendKeys("10000");
		passwordtxt.sendKeys("password");
		cnfrm_passwordtxt.sendKeys("password");
		
		
	}

	
	public void Dob(ExcelUtility exLib) throws Throwable
    {
   	 
   	     	dobtxt.click();
     	dobtxt.sendKeys("01-01-1998");
     	regsitersubmitbtn.click();
    }

	public void clickOnHomeRegisterBtn()
	{
		regsiterhomebtn.click();
	}
	
}
