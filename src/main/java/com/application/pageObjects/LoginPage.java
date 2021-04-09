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
public class LoginPage extends BaseClass {
	
	@FindBy(id = "email")
	WebElement loginID;
	
	@FindBy(name = "passwd")
	WebElement password;
	
	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;
	
	
	@FindBy(xpath = "//div[@class='_1rH5Jn']/div[2]/div[3]/div[1]/div[1]/div/div")
	WebElement Flipkart_Login_Logo;
	
	@FindBy(xpath = "//div[@class='_36HLxm col col-3-5']/div/form/div[1]/input")
	WebElement Flipkart_EnterUSer;
	
	@FindBy(xpath = "//div[@class='_36HLxm col col-3-5']/div/form/div[2]/input")
	WebElement Flipkart_EnterPWD;
	
	@FindBy(xpath = "//div[@class='_36HLxm col col-3-5']/div/form/div[4]/button")
	WebElement Flipkart_LoginBtn;
	
	@FindBy(xpath = "//div[@class='dropdown-menu']/div/a")
	WebElement signinLumens;
	
	@FindBy(xpath = "//input[@id='dwfrm_login_username']")
	WebElement LumensUserName;
	
	@FindBy(xpath = "//input[@id='dwfrm_login_password']")
	WebElement LumensPassd;
	
	@FindBy(xpath = "//form[@id='dwfrm_login']/fieldset/div[3]/div[2]/button")
	WebElement LumensLoginBtn;
	
	@FindBy(xpath = "//div[@class='logo']")
	WebElement Lumens_Login_Logo;
	
	@FindBy(xpath = "//input[@id='dwfrm_login_rememberme']")
	WebElement Lumens_Remember_Me_CheckBox;
	
	public LoginPage () 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public HomePage login(String usrName ,  String pwd) 
	{
		ActionClass.findelement(driver, Flipkart_EnterUSer);
		ActionClass.type(Flipkart_EnterUSer, usrName);
		ActionClass.type(Flipkart_EnterPWD, pwd);
		ActionClass.click(driver, Flipkart_LoginBtn);
		return new HomePage();
	}
	
	public HomePage loginToLumens(String usrName ,  String pwd) 
	{
		ActionClass.findelement(driver, LumensUserName);
		ActionClass.click(driver, Lumens_Remember_Me_CheckBox);
		ActionClass.type(LumensUserName, usrName);
		ActionClass.type(LumensPassd, pwd);
		ActionClass.click(driver, Lumens_Remember_Me_CheckBox);
		ActionClass.click(driver, LumensLoginBtn);
		return new HomePage();
	}

	public HomePage verifySuccesfulLogin() {
		ActionClass.findelement(driver, Flipkart_Login_Logo);
		String actLogo = "Flipkart";
		WebElement exp = driver.findElement(By.xpath("//div[@class='logo']"));
		String priLogo = exp.getText();
       if (actLogo.contains(priLogo)) {
		System.out.println("user is in homepage nd logged in successfully");
		return new HomePage();
	}
	return null;

	}
	
	public HomePage verifySuccesfulLoginForLumens() {
		ActionClass.findelement(driver, Lumens_Login_Logo);
		String actLogo = "lumens";
		WebElement exp = driver.findElement(By.xpath("//div[@class='logo']"));
		String priLogo = exp.getText();
       if (actLogo.contains(priLogo)) {
		System.out.println("user is in homepage nd logged in successfully");
		return new HomePage();
	}
	return null;

	}
	
}
