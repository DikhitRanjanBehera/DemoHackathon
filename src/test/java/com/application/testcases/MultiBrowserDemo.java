/**
 * 
 */
package com.application.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.application.basePackage.BaseClass;

import demoLog.LoggerDemo;

/**
 * @author Dikhit
 *
 */
public class MultiBrowserDemo extends BaseClass {
	public static Logger logger = LogManager.getLogger(MultiBrowserDemo.class);
	
	@Parameters ({"browserName"})
	@BeforeTest
	public void setup(String browserName) {
		System.out.println("Broser Name is : "+browserName);
		System.out.println("Thread ID is : "+Thread.currentThread().getId());
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Java Selenium\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dikhit\\Downloads\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	@Test ( groups = {"Sanity"}, priority = 1 , enabled = false)
	public void test1() throws InterruptedException, IOException{
		driver.get(prop.getProperty("urlLumens"));
		takeScreenshot("lumensPage");
		Thread.sleep(5000);
	}
	
	@Test (groups = {"Smoke"}, priority = 2 , enabled = true)
	public void test2() throws InterruptedException, IOException{
		driver.get(prop.getProperty("url2"));
		takeScreenshot("Googlepage");
		Thread.sleep(5000);
		logger.info("this is google page information");
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit(); 
		System.out.println("Test Completed successfully");
	}

}
