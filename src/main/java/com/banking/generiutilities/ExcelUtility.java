package com.banking.generiutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {



	/**
	 * This method is used to read the data from excel based on  sheet name ,row no ,column no
	 * @param sheetname
	 * @param rowno
	 * @param colno
	 * @return
	 * @throws Throwable
	 */
	public  String readDataFromExcel(String sheetname, int rowno,int celno) throws Throwable
	{
		FileInputStream efil = new FileInputStream(IpathConstants.excelpath);
		      Workbook wb = WorkbookFactory.create(efil);
		     Sheet sh = wb.getSheet(sheetname);
		    String data = sh.getRow(rowno).getCell(celno).getStringCellValue();
		
		
		return data;
		
		
	}
	
	
	/**
	 * This method is used to get a last row number from sheet
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 * @throws Throwable
	 */
	public int getRowCount(String sheetname) throws Throwable, Throwable
	{
		        FileInputStream efil = new FileInputStream(IpathConstants.excelpath);
		           Workbook wb = WorkbookFactory.create(efil);
		         Sheet sh = wb.getSheet(sheetname);
		          int rlno = sh.getLastRowNum();
		          return rlno;
	
		
	}
	
	
	/**
	 * This method is used to add the data in excel based on sheet name ,row no, column no
	 * @param sheetname
	 * @param rowno
	 * @param celno
	 * @param data
	 * @throws Throwable
	 */
	public void setExcelData(String sheetname,int rowno,int celno,String data) throws Throwable
	{
		
		         FileInputStream efil = new FileInputStream(IpathConstants.excelpath);
		         Workbook wb = WorkbookFactory.create(efil);
		         Sheet sh = wb.getSheet(sheetname);
		         Row row = sh.getRow(rowno);
		             Cell cel = row.createCell(celno);
		             cel.setCellValue(data);
		               FileOutputStream fos = new FileOutputStream(IpathConstants.excelpath);
		            
		             wb.write(fos);
		        		 wb.close();
			
	}
  
	public void setExcelDataCreate(String sheetname,int rowno,int celno,String data) throws Throwable
	{
		
		         FileInputStream efil = new FileInputStream(IpathConstants.excelpath);
		         Workbook wb = WorkbookFactory.create(efil);
		         Sheet sh = wb.getSheet(sheetname);
		         Row row = sh.createRow(rowno);
		             Cell cel = row.createCell(celno);
		             cel.setCellValue(data);
		               FileOutputStream fos = new FileOutputStream(IpathConstants.excelpath);
		             
		             wb.write(fos);
		        		 wb.close();
			
	}

	public Map<String, String> getList(String sheetname,int keycell,int valuecell) throws Throwable
	{
	
		 FileInputStream efil = new FileInputStream(IpathConstants.excelpath);
         Workbook wb = WorkbookFactory.create(efil);
         Sheet sh = wb.getSheet(sheetname);
         int count=sh.getLastRowNum();
         Map<String,String> map = new HashMap<String,String>();
         
		
		for(int i=0;i<=count;i++)
		{
			String key=sh.getRow(i).getCell(keycell).getStringCellValue();
			String value=sh.getRow(i).getCell(valuecell).getStringCellValue();
			map.put(key, value);
		}
		
		return map;
	}
	
	
	public  Object[][] readDataFromExcelToDataProvider(String sheetname) throws Throwable
	{
		FileInputStream efil = new FileInputStream(IpathConstants.excelpath);
		      Workbook wb = WorkbookFactory.create(efil);
		     Sheet sh = wb.getSheet(sheetname);
		    int rowlast = sh.getLastRowNum()+1;
           int lastcel = sh.getRow(0).getLastCellNum();
           
             Object[][] obj = new Object[rowlast][lastcel];
           for(int i=0;i<rowlast;i++)
           {
        	   for(int j=0;j<lastcel;j++)
        	   {
        		   obj[i][j]  = sh.getRow(i).getCell(j).getStringCellValue();
        		 
        	   }
           
                       }
		return obj;
	
	}	
	
}
