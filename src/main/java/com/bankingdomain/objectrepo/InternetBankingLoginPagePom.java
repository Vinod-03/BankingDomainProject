package com.bankingdomain.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.generiutilities.ExcelUtility;

public class InternetBankingLoginPagePom {

	
	@FindBy(name="customer_id")
	private WebElement customer_idtxt;
 
	@FindBy(name="password")
	private WebElement passwordtxt;

	@FindBy(name="login-btn")
	private WebElement loginbtn;

	

	public  InternetBankingLoginPagePom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getCustomer_idtxt() {
		return customer_idtxt;
	}



	public WebElement getPasswordtxt() {
		return passwordtxt;
	}



	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public void internetBankLoginForm(ExcelUtility exLib) throws Throwable
	{
		
		String cuid =exLib.readDataFromExcel("SystemData", 4, 1);	
		customer_idtxt.sendKeys(cuid);
		passwordtxt.sendKeys("password");
		loginbtn.click();
		
		
	}
	
	
}


