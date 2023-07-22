package com.eBanking.utilities;

import java.util.Properties;
import java.io.*;
public class ReadConfig {
	
	 Properties pro;
	public ReadConfig() {
		
		
		File src=new File("./Configuration/config.properties");
		try {
			
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		
	
		catch(Exception e) {
			
			System.out.println("Exception is :"+e.getMessage());
			
		}

		
		
}
	
	public String getUrl() {
		
		return pro.getProperty("baseurl");
		
		
	}
	
public String getUser() {
		
		return pro.getProperty("username");
		
		
	}
public  String getPass() {
	
	return pro.getProperty("password");
	
	
}

}

