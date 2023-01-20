package com.bankingdomain.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmountTransferPagePom {

	@FindBy(name="otpcode")
	private WebElement otpcodetxtt;
	
	@FindBy(name="verify-btn")
	private WebElement verifybtnn;
	
	
	public  AmountTransferPagePom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getOtpcodetxt() {
		return otpcodetxtt;
	}


	public WebElement getVerifybtn() {
		return verifybtnn;
	}

	
	public void otpFromTextMessage(String str)
	{
		otpcodetxtt.sendKeys(str);
		verifybtnn.click();
	}
}
