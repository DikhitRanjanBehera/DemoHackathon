package com.application.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.application.basePackage.BaseClass;

public class productPage extends BaseClass {

	public productPage () 
	{
		PageFactory.initElements(driver, this);
	}
	
	public CheckOutPage clickOnAddCart() throws Exception {
		driver.findElement(By.id("add-to-cart")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'CHECKOUT')]")).click();
		return new CheckOutPage();
		
	}
}
