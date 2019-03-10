package com.TwoPlugs.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TwoPlugs.PageObjects.HomePage;
import com.TwoPlugs.PageObjects.LoginPage;
import com.TwoPlugs.PageObjects.MessagePage;

public class userLinks extends BaseClass {
	
	
	@Test
	public void getUserLinks() throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);
		HomePage hp= new HomePage(driver);
		SoftAssert softassert= new SoftAssert();
		
		lp.loginClick();
		logger.info("Logging into two plugs site");
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		logger.info("Valid username and password are entered, Login is clicked");
		
		hp.MoveonUserName();
		boolean result=hp.checkUserMenuDropDownLinks();
		
		if(result==true)
		{
		softassert.assertTrue(true);
		logger.info("The user dropdown link has all menus");
		logger.info("test case passed");
		}
		
		else
		{
		 captureScreenshot(driver,"getUserLinks" );
		 softassert.assertTrue(false);
	     logger.info("The user dropdown link has all menus- Test case failed");
		}
		softassert.assertAll();
		
	//	hp.getallLinks();
		}
	
	
	}


