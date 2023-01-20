package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritedataInExcelTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		 //   step 1  to  convert excel data into  java 
	    FileInputStream fi = new FileInputStream("./src/test/resources/TestData.xlsx");
	    
	 
	  //  
	    Workbook wb = WorkbookFactory.create(fi);
	    
	    
	 //  
	    
	  wb.getSheet("Organize").createRow(2).createCell(0).setCellValue("vinod");
	  
	  FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
	  wb.write(fos);

	}

}
