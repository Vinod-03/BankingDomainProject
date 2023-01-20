package com.bankingdomain.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApproveAccountPagePom {

	
	@FindBy(name="application_no")
	private WebElement approvetxt;
	
	
	@FindBy(name="search_application")
	private WebElement searchbtn;
	
	@FindBy(name="approve_cust")
	private WebElement aproveactbtn;
 
	@FindBy(xpath="//tbody/tr/th[2]/../../tr/td[2]")
	private WebElement txtfromtable;
	
	
	@FindBy(name="home")
	private WebElement homebtn;
	
	
	public WebElement getAproveactbtn() {
		return aproveactbtn;
	}



	public ApproveAccountPagePom(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}

   

	public WebElement getApprovebtn() {
		return approvetxt;
	}



	public WebElement getSearchbtn() {
		return searchbtn;
	}

	
	
	public WebElement getApprovetxt() {
		return approvetxt;
	}



	public WebElement getHomebtn() {
		return homebtn;
	}



	public  void aplnofromexcel(WebDriver driver,String apno)
	
	{
		
		approvetxt.sendKeys(apno);
		searchbtn.click();
		
		
	}
	
	public WebElement getTxtfromtable() {
		return txtfromtable;
	}



	public void approveaccount()
	{
		aproveactbtn.click();
	}
	
	public void homebtnclick()
	{
		homebtn.click();
	}
	
	public String getTextFromTable()
	{
		String expectedtext = txtfromtable.getText();
		return expectedtext;
	}
}
