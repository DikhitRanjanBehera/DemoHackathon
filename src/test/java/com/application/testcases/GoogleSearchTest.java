package com.application.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.application.basePackage.BaseClass;
import com.application.pageObjects.IndexPage;

public class GoogleSearchTest extends BaseClass {
	IndexPage indexpage;

	@BeforeMethod (groups = "smoke")
	public void setup() { // launching chrome browser
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

	@Test
	public void gSearch() {
		indexpage = new IndexPage();
		indexpage.searchProduct(prop.getProperty("Product2"));
	}

}
