package com.bankingdomain.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.generiutilities.FileUtility;

public class StaffLoginPom {

	
	@FindBy(name="staff_id")
	private WebElement staffid;
	
	@FindBy(name="password")
	private WebElement staffpsw;
	
	
	@FindBy(name="staff_login-btn")
	private WebElement stafflgnbtn;

	@FindBy(xpath="//a[.='Home']")
	private WebElement  staffhomeBtnn;
	
	public WebElement getStaffid() {
		return staffid;
	}


	public WebElement getStaffpsw() {
		return staffpsw;
	}


	public WebElement getStafflgnbtn() {
		return stafflgnbtn;
	}
	
	public StaffLoginPom(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public WebElement getStaffhomeBtn() {
		return staffhomeBtnn;
	}


	public void staffLoginpage(WebDriver driver,String staff,String pass) throws Throwable
	{
		   

		staffid.sendKeys((staff));
		staffpsw.sendKeys((pass));
		stafflgnbtn.click();
	}
	
	public  void clickHomeBtnonStaffhm()
	{
		staffhomeBtnn.click();
	}


		
	
}
