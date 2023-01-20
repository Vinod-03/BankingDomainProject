package practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.generiutilities.ExcelUtility;

public class DataProviderFromExcel1 {

	
	
	@Test(dataProvider = "dataFromexcel12")
	public void dataproviderEx(String src,String des)
	{
		System.out.println(src);
		System.out.println(des);
	}
	
	
	@DataProvider
	public Object[][] dataFromexcel12() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		       Object[][] value = eLib.readDataFromExcelToDataProvider("DataProvider");
				return value;

		
		
	}
	
}
