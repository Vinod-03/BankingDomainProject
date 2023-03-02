package practice_package;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinksInBankingProject {

	
	
	@Test
	public void getBrokenLinks()
	{
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		List<WebElement> allLink = driver.findElements(By.xpath("//a"));
		List<String> brokenlinks=new ArrayList<String>();
		for(int i=0;i<allLink.size();i++)
		{
			       String link = allLink.get(i).getAttribute("href");
			      URL url;
			        int status=0;
			        try
			        {
			              url=new URL(link);
			        	URLConnection openConn = url.openConnection(); 
			        	  HttpsURLConnection httpsconne = (HttpsURLConnection)openConn;
			        	  
			        	  status=  httpsconne.getResponseCode();
			              if(status>=400)
			              {
			            	  brokenlinks.add(link); 
			              }
			
			          
			        }catch(Exception e)
			        {
			        	brokenlinks.add(link);
			        }
			
			        
			
		}
		
		//System.out.println(brokenlinks);
		
		
		for(int i=0;i<brokenlinks.size();i++)
		{
			System.out.println(brokenlinks.get(i));
		}
		
		
	}
	
}
