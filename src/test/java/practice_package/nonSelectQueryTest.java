package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class nonSelectQueryTest {

	public static void main(String[] args) throws SQLException {

		
		
		Connection con=null;   
		int result=0;
		
		
		try {
			
			Driver driver = new Driver();

		//Step 1: Register a data  base
		
		DriverManager.registerDriver(driver);
		
		//Step 2: get a connection for a data base
		
		  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
		
		//step 3: issue  create statment
		
		    Statement state = con.createStatement();
		     String query = "insert into studentInfo values('nitish','btm','sdet',10);";
		
		
		//step 4 : update a query
		 result= state.executeUpdate(query);
		
		
		}
		catch(Exception e)
		{
			
		}
		
		
		finally
		{
		//step 5 close the data bases 
			
			if(result==1)
			{
				System.out.println("date is sucefully updated");
			}
			else
			{
				System.out.println("date is not updated");
			}
		
		}
		
	}

}
