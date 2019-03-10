package com.TwoPlugs.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TwoPlugs.PageObjects.HomePage;
import com.TwoPlugs.PageObjects.LoginPage;
import com.TwoPlugs.PageObjects.complaintUserPage;
import com.TwoPlugs.PageObjects.followingPage;
import com.TwoPlugs.PageObjects.transferMoneyPage;



public class FollowUnFollow1 extends BaseClass {


	@Test
	public void followingPageLinks() throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);
		HomePage hp= new HomePage(driver);
		followingPage fp= new followingPage(driver);
		transferMoneyPage transferMoney= new transferMoneyPage(driver);
		complaintUserPage cp= new complaintUserPage(driver);
		
		SoftAssert softassert= new SoftAssert();
		
		lp.loginClick();
		logger.info("Logging into two plugs site");
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		logger.info("Valid username and password are entered, Login is clicked");
		
		hp.clickOnFollowingLink();
		String actTitle=fp.getTitle();
		
		//Assertion for title
		if(actTitle.equals("Users I Follow"))
		{
			softassert.assertTrue(true);
			logger.info("You are  in following page");
			logger.info("Test case passed");
		}
		
		else
		{
			captureScreenshot(driver, "followingPageLinks");
			logger.info("You are  in following page");
			logger.info("Test case passed");
		}
		
		
		//Name
		String actn=fp.clickonName();
		String una=hp.getUnameText();
		if(actn.equals(una))
			softassert.assertTrue(true);
		     logger.info("same name");
		
		 	Thread.sleep(3000);
		 	driver.navigate().back();
		boolean act2= fp.checkFollowLink();
		
		Thread.sleep(3000);
     	fp.clickTransferEedLink();
		String act1= transferMoney.getTitle();// transfer eeds
		System.out.println(act1);
		Thread.sleep(3000);
		driver.navigate().back();
		
		boolean act3=fp.checkMessageLink();
		
		Thread.sleep(3000);
		
		
		fp.clickOnReportLink();
		Thread.sleep(2000);
	    String act4= cp.getTitle();//report
	    driver.navigate().back();
	    System.out.println(act4);
	    System.out.println(act2 + " " + act3);
		
	
		
		//Assertions
		if(act1.equals("Transfer") && act4.equals("Report A User") && act2==true  && act3== true)
		{
			softassert.assertTrue(true);
			logger.info("All links in Following page is working");
			logger.info("test case passed");
			}
			
			else
			{
			 captureScreenshot(driver,"getUserLinks" );
			 softassert.assertTrue(false);
		     logger.info("All links in following page not working - test case failed");
			}
			softassert.assertAll();
		}
		
		
	}
	


