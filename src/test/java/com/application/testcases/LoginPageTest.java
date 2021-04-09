/**
 * 
 */
package com.application.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.application.actionDriver.ActionClass;
import com.application.basePackage.BaseClass;
import com.application.pageObjects.HomePage;
import com.application.pageObjects.IndexPage;
import com.application.pageObjects.LoginPage;

/**
 * @author DIKHIT
 *
 */
public class LoginPageTest extends BaseClass {
	IndexPage index;
	LoginPage login;
	HomePage home;
	
	
	@BeforeMethod (groups = "regression")
	public void setup() { //launching chrome browser
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void verifyLogo() {
		index = new IndexPage();
		boolean result = index.validateLogo();
		Assert.assertTrue(result);
		index.searchProduct(prop.getProperty("Product"));
		login=index.signin();
		home=login.login(prop.getProperty("username"), "password");
		home.logoff();
	}
	
	
	
}
