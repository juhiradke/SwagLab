package UtilityPkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	
	public static void CapturScreenshot( WebDriver driver) throws IOException
	{
		DateFormat dt = new SimpleDateFormat("MM-dd-yyyy HH mm ss");
		Date d = new Date();
		String date = dt.format(d);
		//System.out.println(date);
		
		 TakesScreenshot t = (TakesScreenshot)driver;
		 File source= t.getScreenshotAs(OutputType.FILE);
		 File destination = new File("./ScreenShot//Test "+ date +".jpeg");
		 FileHandler.copy(source, destination);
	}
	
	public static String FatechDataFromExcel(String sheet,int y, int x) throws EncryptedDocumentException, IOException
	{
		String data;
		String path ="C:\\Users\\DELL\\Documents\\Excelfiles\\SwagLabData.xlsx"; 
		FileInputStream file = new FileInputStream(path);
		Cell cell = WorkbookFactory.create(file).getSheet(sheet).getRow(y).getCell(x);
		try {
			data= cell.getStringCellValue();
		    }
		catch(IllegalStateException e)
		{
			double f= cell.getNumericCellValue();
			int a = (int)f;
			data= Integer.toString(a);
			System.out.println(data);
		}
		return data;
		
	}
/*	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		String s= Utility.FatechDataFromExcel("Sheet1", 1, 0);
		System.out.println(s);
	}*/

}	
	

