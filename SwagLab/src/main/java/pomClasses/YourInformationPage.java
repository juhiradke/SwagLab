package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage 
{
  @FindBy(xpath="//input[@id='first-name']")
  private WebElement firstName;
  
  @FindBy(xpath="//input[@id='last-name']")
  private WebElement lastName;
  
  @FindBy(xpath="//input[@id='postal-code']")
  private WebElement zipCode;
  
  @FindBy(xpath="//input[@id='continue']")
  private WebElement continew;
  
  public YourInformationPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  public void firstName(String name)
  {
	 // firstName.click();
	  firstName.sendKeys(name);
  }
  public void lastName(String lname)
  {
	  lastName.sendKeys(lname); 
  }
  public void zipCode(String code)
  {
	  zipCode.sendKeys(code); 
  }
  public void continew()
  {
	  continew.click();
  }
  
  public void fillInformation()
  {
	  firstName.sendKeys("Juhi");
	  lastName.sendKeys("Radke");
	  zipCode.sendKeys("440037");
	  continew.click();
  }
  
}
