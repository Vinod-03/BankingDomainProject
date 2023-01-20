package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDataBase {

	public static void main(String[] args) throws SQLException {

		Connection con=null;
		
        String server="jdbc:mysql://localhost:3306/sdet45";
        String user="root";
        String pwd="root";
		
		
		try {
		Driver driver=new Driver();

		//step1:Register the dataBase
		DriverManager.registerDriver(driver);
	
		
		//Step2:Get  connection for the database
		
	  con=DriverManager.getConnection(server,user, pwd);
		
	
		//step 3: issue create statment
	  
	     Statement state = con.createStatement();
	     String query="select * from studentInfo;";
	     
	     
		//Step 4 Excute query
		
		   ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			
		}
			
	}
	catch(Exception e)
	{
		
	}
	finally 
	{
		//Step 5  Close the data base
		con.close();
		System.out.println("data base connection closed sucesfully");
		
	}
		
		
		
	}

}
