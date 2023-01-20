package com.bankingdomain.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.generiutilities.WebdriverUtility;

public class HomePage {

	  
	 //  declaration
	  @FindBy(xpath="//li[.='Open Account']")
	  private WebElement openaccountBtn;
	  
	  
	  
	  
	  @FindBy(xpath="//li[.='Apply Debit Card']")
	  private WebElement applydebitcardBtn;
	  
	  
	  
	  @FindBy(xpath="//a[contains(text(),'Internet Banking')]")
	  private WebElement internetbankingbtn;
  
	  
	  @FindBy(xpath="//li[.='Fund Transfer']")
	  private WebElement fundtransferbtn;
  
	  
	  @FindBy(xpath="//a[.='Staff Login']")
	  private WebElement staffloginbtn;

	  
	
	  @FindBy(xpath="//li[.='Register']")
	  private WebElement registerbtn;

	  @FindBy(xpath="//li[.='Login ']")
	  private WebElement loginbtn;
	  
	  // intalization
	  
	  
	


	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	 //utilization

	public WebElement getOpenaccountBtn() {
		return openaccountBtn;
	}




	public WebElement getApplydebitcardBtn() {
		return applydebitcardBtn;
	}




	public WebElement getInternetbankingbtn() {
		return internetbankingbtn;
	}




	public WebElement getFundtransferbtn() {
		return fundtransferbtn;
	}




	public WebElement getStaffloginbtn() {
		return staffloginbtn;
	}
	  
	  
	  
	//Bussiness Logic
	
	
	public void clickOnOpenAccountBtn()
	{
		openaccountBtn.click();
	}
	
	
	  
	public void staffloginlink()
	{
		staffloginbtn.click();
	}

	public void clickonApplyDebit()
	{
		applydebitcardBtn.click();
	}

	public WebElement getRegisterbtn() {
		return registerbtn;
	}
	
	
	public WebElement getLoginbtn() {
		return loginbtn;
	}


	public void mouseHoverToRegister(WebDriver driver,WebdriverUtility wLib)
	{
		
		wLib.mousehover(driver,internetbankingbtn );
		registerbtn.click();
	}
	
	public void mouseHoverToLogin(WebDriver driver,WebdriverUtility wLib)
	{
		
		wLib.mousehover(driver,internetbankingbtn );
		loginbtn.click();
	}

}
