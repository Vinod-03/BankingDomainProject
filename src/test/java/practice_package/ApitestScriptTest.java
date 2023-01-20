package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApitestScriptTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	}

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("atron");
		driver.findElement(By.name("createdBy")).sendKeys("vinod");
		WebElement stat = driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select[@name='status']"));
		Select s=new Select(stat);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value=\"Add Project\"]")).click();
		
		//sql 
		
		try {
		   Driver driver1 = new Driver();
		   
		   DriverManager.registerDriver(driver1);
		   
		con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		Statement state = con.createStatement();
		 String query = "select * from project where Created_by='vinod';";
		 
		 
		 
		    ResultSet result = state.executeQuery(query);
		    boolean flag=false;
		    while(result.next())
		    {
		    	    String actualresult = result.getString(4);
		    	    System.out.println(actualresult);
		    	   if(actualresult.equalsIgnoreCase("atron"))
		    	   {
		    	  System.out.println("project is creted");
		    		   flag=true;
		    	break;
		    	   }
		    }
		    	   
		    	   if(flag==false)
		    	   {
		    		   System.out.println("not created");
		    	   }
		    	
		   
		}
		    catch(Exception e)
		    {
		    	
		    }
		    finally
		    {
		    	con.close();
		    }
		    }
		    
		   

		  

	}


