package com.TwoPlugs.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

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
	
	@FindBy(xpath="//span[contains(text(),'Drop files here to upload')]")
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
		System.out.println("new");
		dropFile.click();
	}
	
	public void clickchangeuploadpic()
	{
		System.out.println("t clicked");
		t.click();
	}
	
	@FindBy(xpath="//button[@id='performCrop']")
	WebElement cropbtn;
	
	@FindBy(xpath="//a[contains(text(),'Next')]")
	WebElement nextbtn;
	
	@FindBy(xpath="//button[@class='btn btn-success w-btn-success']/span[text()='SAVE CHANGES']")
	WebElement saveChagebtn;
	
	public void profileLinkCick() throws InterruptedException, FindFailed, AWTException
	{
		
		
		System.out.println("pppp");
		
		Robot robot = new Robot();
		robot.setAutoDelay(2000);
		StringSelection string1= new StringSelection("C:\\Users\\nasee\\OneDrive\\Desktop\\Old Firefox Data\\rr.JPG");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string1,null);
		
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		cropbtn.click();
		Thread.sleep(2000);
		//nextbtn.click();
		saveChagebtn.click();
		
		
		//using sikuli
		//String iamgesFilepath="C:\\Users\\nasee\\OneDrive\\Desktop\\Old Firefox Data";
		
/*		try
		{
	String inputFilepath="C:\\Users\\nasee\\OneDrive\\Desktop\\Old Firefox Data\\file1.png";
		
		String openFilepath="C:\\Users\\nasee\\OneDrive\\Desktop\\Old Firefox Data\\open1.png";
		

		Screen s= new Screen();
		
		Pattern fileinputTextbox= new Pattern(inputFilepath);
		
		Pattern openBtn= new Pattern(openFilepath);
		
		Thread.sleep(5000);
		
		s.wait(fileinputTextbox, 30);
		s.type(fileinputTextbox, "C:\\Users\\nasee\\OneDrive\\Desktop\\Old Firefox Data\\bid.png");
		s.click(openBtn);
		
		}
		catch(ExceptionInInitializerError e)
		{
			System.out.println("there is an error");
		}
		
		
		
		
		
		
		
	 */
	
	}
}
