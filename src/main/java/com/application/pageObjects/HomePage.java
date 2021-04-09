/**
 * 
 */
package com.application.pageObjects;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.application.actionDriver.ActionClass;
import com.application.basePackage.BaseClass;

/**
 * @author DIKHIT
 *
 */
public class HomePage extends BaseClass {
	
	private String lightningpageurl = "https://www.lumens.com/lighting.html";

	@FindBy(className = "logout")
	WebElement logoffBtn;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[3]/div/div[1]/a/div/img[2]")
	WebElement MobileNavFlipkart;
	
	@FindBy(xpath = "//span[@title='lighting']")
	WebElement Lightning;
	
	public HomePage () 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void logoff() {
		ActionClass.click(driver, logoffBtn);
		
	}
	
	public  HomePage navigateProduct() 
	{
		ActionClass.findelement(driver, Lightning);
//		ActionClass.click(driver, Lightning);
		return new HomePage();
	}
	
	
	public  LightningPage navigateLightning() {
		
		driver.navigate().to(lightningpageurl);
		return new LightningPage();
	}
}
