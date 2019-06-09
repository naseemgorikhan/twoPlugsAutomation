/**
 * 
 */
package com.TwoPlugs.TestCases;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TwoPlugs.PageObjects.HomePage;
import com.TwoPlugs.PageObjects.LoginPage;
import com.TwoPlugs.PageObjects.MessagePage;
import com.TwoPlugs.PageObjects.profilePage;

/**
 * @author naseem.akhtar
 *
 */
public class profile extends BaseClass {
	
	@Test
	public void profileimageupload() throws InterruptedException, FindFailed, AWTException
	
	{
		  SoftAssert softassert= new SoftAssert();
	        
			LoginPage lp= new LoginPage(driver);
			MessagePage message = new MessagePage(driver);
			HomePage hp= new HomePage(driver);
			profilePage pf= new profilePage(driver);
			
			
			
			lp.loginClick();
			logger.info("Logging into two plugs site");
			lp.setUserName(username);
			lp.setPassword(password);
			lp.clickLogin();
			logger.info("Valid username and password are entered, Login is clicked");
			
			hp.clickProfile();
			
		//	pf.clickPageLink();
			pf.clickEditLink();
			Thread.sleep(3000);
			pf.clickPageLink();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			pf.clickchangeuploadpic();
			Thread.sleep(3000);
	   
	     	pf.clickonDropFile();
	      	pf.profileLinkCick();
		
			
			
	}
	

}
