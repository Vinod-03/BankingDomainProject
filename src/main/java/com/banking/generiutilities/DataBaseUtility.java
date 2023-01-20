package com.banking.generiutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataBaseUtility {

	Connection con=null;
	
	 // step1 register data base
	public void connectToDB() throws Throwable
	{
		Driver driver = new Driver();
	  // get a connection to a database
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("", "", "");		
		
		
	}
	
	public String ExcuteQueryAndgetData(String query,int columnINdex,String expData) throws Throwable
	{
		//Step 3 create a statement  
		//Step 4 Excute statment
		ResultSet result = con.createStatement().executeQuery(query);
		
		boolean flag=false;
		while(result.next())
		{
			String data=result.getString(columnINdex);
			System.out.println(data);
			if(data.equalsIgnoreCase(expData))  //compairing
			{
				flag=true;
				break;
				
			}
		}
		if(flag)
		{
			System.out.println(expData+"project is created");
			return expData;
		}
		else
		{
			System.out.println("project is not created");
			return"";
		}
	}
		public void  closeDB() throws Throwable
		{
			con.close();
		}
		
	
	
	
	
}
