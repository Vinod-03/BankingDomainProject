
package com.banking.generiutilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	
	
	/**
	 * this is method is used to maximize the window
	 * @author vinod
	 * @param driver
	 */
	
	  public void maximizeWindow(WebDriver driver)
	  {
		  
		  
		  driver.manage().window().maximize();
		  
	  }
	
	
	
	  /**
	   * this is method is used for findelement to load in a page
	   * @param driver
	   */
	  public void waitForPageLoad(WebDriver driver)
	  {
		  
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
	  }
	
	  
	  
	  /**
	   * this method is used for explicit wait to find the element till it visible
	   * @param driver
	   * @param element
	   */
	  public void elementToBeVisible(WebDriver driver,WebElement element)
	  {
		  
		  WebDriverWait wait=new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOf(element));	  
		  
	  }
	
	  
	  /**
	   * this is method is used select a element based on value of the element 
	   * @param element
	   * @param value
	   */
	public  void select(WebElement element,String value)
	{
	    Select sel=new Select(element);
	    sel.selectByValue(value);
				
	}
	
	
	
	/**
	 * this is method is used select a data from dropdown based on index of the element 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		
		  Select sel = new Select(element);
		  sel.selectByIndex(index);	

	}
	
	
	/**
	 * this is method is used select a data from dropdown based on visibletext of the element 
	 * @param visibletext
	 * @param element
	 */
	public void select(String visibletext,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(visibletext);
			
	}
	
	
	
	/**
	 * this method is used to mouse hover to desire element by actions class
	 * @param driver
	 * @param element
	 */
	public void mousehover(WebDriver driver,WebElement element)
	{
		
		  Actions act = new Actions(driver);
		  act.moveToElement(element).perform();
		
	}
	
	
	/**
	  * This method is used to perform drag and drop action
	  * @param driver
	  * @param src
	  * @param dst
	  */ 
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
	{
		
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst);
		
	}
	
	
	
	/**
	 *  This method will double click on WebPage
	 * @param driver
	 */
	public void doubleClick(WebDriver driver)
	{
		
		Actions act=new Actions(driver);
		act.doubleClick().perform();	
	}
	
	
	/**
	 * This method will perform right click on WebPage
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.contextClick().perform();
	}
	
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		
		
	}
	
	
	/**
	 * This method will Press Enter Key using action class
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act=new Actions(driver);
				act.sendKeys(Keys.ENTER).perform();
		
	}
	
	
	/**
	 * This method will Press Enter Key by using robot class
	 * @throws AWTException
	 */
	public void enterKey() throws AWTException
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	
	/**
	 *  This method is used to release the key  using robot class
	 * @throws AWTException
	 */
	public void enterKeyRelese() throws AWTException
	{
		
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
				
	}
	
	
	
	/**
	 *  This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver, WebElement index)
	{
		
		driver.switchTo().frame(index);
		
		
	}
	
	
	/**
	 * This method will switch the frame based on nameOrID
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver,WebElement nameOrID)
	{
		
		driver.switchTo().frame(nameOrID);
		
	}
	
	
	
	/**
	 * This method will switch the frame based on address
	 * @param driver
	 * @param address
	 */
	public void switchTOFrame(WebDriver driver,WebElement address)
	{
		
		
		driver.switchTo().frame(address);	
	}
	
	
	/**
	 * This method is used to accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		
		driver.switchTo().alert().accept();
	}
	
	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will switch between windows
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver, String partialTitle)
	{
		//step1: use getWindowHandes to capture all window id's
		Set<String> windows = driver.getWindowHandles();
		
		//step2: iterate through the windows
		Iterator<String> it = windows.iterator();
		
		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId = it.next();
			
			//step5: switch to current window and capture title 
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step6: check whether current window is expected
			if(currentWinTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	
	/**
	 * This method will take screenshot and store it in folder called as screenshot
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = ".\\screenshot\\"+screenShotName+".png";
			File dst = new File(path);
			FileUtils.copyFile(src, dst);
			return path;
			
		}
	
	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)","");
	}
	
	
	/**
	 * This method will scroll until specified element is found
	 * @param driver
	 * @param element
	 */	
	
	public void scrollAction(WebDriver driver, WebElement element)
	{
		
	JavascriptExecutor jse= (JavascriptExecutor) driver;
	int y = element.getLocation().getY();	
	jse.executeScript("Window.scrollBy(0,+y+)", element);
	
	
	}
	
	public String acceptAlertGetText(WebDriver driver)
	{
		
		
		Alert ale=driver.switchTo().alert();
		  String aletext = ale.getText();
		  ale.accept();
		  return aletext;
		  
		   	
	}

	
   public  void waitAlertPresent(WebDriver driver)
   {
	   WebDriverWait wait=new WebDriverWait(driver,10 );
		wait.until(ExpectedConditions.alertIsPresent());
   }
	
	
	
}
