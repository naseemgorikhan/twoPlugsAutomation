package com.TwoPlugs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class profilePage {
	
	public WebDriver ldriver;
	public profilePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this );
	}

	@FindBy(xpath="/html/body/div[7]/div[4]/div[1]/div[1]/div/div[1]/div/a[2]")
	WebElement editLink;
	
	
	
	@FindBy(xpath="/html/body/div[7]/div/form/div[1]/nav/ul/li[1]/a")
	WebElement pageLink;
	
	@FindBy(xpath="//*[@id='page']/div/div[2]/div/input[1]")
	WebElement userName;
	
	@FindBy(xpath="//*[@id='page']/div/div[1]/div[2]/button")  
	WebElement profileLink;
	
	@FindBy(xpath="//*[@id='profile']/div/div[2]/div/input")
	WebElement lastName;
	
	@FindBy(xpath="//*[@id='profile']/div/div[3]/div/ul/li[2]/label/span[1]")
	WebElement FemaleBtn;
	
	@FindBy(xpath="/html/body/div[7]/div/form/div[1]/div[2]/div[2]/a")
	WebElement nextLink;
	
	@FindBy(xpath="//*[@id='profileImageUpload']/div/span")
	WebElement dropFile;
	
	
	@FindBy (xpath="//*[@id='page']/div/div[1]/div[2]/button")
	WebElement t;
	
	public void clickPageLink()
	{
	   pageLink.click();
	}

	public void clickNextLink()
	{
		nextLink.click();
	}
	
	
	public void clickEditLink()
	{
		editLink.click();
	}
	
	public void clickProfileLink()
	{
	   profileLink.click();
	}
	
	public void changeUserName(String n)
	{
		userName.sendKeys(n);
	}

	public void clickonDropFile()
	{
		dropFile.click();
	}
	
	public void clickchangeuploadpic()
	{
		t.click();
	}
	public void profileLinkCick() throws InterruptedException, FindFailed
	{
		
		System.out.println("pppp");
		//using sikuli
		String iamgesFilepath="C:\\Users\\nasee\\OneDrive\\Desktop\\Old Firefox Data";
	//	String inputFilepath="C:\\Users\\nasee\\OneDrive\\Desktop\\test";
		
		String inputFilepath="C:\\Users\\nasee\\OneDrive\\Desktop\\Old Firefox Data";
		Screen s= new Screen();
		
		Pattern fileinputTextbox= new Pattern(iamgesFilepath + "file.PNG");
		
		Pattern openBtn= new Pattern(inputFilepath + "open.PNG");
		
		Thread.sleep(5000);
		
		s.wait(fileinputTextbox, 20);
		s.type(fileinputTextbox, inputFilepath + "bid.png");
		s.click(openBtn);
		
	}
	
	
}
