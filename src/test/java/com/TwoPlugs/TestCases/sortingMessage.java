package com.TwoPlugs.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TwoPlugs.PageObjects.HomePage;
import com.TwoPlugs.PageObjects.LoginPage;
import com.TwoPlugs.PageObjects.MessagePage;


public class sortingMessage extends BaseClass {
	
	@Test
	public void sortMessages() throws InterruptedException, IOException
	{
		SoftAssert softassert= new SoftAssert();
		
		LoginPage lp= new LoginPage(driver);
		MessagePage message = new MessagePage(driver);
		HomePage hp= new HomePage(driver);
		boolean sortResult;
		
		lp.loginClick();
		logger.info("Logging into two plugs site");
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		logger.info("Valid username and password are entered, Login is clicked");
		
		
		hp.clickMessageLink();
		logger.info("Messages icon clicked");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		message.clickDropList();
		message.GetNameBeforesort("name");
		message.clickDropName();
		logger.info("Name selected from dropdown ");
		
		sortResult=message.AfterSort("name");
		
	   //Assertions
		if(sortResult==false)
		{
			softassert.assertTrue(true);
			logger.info("Messages are sorted by Name");
			logger.info("Test case passed for sort by name ");
			
		}
		
		else
		{
			captureScreenshot(driver, "sortMessages");
			softassert.assertTrue(false);
			logger.info("Test case failed for sort by name ");
			
		}

		message.clickDropList();
		message.GetNameBeforesort("date");
		message.clickDropDate();
		logger.info("Date selected from dropdown ");
		 sortResult=message.AfterSort("date");
		//Assertions
				if(sortResult==false)
				{
					softassert.assertTrue(true);
					logger.info("Messages are sorted by Date");
					logger.info("Test case passed for sort by Date ");
					
				}
				
				else
				{
					captureScreenshot(driver, "sortMessages");
					softassert.assertTrue(false);
					logger.info("Test case failed for sort by Date ");
					
				}
		softassert.assertAll();
	}

}
