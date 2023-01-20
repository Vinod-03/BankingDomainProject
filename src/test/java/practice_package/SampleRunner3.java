package practice_package;

import org.testng.annotations.Test;

public class SampleRunner3 {

	@Test(groups="smoke")
	public void  sample5()
	{
		
		System.out.println("test Script 5");
		
	}
	
	
	@Test(groups="regression")
	public void  sample6()
	{
		
		System.out.println("test Script 6");
		
	}

	
	
}
