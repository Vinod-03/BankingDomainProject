package com.bankingdomain.objectrepo;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.generiutilities.ExcelUtility;
import com.banking.generiutilities.JavaUtility;
import com.google.protobuf.MapEntry;

public class AccountOpeningPomPage {

	@FindBy(name="name")
	private WebElement username;
	
	@FindBy(name="mobile")
	private WebElement usermobileno;
	
	@FindBy(name="email")
	private WebElement useremail;
	
	@FindBy(name="landline")
	private WebElement userlandline;
	
	@FindBy(name="pan_no")
	private WebElement userpanno;

	@FindBy(name="citizenship")
	private WebElement usercitizenship;

	@FindBy(name="homeaddrs")
	private WebElement userhomeaddress;

	
	@FindBy(name="officeaddrs")
	private WebElement userofficeaddress;
	
	
	@FindBy(name="pin")
	private WebElement useraddrespin;
	
	@FindBy(name="arealoc")
	private WebElement userarealoc;

	@FindBy(name="dob")
	private WebElement dateofbirth;
	
	@FindBy(name="gender")
	private WebElement usergender;
	
	@FindBy(name="state")
	private WebElement userstate;
	
	@FindBy(name="city")
	private WebElement usercity;
	
	@FindBy(name="acctype")
	private WebElement nomineacctype;
	
	@FindBy(name="submit")
	private WebElement submitbtn;
	
	@FindBy(name="cnfrm-submit")
	private WebElement cnfrmBtn;
	
	
	
	public AccountOpeningPomPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	
	
	
	
	
	public WebElement getUsername() {
		return username;
	}


	public WebElement getUsermobileno() {
		return usermobileno;
	}


	public WebElement getUseremail() {
		return useremail;
	}


	public WebElement getUserlandline() {
		return userlandline;
	}


	public WebElement getUserpanno() {
		return userpanno;
	}


	public WebElement getUsercitizenship() {
		return usercitizenship;
	}


	public WebElement getUserhomeaddress() {
		return userhomeaddress;
	}


	public WebElement getUserofficeaddress() {
		return userofficeaddress;
	}


	public WebElement getUseraddrespin() {
		return useraddrespin;
	}


	public WebElement getUserarealoc() {
		return userarealoc;
	}
	
  
	public WebElement getDateofbirth() {
		return dateofbirth;
	}
	

	public WebElement getUsergender() {
		return usergender;
	}

	public WebElement getUserstate() {
		return userstate;
	}

	public WebElement getUsercity() {
		return usercity;
	}

	public WebElement getNomineacctype() {
		return nomineacctype;
	}

	
	
	
	
	//business logic
	
	public WebElement getSubmitbtn() {
		return submitbtn;
	}







	public WebElement getCnfrmBtn() {
		return cnfrmBtn;
	}






//	//business logic
	public void excelData(Map<String, String>ha,WebDriver driver)
	{
		
		for(Entry<String, String>h:ha.entrySet())
		{
			String value=h.getValue();
			driver.findElement(By.name(h.getKey())).sendKeys(value);
				
		}
	}
	 
	public void  userData( WebDriver driver, ExcelUtility exLib) throws Throwable
	{
		
		String name = exLib.readDataFromExcel("CreateAccount", 0, 1);	
		username.sendKeys(name);
		Random r=new Random();
		int n=100+r.nextInt(899);
		String mobileno = exLib.readDataFromExcel("CreateAccount", 1, 1)+n;
		exLib.setExcelData("CreateAccount", 1, 2, mobileno);
		usermobileno.sendKeys(mobileno);
		String emailid = exLib.readDataFromExcel("CreateAccount", 2, 1);
		useremail.sendKeys(emailid);
		String landlineno = exLib.readDataFromExcel("CreateAccount", 3, 1);
		userlandline.sendKeys(landlineno);
		String panno = exLib.readDataFromExcel("CreateAccount", 4, 1);
		userpanno.sendKeys(panno);
		String citizen = exLib.readDataFromExcel("CreateAccount", 5, 1);
		usercitizenship.sendKeys(citizen);
	    String  hoadres = exLib.readDataFromExcel("CreateAccount", 6, 1);
	    userhomeaddress.sendKeys(hoadres);
	    String oaddress = exLib.readDataFromExcel("CreateAccount", 7, 1);
	    userofficeaddress.sendKeys(oaddress);
	    String pincode = exLib.readDataFromExcel("CreateAccount", 8, 1);
	    useraddrespin.sendKeys(pincode);
	    String areal = exLib.readDataFromExcel("CreateAccount", 9, 1);
	    userarealoc.sendKeys(areal);
	   	    
	
	}
     public void Dob() 
     {
    	 
    	    	
    	 dateofbirth.click();
    	 dateofbirth.sendKeys("01-01-1998");
     }
	
     
     
    
     
     public void selectData(WebDriver driver ,ExcelUtility exLib) throws Throwable
     {
    	 
    	 usergender.sendKeys(exLib.readDataFromExcel("select", 0, 1));
    	 userstate.sendKeys(exLib.readDataFromExcel("select", 1, 1));
    	 usercity.sendKeys(exLib.readDataFromExcel("select", 2, 1));
    	 nomineacctype.sendKeys(exLib.readDataFromExcel("select", 3, 1));
    	 submitbtn.click();
    	 cnfrmBtn.click();
    	 
    	 	 
  
     }
}

