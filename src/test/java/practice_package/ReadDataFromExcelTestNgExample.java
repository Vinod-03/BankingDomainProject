package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.generiutilities.IpathConstants;

public class ReadDataFromExcelTestNgExample {

	
	
	
	@Test(dataProvider ="readdata" )
	public void excute(String  src,String des)
	{
		
		System.out.println(src);
	}
	
	
	
	
	   @DataProvider
	   public Object[][] readdata() throws Throwable, IOException
	   {
		   
		   FileInputStream fil = new FileInputStream(IpathConstants.excelpath);
		      Workbook wb = WorkbookFactory.create(fil);
		       Sheet sh = wb.getSheet("DataProvider");
		       int rno = sh.getLastRowNum()+1;
		        int lastcel = sh.getRow(0).getLastCellNum();
		        
		          Object[][] obj = new Object[rno][lastcel];
		      for (int i = 0; i < rno; i++) {
				for(int j=0;j<lastcel;j++)
				{
				   obj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
				}
			}
		   return obj;
		   
		   
	   }
	
	
}
