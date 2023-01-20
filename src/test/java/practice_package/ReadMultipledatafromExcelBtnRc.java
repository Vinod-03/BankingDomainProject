package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipledatafromExcelBtnRc {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		
		  FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		  Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet("Organize");
	      int la = sh.getLastRowNum();

	          for(int i=0;i<=la;i++)
	          {
	        	  
	        	    Row row = sh.getRow(i);
	        	    for(int j=0;j<row.getLastCellNum();j++)
	        	    {
	        	    	String data = row.getCell(j).getStringCellValue();
	        	    	
	        	    	System.out.println(data);
	        	    }
	        	  System.out.println();
	        	  
	          }
	      
	        
	
	}
		  
		
		
	}


