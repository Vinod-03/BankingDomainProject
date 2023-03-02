package practice_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomRedifmail {

	  
	@FindBy(xpath="//input[@name='id']" )
	private WebElement usernametxt;
	
	@FindBy(xpath="//input[@id='pass_box']")
	private WebElement passwordtxt;
  
	
	public PomRedifmail(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	 
	
	public WebElement getUsernametxt() {
		return usernametxt;
	}

	public WebElement getPasswordtxt() {
		return passwordtxt;
	}
	
	
}
