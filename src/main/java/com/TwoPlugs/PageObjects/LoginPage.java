package com.TwoPlugs.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

     @FindBy(xpath="/html/body/div/header/div/ul/li[1]/a")
	 WebElement loginLink;
	 public void loginClick() throws InterruptedException
	 {
		 loginLink.click();
	
	 }
     
	
	@FindBy(xpath="//input[@name='email']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath="//input[@id='signInPassword']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'LOG IN')]")
	@CacheLookup
	WebElement loginButton;
	

	//Action Methods
	
	public void setUserName(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickLogin()
	{
	loginButton.click();
	}
}
