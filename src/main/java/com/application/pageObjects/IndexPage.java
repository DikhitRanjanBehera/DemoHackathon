package com.application.pageObjects;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.application.actionDriver.ActionClass;
import com.application.basePackage.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath = "//a[@class='login']")
     WebElement signinBtn;
	
	@FindBy(xpath = "//input[@name='search_query']")
	WebElement searchbox;
	
	@FindBy(name = "submit_search")
	WebElement searchBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo;
	
	@FindBy(name = "q")
	WebElement googleSearchBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement GSearchBtn;
	
	@FindBy(xpath = "//img[@title='Flipkart']")
	WebElement flipKartLogo;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement crossIcon;
	
	
	@FindBy(xpath = "//div[@class='_1rH5Jn']/div[2]/div[3]/div[1]/div[1]/div/a")
	WebElement LoginFlipkartBtn;
	
	@FindBy(xpath = "//span[text()=\"Account\"]")
	WebElement AccountLumens;
	
	@FindBy(xpath = "//div[@class='dropdown-menu']/div/a")
	WebElement signinLumens;
	
	public IndexPage () 
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public LoginPage signin() {
		ActionClass.click(driver, LoginFlipkartBtn);
		return new LoginPage();
	}
	
	public LoginPage ClickAccount() {
		ActionClass.click(driver, AccountLumens);
		ActionClass.click(driver, signinLumens);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
	 return	ActionClass.isdisplayed(driver, flipKartLogo);
	}
	
	public void  searchProduct(String product) {
		ActionClass.type(searchbox, product);
//		ActionClass.type(googleSearchBox, product);
		ActionClass.click(driver, searchBtn);
//		ActionClass.click(driver, GSearchBtn);
	}
	
	public  IndexPage clickOnCrossIcon() {
	WebElement crs	=driver.findElement(By.xpath("//div[@id='ltkpopup-close-button']"));
		Actions act = new Actions(driver);
		act.moveToElement(crs).build().perform();
		act.click(crs).build().perform();
		return new IndexPage();
		
	} 
	
	public void verifyLable() {
		ActionClass.findelement(driver,LoginFlipkartBtn);
		ActionClass.isdisplayed(driver, LoginFlipkartBtn);
	}
	
	
}
