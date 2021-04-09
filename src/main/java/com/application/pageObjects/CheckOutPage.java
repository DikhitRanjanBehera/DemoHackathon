package com.application.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.application.actionDriver.ActionClass;
import com.application.basePackage.BaseClass;

public class CheckOutPage extends BaseClass {
	
	@FindBy
	(xpath = "//span[@class='couponcode']")
	WebElement invalidCode;
	
	@FindBy(xpath = "//span[text()=\"Account\"]")
	WebElement AccountLumens;
	
	@FindBy(xpath = "//a[@class='logout']")
	WebElement logout;

	public CheckOutPage () 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void increaseQuantityAndEnterPromo() {
		driver.findElement(By.xpath("//span[@class='qty-increment-decrement qty-increment']")).click();
		driver.findElement(By.xpath("//input[@name='dwfrm_cart_couponCode']")).sendKeys("COUPON");
		driver.findElement(By.xpath("//button[@name='dwfrm_cart_addCoupon']")).click();
	}
	
	public  CheckOutPage verifyIncorrectPromo() {
		ActionClass.findelement(driver, invalidCode);
		String actLogo = "not valid";
		WebElement exp = driver.findElement(By.xpath("//span[@class='couponcode']"));
		String priLogo = exp.getText();
       if (actLogo.contains(priLogo)) {
		System.out.println("promocode Is not valid");
		return new CheckOutPage();
	}
	return null;

	}
	
	public LargeChandelierPage logoutLumens() {
		ActionClass.click(driver, AccountLumens);
		ActionClass.click(driver, logout);
		return new LargeChandelierPage();
	}
}
