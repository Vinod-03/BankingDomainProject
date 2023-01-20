package practice_package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DiffAnotations {

	@BeforeSuite
	public void connectToDb()
	{
		
		System.out.println("---connect  to dataBase ");
		
		
	}
	
	@BeforeClass
	public void openBrowser()
	{
		System.out.println("--Launch the browser");	
		
	}
	
	
	@BeforeMethod
	public void loginToApp()
	{
		System.out.println("---login to aoolication using credential");
		
	}
	
	
	@Test
	public void createOrg()
	{
		System.out.println("--create a organistion");
	}
	
	
	@AfterMethod
	public void logoutApp()
	{
		
		System.out.println("logot from  the application");
		
	}
	
	
	@AfterClass
	public void closeTheBrowser()
	
	{
		System.out.println("close the browser");
	}
	
	@AfterSuite
	public void closeTheDb()
	{
		System.out.println("close the data base connection");
	}
}
