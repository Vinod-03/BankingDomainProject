package com.bankingdomain.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginHomePagePom {

	
	
	@FindBy(name="apprvac")
	private WebElement approvebtn;
	
	@FindBy(name="credit_cust_ac")
	private WebElement creditcustbtn;

	
	
	@FindBy(name="logout_btn")
	private WebElement logotbtnstaff;




	public StaffLoginHomePagePom(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getCreditcustbtn() {
		return creditcustbtn;
	}


	public WebElement getApprovebtn() {
		return approvebtn;
	}

	
	public void approveAc()
	{
		approvebtn.click();
	}

	
	public WebElement getHomebtnstaff() {
		return logotbtnstaff;
	}


	public void creditcustbtnclick()
	{
		creditcustbtn.click();
	}


	public void staffLogout()
	{
		logotbtnstaff.click();
	}

}
