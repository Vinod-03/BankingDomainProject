package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuerfromProjectTest {

	public static void main(String[] args) throws SQLException {
         
		Connection con=null;
		
		 
          int result=0;
		
		try {
		
		//Step 1 Register 
			Driver driver=new Driver();
		    DriverManager.registerDriver(driver);
		
		//Step get conncetion
		  con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		
		//issue create statmeny
		
		   Statement state = con.createStatement();
		   String query="insert into project values('ty_project_111','vishal','21/12/2022','sdet45','created',3);";
		
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
	}

}
