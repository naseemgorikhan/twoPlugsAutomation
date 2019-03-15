/**
 * 
 */
package com.TwoPlugs.TestCases;

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
	public void profileimageupload() throws InterruptedException, FindFailed
	
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
			pf.clickPageLink();
			pf.clickchangeuploadpic();
	     	pf.profileLinkCick();
			
			//driver.findElement(By.xpath("/html/body/div[7]/nav/div/div[2]/ul/li[4]/ul/li[1]/a/span[2]")).click();
			
			
	}
	

}
