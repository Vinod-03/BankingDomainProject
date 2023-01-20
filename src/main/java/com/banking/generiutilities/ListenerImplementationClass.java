package com.banking.generiutilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener{

	ExtentReports reports;
	 ExtentTest test;
    JavaUtility jLib=new JavaUtility();
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		  test = reports.createTest(methodname);
		Reporter.log(methodname+" TestScript Excutin Started ");
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		     test.log(Status.PASS,methodname );
		     Reporter.log(methodname+" TestScript Excution succesfully  ");
		
	}

	public void onTestFailure(ITestResult result)
	{
	      String res = result.getName();
	      String re = jLib.getSystemDataAndTimeFormat();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		    File src = edriver.getScreenshotAs(OutputType.FILE);
		     File des = new File("./Screenshot/"+res+re+".png");
		        String path = des.getAbsolutePath();
		     try {
				FileUtils.copyFile(src, des);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     test.addScreenCaptureFromPath(path);
				test.log(Status.FAIL, result.getThrowable());
				Reporter.log("--TestScript Execution failed");

		 
	
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		  test.log(Status.FAIL,methodname );
		  Reporter.log(methodname+" The Test Script skipped ");
			}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("Banking Dpmain");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("OnlineBankingDomain");
	         reports = new ExtentReports();
	         reports.attachReporter(htmlreport);
	         reports.setSystemInfo("Base Browser", "chrome");
	         reports.setSystemInfo("OS", "Windows");
	         reports.setSystemInfo("Base-url", "http://rmgtestingserver/domain/Online_Banking_System/");
	         reports.setSystemInfo("Author-name", "Vinod") ;    
		
		
		
			}

	public void onFinish(ITestContext context) {
		
		reports.flush();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	
	
}
