package com.bankingdomain.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineCustomerProfilePagePom {

	
	
	@FindBy(xpath="//li[.='Fund Transfer']")
	private WebElement fundtrasferbtn;
 
	
	@FindBy(name="add_beneficiary")
	private WebElement add_beneficiarybtn;

	@FindBy(name="logout_btn")
	private WebElement logoutbtn;
	 
	@FindBy(xpath= "//label[@class='OTP_msg']")
	private WebElement otpmessage;
	
	public  OnlineCustomerProfilePagePom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFundtrasferbtn() {
		return fundtrasferbtn;
	}

	public WebElement getAdd_beneficiarybtn() {
		return add_beneficiarybtn;
	}

	public WebElement getLogoutbtn()
	{
		return logoutbtn;
	}
	
	public void clickfundtransferbtn()
	{
		fundtrasferbtn.click();
	}

	public WebElement getOtpmessage() {
		return otpmessage;
	}

	public void clickaddbenficiarybtn()
	{
		add_beneficiarybtn.click();
	}
	

	public String getTextFromOtp()
	{
		String message = otpmessage.getText();
		return message;
	}

	public void clickOnLogoutBtn()
	{
		logoutbtn.click();
	}

}
