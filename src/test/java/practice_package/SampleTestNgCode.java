package practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTestNgCode {

	@Test
	public void Create()
	{
		System.out.println("created");
	}
	
	
	@Test(priority = 2)
	public void update()
	{
		System.out.println("updated");
	}


    @Test( dependsOnMethods  = "Create" )
    public void delete()
    {
    	System.out.println("deleted");
    }


    @DataProvider
	  public Object[][] data()
	  {
		  Object[][] objarr = new Object[2][2];
		  objarr[0][0]="banglore";
		  objarr[0][1]="Mysore";
		 
		  objarr[1][0]="mysore";
		  objarr[1][1]="banglore";
		  
		 return 	objarr;
		  
		  
		  
	  }
    
}
