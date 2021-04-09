/**
 * 
 */
package com.application.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.application.actionDriver.ActionClass;
import com.application.basePackage.BaseClass;
import com.application.pageObjects.CelingLightPage;
import com.application.pageObjects.Chandelier;
import com.application.pageObjects.CheckOutPage;
import com.application.pageObjects.HomePage;
import com.application.pageObjects.IndexPage;
import com.application.pageObjects.LargeChandelierPage;
import com.application.pageObjects.productPage;
import com.application.pageObjects.LoginPage;
import com.application.pageObjects.LightningPage;

/**
 * @author DIKHIT
 *
 */
public class LumensTest extends BaseClass {
	
	IndexPage index;
	LoginPage login;
	HomePage home;
	ActionClass action;
	LightningPage lightning;
	CelingLightPage celingLight;
	Chandelier Chandel;
	LargeChandelierPage largeChandel;
	productPage product;
	CheckOutPage checkOut;
	
	@BeforeMethod ()
	public void setup() { //launching chrome browser and accessing url of lumen
		launchApp();    //will launch chrome and go to lumen
		if (index== null) {
			index= new IndexPage();
		}
		
		if (login == null) {
			login = new LoginPage();
		}
		
		if (home == null) {
			home = new HomePage();
		}
		
		if (lightning == null) {
			lightning = new LightningPage();
		}
		
		if (celingLight == null) {
			celingLight = new CelingLightPage();
		}
		
		if (Chandel == null) {
			Chandel = new Chandelier();
		}
		
		if (largeChandel == null) {
			largeChandel = new LargeChandelierPage();
		}
		
		if (product == null) {
			product = new productPage();
		}
		
		if (checkOut == null) {
			checkOut = new CheckOutPage();
		}
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	
	@Test (priority = -1, enabled = true) 
	public void Login() throws Exception {
		extent.createTest("LumensTest");
		takeScreenshot("url open time");
		index.clickOnCrossIcon();
		takeScreenshot("Clicking Cross button");
//		index.verifyLable();
		index.ClickAccount();
		home= login.loginToLumens(prop.getProperty("lumensUser"), prop.getProperty("LumensPass"));
		takeScreenshot("loging success");
		lightning= home.navigateLightning();
		celingLight=lightning.navigateCelingLights();
		Chandel= celingLight.clickOnChandelier();
		largeChandel = Chandel.clickonLargeChandelier();
		product=largeChandel.clickOnProduct();
		checkOut=product.clickOnAddCart();
		checkOut.increaseQuantityAndEnterPromo();
//		checkOut.verifyIncorrectPromo();
//		largeChandel=checkOut.logoutLumens();
		
		
	}
	
	
	

}
