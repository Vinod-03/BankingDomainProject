package com.banking.generiutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

  /**
   * 
   * @author Vinod
   *
   */
public class FileUtility {

	     /**
	      * it is used to read the data from commonData.property file based on key which you pass  as an argument
	      * @param key
	      * @return
	      * @throws Throwable
	      */
	      public String getPropertyFileData(String key) throws Throwable
	      {
	    	         FileInputStream fil = new FileInputStream(IpathConstants.filepath);
	    	         Properties pobj=new Properties();
	    	         pobj.load(fil);
	    	   String value= pobj.getProperty(key);
	    	   return value;
	    	  
	    	  
	      }
}
