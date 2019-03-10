package com.TwoPlugs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class transferMoneyPage {

	
	public WebDriver ldriver;
	public transferMoneyPage(WebDriver rdriver)

	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//h2[@class='pushH2']//span[@class='help'][contains(text(),'Transfer')]")
	    WebElement transferMoneyTitle;
	
	
	public String getTitle()
	{
	    	
		return transferMoneyTitle.getText();
		
	}
}
