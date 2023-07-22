package com.eBanking.testCases;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.*;
import com.eBanking.utilities.XLUtils;
public class TC_DDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		driver.get(baseurl);
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(user);
		logger.info("user name provided");
		lp.setPass(pwd);
		logger.info("password provided");
		lp.login();
		
		Thread.sleep(3000);
		System.out.println("cap3");
		if(isAlert(driver)==true)
		{
			System.out.println("cap4");
			
			System.out.println("cap");
			captureScreenshot(driver,"loginDDT");
			Thread.sleep(4000);
			System.out.println("cap");
			Assert.assertTrue(false);
			//Thread.sleep(4000);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			
			lp.logout() ;
			
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/eBanking/testData/LoginData (2).xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
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
		}
}
