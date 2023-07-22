package com.eBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;


import io.github.bonigarcia.wdm.WebDriverManager;

import com.eBanking.utilities.*;


public class BaseClass {
	
	static ReadConfig r=new ReadConfig();

	public  WebDriver driver;
	
	public  String baseurl=r.getUrl();
	
	public   String username=r.getUser();
	
	public  String password =r.getPass();
	public static Logger logger;
	
	
@Parameters("browser")	
@BeforeClass
	
	public void Setup(String br) {
	 logger=Logger.getLogger("EBanking");
	 
	 PropertyConfigurator.configure("log4j.properties");
	 
		System.out.println("correct");
		
		if(br.equals("chrome")) {
			
WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		 
		}
		else if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
			 driver=new FirefoxDriver();
			 
			}
		else if(br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			
			 driver=new EdgeDriver();
			 
			}
		else {
			
			WebDriverManager.chromedriver().setup();
			
			 driver=new ChromeDriver();
		}
		
		
		 
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public void captureScreenshot(WebDriver driver,String s) throws IOException {
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+s+".png";
		 TakesScreenshot ts=(TakesScreenshot)driver; 
	     File scrFile = ts.getScreenshotAs(OutputType.FILE); 
	    
	     File desFile = new File(screenshotPath); 
	     
	     FileUtils.copyFile(scrFile, desFile);
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}
