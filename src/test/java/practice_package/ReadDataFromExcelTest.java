package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable {

		
		  //   step 1  to  convert excel data into  java 
		    FileInputStream fi = new FileInputStream("./src/test/resources/TestData.xlsx");
		    
		 
		  //  
		    Workbook wb = WorkbookFactory.create(fi);
		    
		    
		 //  
		    
		 String or = wb.getSheet("Organize").getRow(1).getCell(0).getStringCellValue();
		 System.out.println(or);
		 
		    
		
		
	}

}
