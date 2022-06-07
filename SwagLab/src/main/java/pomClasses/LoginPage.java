package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
   @FindBy(xpath="//input[@id='user-name']")
   private WebElement username;
   
   @FindBy (xpath="//input[@id='password']")
   private WebElement password;
   
   @FindBy(xpath="//input[@id='login-button']")
   private WebElement login;
   
   public LoginPage(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
   public void userName(String user)
   {
	   username.sendKeys(user);
   }
   
   public void password(String pword)
   {
	   password.sendKeys(pword);
   }
   
   public void login()
   {
	   login.click();
   }
   //or
   public void loginApplication()
   {
	   username.sendKeys("standard_user");
	   password.sendKeys("secret_sauce");
	   login.click();
   }
}
