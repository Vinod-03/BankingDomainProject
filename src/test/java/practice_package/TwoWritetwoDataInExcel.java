package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class TwoWritetwoDataInExcel {

	
	@Test
	public  void WriteData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream("./p.xlsx");
		   Workbook wb = WorkbookFactory.create(fi);
		    wb.createSheet();
		
		
		
	}
}
