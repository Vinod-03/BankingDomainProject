package practice_package;

import org.testng.annotations.Test;

public class SampleDataProvider {

	
	@Test(dataProvider = "data",dataProviderClass = SampleTestNgCode.class )
	public void travel(String src, String des)
	{
		System.out.println(src);
		System.out.println(des);
		
		
	}
	
	
	
	 
	
	
	
	
	
}
