package com.application.basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeSuite   // extent report initialization code
	public void setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\reports.html");
		
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("FlipKart Application Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Hostname", "Dikhit");
		extent.setSystemInfo("Project name", "Flipkart Test");
		extent.setSystemInfo("Tester", "Dikhit");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
	
	
	@BeforeTest
	public void loadConfig() throws IOException {
		 try 
		 {
		prop = new Properties();
		System.out.println("super constructor invoked");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\Configuration\\config.properties");
		prop.load(fis);
		} 
		 catch (FileNotFoundException e) 
		 {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browserName");
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("urlLumens"));
	}
	
	public static void takeScreenshot(String filename) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\Dikhit\\Downloads\\DikhitRanjanBehera-main\\DikhitRanjanBehera-main\\DemoProject\\ScreenShots"+filename+".png"));
	}
	

}
