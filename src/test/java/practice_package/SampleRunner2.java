package practice_package;

import org.testng.annotations.Test;

public class SampleRunner2 {

	@Test(groups="smoke")
	public void  sample3()
	{
		
		System.out.println("test Script 3");
		
	}
	
	
	@Test(groups="regression")
	public void  sample4()
	{
		
		System.out.println("test Script 4");
		
	}


	
}
