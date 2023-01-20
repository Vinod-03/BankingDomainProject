package practice_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class SampleRunner1 {

	public static void main(String[] args) throws Throwable, IOException {

		   String  si="apple";
		FileInputStream fi=new FileInputStream("./Practice.xlsx");
		    Workbook wb = WorkbookFactory.create(fi);
		          Sheet sh = wb.getSheet("Sheet1");
		         int rdnum = sh.getLastRowNum();
		         int ccell=sh.getRow(0).getLastCellNum();
		          
		         
		         for(int i=0;i<rdnum;i++)
		         {
		        	for(int j=0;j<ccell;j++) {
		        	 
		        		 String rowdata = sh.getRow(i).getCell(j).getStringCellValue();
		        		 if(rowdata.contains(si))
		        	     {
			        		 String cdata=sh.getRow(i).getCell(j+1).getStringCellValue();

		        	    	 System.out.println(rowdata+cdata);
		        	    	 
		        	    	
		        	     }
		        		
		        	 
		        	 
		             
		              
		         }
		         
		         
		     
		
		
		
	}

	}}	

