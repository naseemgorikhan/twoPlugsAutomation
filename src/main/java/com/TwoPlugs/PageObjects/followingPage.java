package com.TwoPlugs.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class followingPage {

	  public WebDriver ldriver;
	public  followingPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="/html/body/div[7]/div[1]/h2/span")
	WebElement followingPageTitle;
	
	@FindBy(xpath="//*[@id='followed']/li[1]/div/div[2]/a")
	WebElement followingUserName;
	
	
	@FindBy(xpath="//ul[@id='followed']//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]//span[1]")
	WebElement followLink;
	
	@FindBy(xpath="//*[@id='followed']/li[1]//div[3]/ul/li[2]/a/span")
	WebElement transferEedsLink;
	
	@FindBy(xpath="//*[@id='followed']/li[1]//div[3]/ul/li[3]/a/span")
	WebElement MessageLink;
	
	@FindBy(xpath="//*[@id='followed']/li[1]//div[3]/ul/li[4]/a/span")
	WebElement ReportLink;
	
	public void clickOnReportLink()
	{
		ReportLink.click();
	}
	
	public String getTitle()
	{
	
		String title=followingPageTitle.getText();
		return title;
	}
	
	@FindBy(xpath="//a[@id='profile_btn_follow']")
	WebElement confirmtoFollowBtn;

	@FindBy(xpath="//*[@id='followModal']/div/div")
	WebElement windowFollow;
	
	
	@FindBy(xpath="//div[@id='message_form']//div[@class='modal-dialog']")
	WebElement WindMessage;
	
	
	@FindBy(xpath="//*[@id='followModal']/div/div/div/button/span")
			WebElement close;
	
	@FindBy(xpath="//*[@id='message_form']/div/div/div/button/span")
	WebElement closeM;
	
	@FindBy(xpath="//*[@id='followed']/li[1]/div/div[2]/a")
	WebElement followName;
	
	
	public String clickonName()
	{
		String unn=followName.getText();
		followName.click();
		return unn;
	}
	
	public void clickTransferEedLink()
	{
		transferEedsLink.click();
	}
	public boolean checkFollowLink() throws InterruptedException
	{
		
		boolean follow= false;
		followLink.click();
		WebDriverWait wait = new WebDriverWait(ldriver, 10);
		wait.until(ExpectedConditions.visibilityOf(windowFollow));
		if(windowFollow.isDisplayed())
			follow= true;
		Thread.sleep(4000);
		close.click();
		System.out.println(follow);
		  return follow;
		
	}
	
	public boolean checkMessageLink() throws InterruptedException
	{
		boolean  message = false;
		MessageLink.click();
		WebDriverWait wait = new WebDriverWait(ldriver, 10);
		wait.until(ExpectedConditions.visibilityOf(WindMessage));
		if(WindMessage.isDisplayed())
			message= true;
		Thread.sleep(4000);
		closeM.click();
		System.out.println(message);
		  return message;
		
	}
}
