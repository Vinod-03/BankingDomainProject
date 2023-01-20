package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RegisterAccount {

	public static void main(String[] args) throws Throwable {

		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/vinod/Downloads/OTP%20Verification.html");
		String t = driver.findElement(By.xpath(" //label[@class='OTP_msg']")).getText();
			System.out.println(t);		        
			        
			
			
			char ch4[]=t.toCharArray();
			String str5="";
			String str6="";
			int count1=0;
			
			for(int i=0;i<ch4.length;i++)
			{
				if(ch4[i]>='0'  && ch4[i]<='9')
				{
					
					
					if(count1<10)
					{
					 str5=str5+ch4[i];
					 count1++;
					}
					else
						str6=str6+ch4[i];
				}
					
			}
			
			
			System.out.println(str5);
			System.out.println(str6);

			
			
	}

}
