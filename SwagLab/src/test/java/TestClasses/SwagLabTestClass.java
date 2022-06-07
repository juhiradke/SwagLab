package TestClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Browser.BaseClass;
import UtilityPkg.Utility;
import pomClasses.BillPage;
import pomClasses.CardItems;
import pomClasses.LoginPage;
import pomClasses.LogoutPage;
import pomClasses.ProductListPage;
import pomClasses.YourInformationPage;

public class SwagLabTestClass 
{
	WebDriver driver;
	LoginPage loginPage;
	ProductListPage productListPage;
	//BillPage billPage;
	CardItems cardItems;
	YourInformationPage yourInformationPage;
	String data; 
	CardItems checkOut ;
	CardItems billing;
	LogoutPage logoutPage;
	@Parameters("browserName")
	@BeforeTest
	public void launchBrowser(String browser)
	{
		if(browser.equals("Chrome"))
		{
			driver = BaseClass.openChromeBrowser();
		}
		if(browser.equals("FireFox"))
		{
			driver= BaseClass.FireFoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(9,TimeUnit.SECONDS);
	}
	@BeforeClass
	public void pomObject()
	{
		loginPage= new LoginPage(driver);
	    productListPage = new ProductListPage(driver);
	 //   billPage = new BillPage(driver);
	    cardItems = new CardItems(driver);
	    yourInformationPage = new YourInformationPage(driver);
	    logoutPage=  new LogoutPage(driver);
	}
	@BeforeMethod
	public void loginApplication() throws EncryptedDocumentException, IOException
	{
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		data= Utility.FatechDataFromExcel("Sheet1", 1, 0);
		loginPage.userName(data);
		data= Utility.FatechDataFromExcel("Sheet1", 1, 1);
		loginPage.password(data);
		loginPage.login();	
	}
	
	@Test (priority =-1)
	public void verifyTest1() throws EncryptedDocumentException, IOException 
	{
		String url= driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals("https://www.saucedemo.com/inventory.html",url);
	}
	@Test (priority =1)
	public void verifyTest2()
	{
		productListPage.selectPro2();
		String url2= driver.getCurrentUrl();
		System.out.println(url2);
		Assert.assertEquals("https://www.saucedemo.com/inventory-item.html?id=4",url2); 
		
	}
	@Test (priority =2)
	public void verifyTest23()
	{
		productListPage.selectPro1();
		String url1= driver.getCurrentUrl();
		System.out.println(url1);
		Assert.assertEquals("https://www.saucedemo.com/inventory-item.html?id=0",url1); 
	}
	@Test(priority =3)
	public void verifyTest3()
	{
		cardItems.cardItemsList();
		String url2= driver.getCurrentUrl();
		System.out.println(url2);
		Assert.assertEquals("https://www.saucedemo.com/cart.html", url2);
	}
	@Test (priority=4)
	public void verifyTest4() throws EncryptedDocumentException, IOException
	{
		cardItems.cardItemsList();
		cardItems.checkOut();
		
		data= Utility.FatechDataFromExcel("Sheet1", 1, 2);
		yourInformationPage.firstName(data);
		
		data= Utility.FatechDataFromExcel("Sheet1", 1, 3);
		yourInformationPage.lastName(data);
		
		data= Utility.FatechDataFromExcel("Sheet1", 1, 4);
		yourInformationPage.zipCode(data);
		
		String url3= driver.getCurrentUrl();
		System.out.println(url3);
		Assert.assertEquals("https://www.saucedemo.com/checkout-step-one.html",url3);
	}
	
	@Test
	public void verifyTest5() throws EncryptedDocumentException, IOException
	{
		cardItems.cardItemsList();
		cardItems.checkOut();
		
		data= Utility.FatechDataFromExcel("Sheet1", 1, 2);
		yourInformationPage.firstName(data);
		
		data= Utility.FatechDataFromExcel("Sheet1", 1, 3);
		yourInformationPage.lastName(data);
		
		data= Utility.FatechDataFromExcel("Sheet1", 1, 4);
		yourInformationPage.zipCode(data);
		
		yourInformationPage.continew();
		String url4 = driver.getCurrentUrl();
		System.out.println(url4);
		Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html", url4);
		
	    cardItems.billing();
		
	}
	@AfterMethod
	public void logoutFromApp(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.CapturScreenshot(driver);
		}
		
		logoutPage.logoutFromApp();
	}
	 @AfterClass
	   public void clearObject()
	   {
		   loginPage=null;
		   productListPage = null;
		  //  billPage = null;
		    cardItems = null;
		    yourInformationPage = null;
		    logoutPage= null;
		}
	   @AfterTest
	   public void ClosedBrowser()
	   {
		   driver.close();
		   driver= null;
		   System.gc();
  } 
}
