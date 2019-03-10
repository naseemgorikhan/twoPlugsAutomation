package com.TwoPlugs.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferEeedsPage {

	public WebDriver ldriver;
	public TransferEeedsPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(xpath="//*[@id='followed']/li[1]//div[3]/ul/li[2]/a/span")
	WebElement transferEedLink;   //transfer Eedlink in followers page
	
	@FindBy(xpath="//*[@id='transferAmount']")
	WebElement transferAmt;   //transfer amount field
	
	@FindBy(xpath="//*[@id='followed']/li[1]/div/div[2]/a")
	WebElement uName;   //sender name
	
	@FindBy(xpath="//a[@id='transfer_id']")
	WebElement transferBtn;      //transfer button
	
	
	@FindBy(xpath="//div[contains(text(),'Credit Transfer was successful')])")
	WebElement alertWind;
	

	
	
	//click on trasnfer eeds link 
	public void clickonTransfereedsLink()
	{
		transferEedLink.click();
	}
	
	//Transfer eeds method
	public void enterAndTransferEeds(String a)
	{
		transferAmt.sendKeys(a);
	
		transferBtn.click();;
		
	}
	
	//Get the text from alert window
	public String getTextfromAlertWind()
	{
		return alertWind.getText();
	}
	
	//get sendname 
	public String receiverName()
	{
		return uName.getText();
	}
	
	
	
}
