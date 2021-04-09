package com.application.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.application.basePackage.BaseClass;

public class Chandelier extends BaseClass {
	
	public Chandelier () 
	{
		PageFactory.initElements(driver, this);
	}

	
	public LargeChandelierPage clickonLargeChandelier() {
		driver.findElement(By.linkText("LARGE CHANDELIERS")).click();
		return new LargeChandelierPage();
	}
}
