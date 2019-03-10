package com.TwoPlugs.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FollowUnFollowPage {
	
	public WebDriver ldriver;
	public FollowUnFollowPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//follow link in navigation menu
	@FindBy(xpath="//a[@id='followersNumber']")
	WebElement followerLink;
	

	@FindBy(xpath="//ul[@id='followed']//li[1]//div[1]//div[3]//ul[1]/li[@id='followIcon']/a") //click on follow)
	WebElement followLink;
	
	
	@FindBy(xpath="//div[@id='followModal']//div[@class='modal-content']") 
	WebElement alertmsgwind;
	
	@FindBy(xpath="//*[@id='profile_btn_follow']/span")//click on confirm
	WebElement confirmBtn;
	
	
	 @FindBy(xpath="//*[@id='followingsNumber']")
	 WebElement followingTxt;
	 
	 
	 public String getFollowersno()
	 {
		 String folNo=followerLink.getText();  //get follower no
		 return folNo;
	 }
	 
	 public void clickonFollow()
	 {
		 followLink.click();
		 confirmBtn.click();
	 }
	 
	 
	
}
