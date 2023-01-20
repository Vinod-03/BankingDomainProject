package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class ApiInsertProjectDetails {
	static {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	}
	public static void main(String[] args) throws SQLException {
       Connection con=null;
        int result=0;
        try
        {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);

		//Step get conncetion
		con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");


		//issue create statmeny

		Statement state = con.createStatement();
		String query="insert into project values('ty_project_1135','vishal','21/12/2022','sdet45','created',3);";

		//step 4 update a quer
		result = state.executeUpdate(query);

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(result==1)
		{
			System.out.println("data added sucesfully");

		}
		else
		{

			System.out.println("data is not added");
		}
		con.close();
	}

        WebDriver driver1=new ChromeDriver();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.get("http://rmgtestingserver:8084/");
		driver1.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver1.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver1.findElement(By.xpath("//button[.='Sign in']")).click();
		driver1.findElement(By.linkText("Projects")).click();
		
	boolean display = driver1.findElement(By.xpath("//td[.='ty_project_1135']")).isDisplayed();
	
	if(display==true)
	{
		System.out.println("the data is added sucesfully");
	}
	else
	{
		System.out.println("data is not added");
	}
	
	}





}


