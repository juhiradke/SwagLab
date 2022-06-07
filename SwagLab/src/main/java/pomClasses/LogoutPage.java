package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
 //System.out.println
	//juhi
	WebDriver driver;
	
	@FindBy (xpath="//button[@id='react-burger-menu-btn']")
	private WebElement menuButton;
	
	@FindBy (xpath="//a[@id='logout_sidebar_link']")
	private WebElement logout;
	
	public LogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void logoutFromApp()
	{
	 /* Actions act = new Actions(driver);
	  act.moveToElement(menuButton).perform();
	  act.click().perform();*/
	  menuButton.click();
	  logout.click();
	}
}
