package com.application.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.application.basePackage.BaseClass;

public class LargeChandelierPage extends BaseClass {
	
	public LargeChandelierPage () 
	{
		PageFactory.initElements(driver, this);
	}
	
	public   productPage clickOnProduct() {
		driver.findElement(By.xpath("//a[contains(text(),'Ellisse LED Double Chandelier')]")).click();
		return new productPage();
		
	}

}
