package com.banking.generiutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	static {
		System.setProperty("webdriver.edge.driver", "./msedgedriver.exe");
	}

	
	
	
	 public  WebDriver  driver;
	 public static WebDriver    sdriver;

	 public   WebdriverUtility wLib=new WebdriverUtility();
	 public   ExcelUtility exLib=new ExcelUtility();
	 public  FileUtility fLib=new FileUtility();
	 public  DataBaseUtility dLib=new DataBaseUtility();
	 public  JavaUtility   jLib=new JavaUtility();
			 
	
	
	@BeforeSuite
	 public void configToDB() throws Throwable
	 {
		//dLib.connectToDB();
		System.out.println("--connect to data base");
	 }
	
	@BeforeClass
	public void configToBC() throws Throwable
	{    
		    
	       String url = fLib.getPropertyFileData("url");
	       String browser = fLib.getPropertyFileData("browser");
	       if(browser.equalsIgnoreCase("chrome"))
	       {
	    	   driver=new EdgeDriver();
	    	   
	       }
	       else if(browser.equalsIgnoreCase("edge"))
	       {
	    	   driver=new ChromeDriver();
	    			   
	       }
	       else
	       {
	    	   System.out.println("invalid browser");
	       }
	    	
	       
		 sdriver=driver;
		 driver.get(url);

		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		
	}
	
	
	
	@BeforeMethod
	public void configBM() throws Throwable
	{
		}
	
	@AfterMethod
	public void configAM()
	{
		
	}
	
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void configCloseDB() throws Throwable
	{
		//dLib.closeDB();
	}
	
	
	
	
	
}
