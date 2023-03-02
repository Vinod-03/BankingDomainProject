package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel2 {

	public static void main(String[] args) throws Throwable {

		
		
		FileInputStream fi=new FileInputStream("./p.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		   Sheet sh = wb.getSheet("Sheet1");
		  int rno = sh.getLastRowNum();
		         int celno = sh.getRow(rno).getLastCellNum();
		           
		     for(int i=0;i<rno;i++)
		     {
		    	 
		    	 for(int j=0;j<celno;j++)
		    	 {
		    		 	 
		    		 String data = null;
					try
		    		 {
		    			 
		    		 
		    		 data = sh.getRow(i).getCell(j).getStringCellValue();	 
		    		 }
		    		 catch(Exception e)
		    		 {
		    			 
		    		 }
		    		if(data.contains("app"))
		    	       {
		    	    	    String value = sh.getRow(i).getCell(j+1).getStringCellValue();
		    	       		    	        
		    	       System.out.println(data+" "+value);
		    	 
		    	       }
		    	       
		    	 
		    	 
		     }
		   
		   
		     }  
		
	}

}
