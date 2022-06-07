package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass 
{
	
  public static WebDriver openChromeBrowser()
  {
	System.setProperty("webdriver.chrome.driver","D:\\VelocityPune\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	return driver;
	
  }
  
  public static WebDriver FireFoxBrowser()
  {
	  System.setProperty("webdriver.gecko.driver","D:\\VELOCITY CORPORATE TRAINING CENTER\\SeleniumFireFoxEXE\\geckodriver.exe");
      WebDriver driver = new FirefoxDriver();
      return driver;
  }
 /* public static void main(String[] args) 
  {
	BaseClass.openChromeBrowser();
	BaseClass.FireFoxBrowser();
	}*/
}
