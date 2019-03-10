package com.TwoPlugs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class complaintUserPage {

	
	public WebDriver ldriver;
	public complaintUserPage(WebDriver rdriver)

	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Report A User')]")
	WebElement title;
	
	public String getTitle()
	{
		return title.getText();
		
	}
}
