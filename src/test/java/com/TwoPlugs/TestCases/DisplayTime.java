package com.TwoPlugs.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TwoPlugs.PageObjects.HomePage;
import com.TwoPlugs.PageObjects.LoginPage;
import com.TwoPlugs.PageObjects.MessagePage;

public class DisplayTime extends BaseClass{


	@Test
	public void checkTime() throws IOException, InterruptedException
	{
        SoftAssert softassert= new SoftAssert();
        String utime;
		String ltime;
		LoginPage lp= new LoginPage(driver);
		MessagePage message = new MessagePage(driver);
		HomePage hp= new HomePage(driver);
		
		
		lp.loginClick();
		logger.info("Logging into two plugs site");
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		logger.info("Valid username and password are entered, Login is clicked");
		 utime=hp.getUserLocationTime();
	     ltime=hp.getLocalTime();
		String lo=hp.getUserLocationn();
		
		if(lo.equals("Toronto")==false)
		{
		
		if((utime.equals(ltime)) == false)
		{
			softassert.assertTrue(true);
			logger.info("user's local time is displayed");
			logger.info("test case passed");
		}
		else
		{
			captureScreenshot(driver, "checkTime");
			softassert.assertTrue(false);
			logger.info("test case failed");
			
		}
		}
		
			if(lo.equals("Toronto")==true)
			{
				if((utime.equals(ltime)) == false)
				{
				softassert.assertTrue(true);
				logger.info("user local time is displayed toronto");
				logger.info("test case passed for to");
			}
			}
			
			softassert.assertAll();
		
	}
	

}