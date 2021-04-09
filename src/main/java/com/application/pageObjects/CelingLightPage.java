package com.application.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.application.basePackage.BaseClass;

public class CelingLightPage extends BaseClass {

	public CelingLightPage () 
	{
		PageFactory.initElements(driver, this);
	}
	
	public Chandelier clickOnChandelier() {
		driver.findElement(By.linkText("CHANDELIERS")).click();
		return new Chandelier();
	}
	
}
