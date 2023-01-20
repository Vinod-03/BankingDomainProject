package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetDataFromPop {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		// Write the data into excel;
		 
		driver.get("file:///C:/Users/vinod/Downloads/Confirm.html");
	
		  String text = driver.switchTo().alert().getText();
		 // System.out.println(text);
		       
                  char[] ch=text.toCharArray();
                  char ch1[]=new char[9];
                   int j=0;
                  
                  for(int i=0;i<ch.length;i++)
                  {
                	  if(ch[i]>'0' && ch[i]<'9')
                	  {
                		  ch1[j]=ch[i];
                		  j++;
                		  
                		  
                	  }
                	  
                	  
                	  
                  }
                  
                                   
                  
                  String str= new String (ch1);
                  
                FileInputStream file = new  FileInputStream("./src/test/resources/TestData.xlsx");
             Workbook wb = WorkbookFactory.create(file);
               
            Sheet sh= wb.getSheet("CreateAccount");
               int lrow = sh.getLastRowNum();
             
             
               sh.getRow(lrow).createCell(1).setCellValue(str);
               
               
               FileOutputStream fo = new  FileOutputStream("./src/test/resources/TestData.xlsx");
               
                 wb.write(fo);
               
               
               
                 
		  
	}

}
