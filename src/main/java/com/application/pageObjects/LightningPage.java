/**
 * 
 */
package com.application.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.application.actionDriver.ActionClass;
import com.application.basePackage.BaseClass;

/**
 * @author DIKHIT
 *
 */
public class LightningPage extends BaseClass {
	
	@FindBy(xpath = "//span[@class='menu-link']")
	WebElement Lightning;
	
	public LightningPage () 
	{
		PageFactory.initElements(driver, this);
	}
	
	public CelingLightPage navigateCelingLights() {
		driver.findElement(By.linkText("CEILING LIGHTS")).click();
		return new CelingLightPage();
	}

}
