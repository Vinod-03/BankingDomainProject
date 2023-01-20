package com.banking.generiutilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	
	
	/**
	 * This method is used get a random number
	 * @return
	 */
	public int getRanDomNumber()
	{
		Random random = new Random();
		   int intRandom = random.nextInt(500);
		   return intRandom;
		
	}

	/**
	 * this method is used to get a system data from java utility
	 * @return
	 */
   public String getSystemDate()
   {
	   
	   Date dt = new Date();
	   String date = dt.toString();
	   return date;
	   
	   
   }

   
	   public String getSystemDataAndTimeFormat()
	   {
		   SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
		      Date systemdate = new Date();
		      String getDataAndTime=dateFormat.format(systemdate);
		      System.out.println(getDataAndTime);
		         
		   
		   
		      
		return getDataAndTime.replaceAll(":", "-");
		   
		   
		   }
   
   
  public String aplicationFromText(String text)
  {
	  
	  char  ch[]= text.toCharArray();
		String str ="";

		for (int i = 0; i < ch.length; i++)
		{

			if(ch[i]>='0'&&ch[i]<='9') {
				str=str+ch[i];					} 
		}

		return str;  
  }
     /**
      * This method is break the text and get the  application no  in the form of string
      * @param accno
      * @return
      */
  public String accountFromText(String accno)
  {
  char[] ch2 = accno.toCharArray();
	String str1="";
	for(int i=0;i<ch2.length;i++)
	{
		if(ch2[i]>='0' && ch2[i]<='9')
		{
			str1=str1+ch2[i];
		}
	}
	return str1;
  
  }
  
  /**
   * This method is break the text and get the  Account no  in the form of string
   * @param accno
   * @return
   */
  public String debitNoFromText(String dbcnopin)
  {
  char dbch[]=dbcnopin.toCharArray();	         	
	String dbtno="";
	String pinno="";
	int count=0;
	for(int i=0;i<dbch.length;i++)
	{
		if(dbch[i]>='0' && dbch[i]<='9')
		{
			if(count<12)
			{
				dbtno=dbtno+dbch[i];
				count++;
			}
			else {
				pinno=pinno+dbch[i];
			}

		}


	}
	return dbtno;
  }
  
  /**
   * This method is break the text and get the  Debit card  no  in the form of string
   * @param accno
   * @return
   */
  public String pinNoFromText(String dbcnopin)
  {
  char dbch[]=dbcnopin.toCharArray();	         	
	String dbtno="";
	String pinno="";
	int count=0;
	for(int i=0;i<dbch.length;i++)
	{
		if(dbch[i]>='0' && dbch[i]<='9')
		{
			if(count<12)
			{
				dbtno=dbtno+dbch[i];
				count++;
			}
			else {
				pinno=pinno+dbch[i];
			}

		}


	}
	return pinno;
  }
  
  
  /**
   * This method is break the text and get the  pin no  in the form of string
   * @param accno
   * @return
   */
  public String cidNoFromText(String cid)
  {

  
  char[]  ch3=cid.toCharArray();
	String str4="";
	for(int i=0;i<ch3.length;i++)
	{
		if(ch3[i]>='0' && ch3[i]<='9')
		{
			str4=str4+ch3[i];
		}
	}
	return str4;
  }


  /**
   * This method is break the text and get the  otp no  in the form of string
   * @param accno
   * @return
   */

  public String otpNumberNoFromText(String t)
  {
	  
	  char ch5[]=t.toCharArray();
		String str5="";
		String str6="";
		int count1=0;
		for(int i=0;i<ch5.length;i++)
		{
			if(ch5[i]>='0'  && ch5[i]<='9')
			{
				if(count1<10)
				{
					str5=str5+ch5[i];
					count1++;
				}
				else
					str6=str6+ch5[i];
			}

		}
		return str6;

	  
 
	  
  }





















}
