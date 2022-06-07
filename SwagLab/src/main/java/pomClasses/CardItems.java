package pomClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardItems 
{
	WebDriver driver;
	
  @FindBy(xpath="//a[@class='shopping_cart_link']")
  private WebElement cardItems;
  
  @FindBy(xpath="//button[@id='checkout']")
  private WebElement checkout;
  
  @FindBy(xpath="//button[@id='finish']")
  private WebElement finish;
  
  public CardItems(WebDriver driver)
  {
	  PageFactory.initElements(driver,this);
  }
  
  public void cardItemsList()
  {
	  cardItems.click();
	
  }
  public void checkOut()
  {
	  checkout.click();
  }
  public void billing()
  {
	  finish.click();
  }
  
}
