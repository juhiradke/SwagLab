package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage 
{
	WebDriver driver;
   @FindBy (xpath="//div[text()='Sauce Labs Backpack']")
  private WebElement bag;
   
   @FindBy (xpath="(//button[text()='Add to cart'])[1]")
   private WebElement addtocard;
   
   @FindBy (xpath="//button[@id='back-to-products']")
   private WebElement backbutton;
   
   @FindBy (xpath="//div[text()='Sauce Labs Bike Light']")
   private WebElement bikeLight;
   
   @FindBy (xpath="//button[text()='Add to cart']")
   private WebElement addtocard1;
   
   @FindBy (xpath="//button[@id='back-to-products']")
   private WebElement backtoproduct;
   
   public ProductListPage(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
   public void selectPro1()
   {
	   bikeLight.click();
	   addtocard1.click();
	  // backtoproduct.click();
   }
   
   public void selectPro2()
   {
	   bag.click();
	   addtocard.click();
	 //  backbutton.click();
	  
	   
   }
}
