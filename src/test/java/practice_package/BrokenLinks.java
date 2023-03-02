
package practice_package;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinks {

	   @Test
	   public void linkbroken()
	   {
		   
		   WebDriver driver=new ChromeDriver();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.get("https://google.com");
		 List<WebElement> links = driver.findElements(By.xpath("//a"));
		 List<String> brokenLinks=new ArrayList<String>();
		   
		 for(int i=0;i<links.size();i++)
		 {
			     String getlink = links.get(i).getAttribute("href");
			      URL url;
			      int statuscode=0;
			 
			      try {
			    	  url=new URL(getlink);
			    	   URLConnection urlConne = url.openConnection();
			    			  
			    	    HttpsURLConnection httpsurlConn = (HttpsURLConnection)urlConne;
			    	    
			    	    statuscode=  httpsurlConn.getResponseCode();
			    	    if(statuscode>=400)
			    	    {
			    	    	brokenLinks.add(getlink);
			    	    }
			    			  
			    			  
			    	  
			      }catch(Exception e)
			      {
			    	  
			    	  brokenLinks.add(getlink);
			    	  
			    	  continue;
			    	  
			    	  
			    	  
			      }
			 
		 }
				   
		   System.out.println(brokenLinks);
		   
		   
	   }
	
	
	
	
	
}
