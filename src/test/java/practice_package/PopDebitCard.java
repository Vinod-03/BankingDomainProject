package practice_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopDebitCard {

	public static void main(String[] args) {

		
	String str="Debit Card issued successfully.\r\n"
			+ "\r\n"
			+ "It will be delivered to your home address soon.\r\n"
			+ "\r\n"
			+ "Your Debit Card No is : 421338073457 and Pin is : 3085\r\n"
			+ "\r\n"
			+ " Please change this pin as soon as possible.";
	
	
	
            char ch[]=str.toCharArray();	         	
	         String st1="";
	         String st2="";
	         int count=0;
	         
	         for(int i=0;i<ch.length;i++)
	         {
	        	 if(ch[i]>='0' && ch[i]<='9')
	        	 {
	        	
	        		 if(count<12)
	        		 {
	        			 
	        		 
	        				 st1=st1+ch[i];
	        				 count++;

	        		 }
	        		 else {
	        			 st2=st2+ch[i];
	        		 }
	        		
	        	 }
	        	 
	        	 
	         }
		System.out.println(st1);
		System.out.println(st2);
		
		
		String str3="Registration Successfull\r\n"
				+ "\r\n"
				+ "Customer ID : 1011383 \r\n"
				+ "\r\n"
				+ "Please use this customer id to login";
		
 char[]  ch3=str3.toCharArray();
        String str4="";
        
        for(int i=0;i<ch3.length;i++)
        {
      	  if(ch3[i]>='0' && ch3[i]<='9')
      	  {
      		  str4=str4+ch3[i];
      	  }
      	  
      	  
        }
        
        System.out.println(str4);
		 
		 
		 
		
	}

}
