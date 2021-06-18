package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class utility1 {
	
	static private String path;
	private Sheet Sheet;
	private Row row;
	private String data;
	
	
	
	public String excelData(String s, int r, int c) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\saili\\Documents\\Book12.xlsx");
		Workbook w =WorkbookFactory.create(file);
		Sheet =w.getSheet(s);
		row = Sheet.getRow(r);
		Cell cell = row.getCell(c);
		try {
		data = cell.getStringCellValue();
		}
		catch(IllegalStateException e)
		{
		long numericVal = (long) cell.getNumericCellValue();
		System.out.println(numericVal);
		data=String.valueOf(numericVal); 
		}
		return data;
	}
		public void takeScreenshot(WebDriver driver ) throws IOException
		{
			 SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");  
			  Date date = new Date();
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("D:\\Velocity\\AutomatedSS\\AutoScreenShot "+dtf.format(date)+".jpeg");
			FileHandler.copy(source, dest);
		}
}
