package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.crm.qa.baselayer.baseclass;
import com.google.common.io.Files;

public class testutil extends baseclass {
	
	static  org.apache.poi.ss.usermodel.Workbook Workbook;
	static Sheet sheet;
	
	public static long  implicitwait =5;
	
	
	public void switchtoframe()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	
	@DataProvider(name="DP")
	public Object[][] formcontactfilldata(String sheetname) throws InvalidFormatException 
	{
		FileInputStream fs=null;
	try
	{
		fs= new FileInputStream("C:/Users/nishan/eclipse-workspace/pomfactoryframework/src/main/java/com/crm/qa/testdata/dddd.xlsx");
		
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	try
	{
		 Workbook = WorkbookFactory.create(fs);
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		sheet=Workbook .getSheet(sheetname);
		 Object[][]  data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				 for (int i = 0; i <sheet.getLastRowNum(); i++) {
			 for (int j = 0; j <sheet.getRow(0).getLastCellNum(); j++) {
				 data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			 }
				 }
		return data;
		
	}


	public static void takeScreenshotAtEndOfTest() throws Exception {
		File Scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(Scrfile,new File("C:\\Users\\nishan\\eclipse-workspace\\pomfactoryframew\\Screenshot.png"));    
		
	}
				
}
