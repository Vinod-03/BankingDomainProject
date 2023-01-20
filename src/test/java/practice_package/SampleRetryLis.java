package practice_package;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.generiutilities.BaseClass;

public class SampleRetryLis   {

	
	@Test(retryAnalyzer = com.banking.generiutilities.IretryListenerImplimenationClass.class)
	public void sample()
	{
		Assert.assertEquals("a", "b");
	}
	
}
