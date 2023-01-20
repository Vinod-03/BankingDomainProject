package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFileTest {

	public static void main(String[] args) throws IOException {
         //step 1 create a object for file to convert properties lang into java lan
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
       
		// step 2 create  object for properties
		Properties p = new Properties();

		
		//   to load the data of properties file
		p.load(fis);

		//  assigning
		String url = p.getProperty("url");
		String uname = p.getProperty("username");
		String pwd = p.getProperty("password");

		System.out.println(url);
		System.out.println(uname);   
		System.out.println(uname);   


	}

}
