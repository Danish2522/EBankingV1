package com.eBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtusername;
		
	@FindBy(name="password")
	@CacheLookup
	WebElement pass;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnlogin;
	@FindBy(xpath="//a[@href='Logout.php']")
	@CacheLookup
	WebElement logout;
	
	public void setUsername(String uname) {
		txtusername.clear();
		txtusername.sendKeys(uname);}
	
public void setPass(String password) {
		
		pass.sendKeys(password);}


public void login() {
	
	btnlogin.click();}

public void logout() {
	
	btnlogin.click();}
}
