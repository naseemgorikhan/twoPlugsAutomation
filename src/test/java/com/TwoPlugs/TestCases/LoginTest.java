package com.TwoPlugs.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TwoPlugs.PageObjects.LoginPage;

public class LoginTest extends BaseClass{

	
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		driver.get(baseURL);
		//Click on Login in menu
		driver.findElement(By.xpath
				("//body[@class='main-template']/div[@class='wrapper']/header/div[@class='container']/ul[@class='control-bar']/li[1]/a[1]")).click();
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();  //click on login 
		 Thread.sleep(4000);
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Assertions
		String acturl=driver.getCurrentUrl();
		String exp="https://qatest.twoplugs.com/home";
		if(acturl.equals(exp))
		{
		Assert.assertTrue(true);
		logger.info("Test case passed");
		}
		else
		{
		
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
		logger.info("Test case failed");
		}
		
	}


}
