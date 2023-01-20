package com.bankingdomain.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.generiutilities.ExcelUtility;
import com.banking.generiutilities.WebdriverUtility;

public class AddBenificiaryPagePom {

	
	
	@FindBy(name="beneficiary_name")
	private WebElement beneficiary_nametxt;
	
	@FindBy(name="beneficiary_acno")
	private WebElement beneficiary_acnotxt;
	
	@FindBy(name="Ifsc_code")
	private WebElement Ifsc_codetxt;
	
	@FindBy(name="beneficiary_acc_type")
	private WebElement beneficiary_acc_typesel;
	
	@FindBy(name="add_beneficiary_btn")
	private WebElement addbeneficiarybtn;
	
	

	@FindBy(name="beneficiary")
	private WebElement beneficiarysel;

	@FindBy(name="trnsf_amount")
	private WebElement trnsf_amounttxt;
	
	@FindBy(name="fnd_trns_btn")
	private WebElement fndtrnsbtn;
	
	public  AddBenificiaryPagePom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

    
	public WebElement getBeneficiarysel() {
		return beneficiarysel;
	}


	public WebElement getTrnsf_amounttxt() {
		return trnsf_amounttxt;
	}


	public WebElement getFndtrnsbtn() {
		return fndtrnsbtn;
	}


	public WebElement getBeneficiary_nametxt() {
		return beneficiary_nametxt;
	}


	public WebElement getBeneficiary_acnotxt() {
		return beneficiary_acnotxt;
	}


	public WebElement getIfsc_codetxt() {
		return Ifsc_codetxt;
	}


	public WebElement getBeneficiary_acc_typesel() {
		return beneficiary_acc_typesel;
	}


	public WebElement getAddbeneficiarybtn() {
		return addbeneficiarybtn;
	}

	
	
	public void addBenficiaryPageForm(WebdriverUtility wLib,ExcelUtility exLib) throws Throwable
	{
		
		beneficiary_nametxt.sendKeys(exLib.readDataFromExcel("CreateAccount",11 ,1 ));
		beneficiary_acnotxt.sendKeys(exLib.readDataFromExcel("CreateAccount",12 ,1 ));
		Ifsc_codetxt.sendKeys(exLib.readDataFromExcel("CreateAccount",13 ,1 ));
		WebElement actype = beneficiary_acc_typesel;
	     wLib.select(actype, 1);
	     addbeneficiarybtn.click(); 
		
	}
	
	
	public void selectBenficiaryPageForm(WebdriverUtility wLib) throws InterruptedException
	{
		wLib.select(beneficiarysel, 1);
		trnsf_amounttxt.sendKeys("1000");
		Thread.sleep(2000);
		fndtrnsbtn.click();
		
	}
}
