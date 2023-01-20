package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PracticExcel {

	public static void main(String[] args) throws Throwable, IOException {

		   String  si="apple";
		String   rowdata = "";
		FileInputStream fi=new FileInputStream("./P.xlsx");
		    Workbook wb = WorkbookFactory.create(fi);
		          Sheet sh = wb.getSheet("Sheet2");
		         int rdnum = sh.getLastRowNum();
		         int ccell=sh.getRow(rdnum).getLastCellNum();
		          
		         int k=0;
		         for(int i=0;i<rdnum;i++)
		         {
		        	 //System.out.println("vgv");
		        	for(int j=0;j<ccell;j++) 
		        	{
		        	 
		        		
		        		try {
		        			
		        		
		        		  rowdata = sh.getRow(i).getCell(j).getStringCellValue();
		        		}
		        		  catch(Exception e)
			        		{
			        		
			        		 
			        		}
		        		 if(rowdata.contains(si))
		        	     {
			        		 String cdata=sh.getRow(i).getCell(j+1).getStringCellValue();

		        	    	 System.out.println(rowdata+cdata);
		        	    	 
		        	    	
		        	     }
		        		}
		        		
		        	 
		        	 
		             
		              
		         }
		         
		         
	}   
		
		
		
	

	}
