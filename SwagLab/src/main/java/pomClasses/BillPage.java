package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPage 
{
	//System.out.println
	WebDriver driver;
   @FindBy(xpath="//button[@id='finish']")
   private WebElement finish;
   
   public BillPage(WebDriver driver)
   {
	   PageFactory.initElements( driver,this);
   }
   
   public void billing()
   {
	   finish.click();
	   String url= driver.getCurrentUrl();
   }
   
}
