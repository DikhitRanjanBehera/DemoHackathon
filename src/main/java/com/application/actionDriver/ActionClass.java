package com.application.actionDriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.application.basePackage.BaseClass;
import com.application.pageObjects.IndexPage;

public class ActionClass extends BaseClass {
	
	public static void click (WebDriver driver, WebElement elem) {
		Actions act = new Actions(driver);
		act.moveToElement(elem).click().build().perform();
	}
	
	public static void click1 (WebDriver driver, WebElement elem) {
		Actions act = new Actions(driver);
		act.click();
	}
	
	public static boolean findelement(WebDriver driver , WebElement elem) {
		boolean flag = false;
		try {
		elem.isDisplayed();	
			flag= true;
		} 
		catch (Exception e) 
		{
			flag = false;
		}finally {
			if (flag) 
			{
				System.out.println("successfully found element");
			}
			else {
				System.out.println("element not found");
			}
		}
		return flag;
	}
	
	public static void type(WebElement elem, String text) {
		try {
			Thread.sleep(5000);
			elem.clear();
			elem.sendKeys(text);
		} 
		catch (Exception e) {
			System.out.println("Locator not found");
		}
	}
	
	public static boolean isdisplayed( WebDriver driver, WebElement elem) {
		boolean flag = false;
		flag = findelement(driver, elem);
		if (flag ) {
			flag = elem.isDisplayed();
			if (flag) {
				System.out.println("element displayed");
			}
			else {
				System.out.println("element not displaye");
			}
		}
		else 
		{
			System.out.println("not displayed");
		}
		return flag;	
	}
	
	public static void correctWebsite(String actUrl) {
		
		String expUrl = driver.getCurrentUrl();
		if (expUrl.contains(actUrl)) {
			System.out.println("User is in correct website");
		}
		else {
			System.out.println("user entered a incorrect url");
		}
		
	} 
	
	public boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Window is Navigated with title");				
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	
	
}	

