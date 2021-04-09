package com.application.utility;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.application.basePackage.BaseClass;

public class ExcelDataProvider extends BaseClass {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
			System.setProperty("webdriver.chrome.driver", "D:\\Java Selenium\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
		}
	
	
	
	@Test(dataProvider = "Test1Data" )
	public void test1(String username,String password) throws IOException, InterruptedException {
//	System.out.println(username+" | "+password);	
		
		driver.get(prop.getProperty("url"));
//		takeScreenshot("AutomationPractice");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("passwd")).sendKeys(password);
		Thread.sleep(2000);
	}
	
	
	
	@DataProvider(name="Test1Data")
	public  Object[][] getData() {
		String excelPath = "C:\\Users\\Dikhit\\Downloads\\DikhitRanjanBehera-main\\DikhitRanjanBehera-main\\DemoProject\\ExcelFolder\\data.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}
	
	
	public  Object[][] testData(String excelPath , String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		 int rouCount = excel.getRoCount();
		 int colCount = excel.getColCount();
		 
		 Object data[][]= new Object[rouCount-1][colCount];
		 
		 for (int i=1;i<rouCount;i++) {
			 for(int j=0;j<colCount;j++) {
				String cellData = excel.getCellDataString(i, j);
//				System.out.print(cellData+ " | ");
				
				data[i-1][j]=cellData;
				
			 }
			 System.out.println();
		 }
		 return data;
	}

}
