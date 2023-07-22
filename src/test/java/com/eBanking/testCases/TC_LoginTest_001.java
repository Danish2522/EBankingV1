package com.eBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.*;

public class TC_LoginTest_001 extends BaseClass {
@Test
	public void logintest() throws InterruptedException, IOException {
	
		
		driver.get(baseurl);
		logger.info("url opened");
		
		LoginPage l=new LoginPage(driver);
		
		l.setUsername(username);
		logger.info("Entered username");
		l.setPass(password);
		//Thread.sleep(5000);
		logger.info("url opened");
		l.login();
		Thread.sleep(5000);
		System.out.println("hi");
		//String url=driver.getCurrentUrl();
		//System.out.println("title is "+url);
		
		logger.info("Entred passsword0");
		System.out.println("correct");
		if(isAlert(driver)==false){
			
			Assert.assertTrue(true);
			logger.info("testpassed");
			
		}
		else {
			logger.info("testfailed");
			captureScreenshot(driver,"logintest");
			System.out.println("screenshot1");
		
			Assert.assertTrue(false);
	
		}
	
		
		
	}
public boolean isAlert(WebDriver driver) {
	try
	{
	driver.switchTo().alert().accept();
	driver.switchTo().defaultContent();
	
	return true;
	}
	catch(NoAlertPresentException e)
	{
		return false;
	}
	}}
	

