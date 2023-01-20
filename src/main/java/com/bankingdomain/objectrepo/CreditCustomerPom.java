package com.bankingdomain.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustomerPom {

	
	
	@FindBy(name="customer_account_no")
	private WebElement custactnotext;
	
	@FindBy(name="credit_amount")
	private WebElement creditamttxt;

	@FindBy(name="credit_btn")
	private WebElement creditbtn;
	
	@FindBy(name="home")
	private WebElement homebtn;
	
	public CreditCustomerPom(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}



	public WebElement getCustactnotext() {
		return custactnotext;
	}



	public WebElement getCreditamttxt() {
		return creditamttxt;
	}



	public WebElement getCreditbtn() {
		return creditbtn;
	}

	public WebElement getHomebtn() {
		return homebtn;
	}

	public void creaditcustomerAccount(String accno, String amount)
	{
		
		custactnotext.sendKeys(accno);
		creditamttxt.sendKeys(amount);
		creditbtn.click();
		
		
	}
	
	public void homebtnclick()
	{
		homebtn.click();
	}

	
}
