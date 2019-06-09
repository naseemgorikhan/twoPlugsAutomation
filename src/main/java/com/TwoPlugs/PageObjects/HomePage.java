package com.TwoPlugs.PageObjects;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver ldriver;
	public HomePage(WebDriver rdriver)

	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	// Git comment
	@FindBy(xpath="//div[@class='name']")
	WebElement uname;
	
	@FindBy(xpath="//span[contains(text(),'Messages')]")
	WebElement messagesLink;
	
	@FindBy(xpath="//span[contains(text(),'Transactions')]")
	WebElement transactionLink;
	
	
	@FindBy(xpath="//div[@class='profile-information']/ul[@class='location']/li[2]/span")
	WebElement userLocation;
	
	@FindBy(xpath="/html/body/div[7]/nav/div/div[2]/ul/li[4]/a/span[2]")
	WebElement HiUserLink;
	
	@FindBy(xpath="/html/body/div[7]/nav/div/div[2]/ul/li[4]/ul/li[1]/a/span[2]")
	WebElement userProfileLink;
	
	@FindBy(xpath="/html/body/div[7]/nav/div/div[2]/ul/li[4]/ul/li[2]/a/span[2]")
	WebElement userSettingLink;
	
	@FindBy(xpath="/html/body/div[7]/nav/div/div[2]/ul/li[4]/ul/li[3]/a/span[2]")
	WebElement userSignoutLink;
	
	@FindBy(xpath="/html/body/div[7]/nav/div/div[2]/ul/li[4]/ul/li[4]/a/span[2]")
	WebElement userHelpLink;
	
	@FindBy(xpath="/html/body/div[7]/nav/div/div[2]/ul/li[4]/a/span[2]")
	WebElement hiuserLink;
	 
	 @FindBy(xpath="//*[@id='followingsNumber']")
	 WebElement followingLink;
	 
	 public void clickProfile()
	 {
		Actions act= new Actions(ldriver);
		act.moveToElement(hiuserLink).click().build().perform();
		Actions act1= new Actions(ldriver);
		act1.moveToElement(userProfileLink).click().build().perform();
		
	 }
	 
	 public void clickOnFollowingLink()
	 {
		 followingLink.click();
	 }
	 
	 public String  getUnameText()
	 {
		return uname.getText(); 
	 }
	
	
	public boolean checkUserMenuDropDownLinks() throws InterruptedException
	{
		Actions act= new Actions(ldriver);
		act.moveToElement(userProfileLink);
	
		
		String t=userProfileLink.getText();
	//	System.out.println(t);
		
		act.moveToElement(userSettingLink);
		String t1=userSettingLink.getText();
	//	System.out.println(t1);
		
		act.moveToElement(userHelpLink);
		String t3=userHelpLink.getText();
		//System.out.println(t3);
		
		act.moveToElement(userSignoutLink);
		String t2=userSignoutLink.getText();
	//	System.out.println(t2);
		
		if(t.equals("Profile") && t1.equals("Settings") && t2.equals("Sign Out") && t3.equals("Help"))
		
			return true;
		else
			return false;
		
	}
	
	@FindBy(xpath="//a")
	List <WebElement> allaLinks;
	
	public void getallLinks()
	{
		List <WebElement> list= allaLinks;
		
		int s= list.size();
		System.out.println(s);
		
		for(int i= 0; i<10; i++)
			System.out.println(list.get(i).getText());
		
	}
	
	
	public void  MoveonUserName() throws InterruptedException
	{
		Actions act = new Actions(ldriver);
		act.moveToElement(HiUserLink);
		act.click().build().perform();
		Thread.sleep(3000);
	}
	
	public void clickMessageLink()
	{
		messagesLink.click();
	}
	
	public String getUserLocationn() 
	{
		String loc=userLocation.getText();
		System.out.println(loc);
		System.out.println(loc.length());
		
		
		String loca=loc.substring(7,14);
		System.out.println("userlocation " + loca);
		return loca;

	}
	
	
	public String getUserLocationTime() 
	{
		String time="";
		String loc=userLocation.getText();
		System.out.println(loc);
		System.out.println(loc.length());
		
		String loca=loc.substring(7,14);
		System.out.println("user" + loca);
		//return loc;
		
		 time=loc.substring(0,6);
		System.out.println("user" + time);
		
		
		return time;

	}
	
	public String getLocalTime()
	{
		 LocalTime localTime = LocalTime.now();
		 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("h:mm a");
		 System.out.println(localTime.format(dateTimeFormatter));
		 return localTime.format(dateTimeFormatter);
	}
}
