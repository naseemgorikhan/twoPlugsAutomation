package com.TwoPlugs.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.TwoPlugs.PageObjects.LoginPage;
import com.TwoPlugs.PageObjects.TransferEeedsPage;

import junit.framework.Assert;

public class TransferEedsNeg extends BaseClass{

	@Test
	@Parameters({"unamep", "passp"})
	public void TransferEedsNega(String uname1, String pass1)
	{
		//Click on Login in menu
		driver.findElement(By.xpath
				("//body[@class='main-template']/div[@class='wrapper']/header/div[@class='container']/ul[@class='control-bar']/li[1]/a[1]")).click();
		//Call login page and send uname and pass
			LoginPage lp = new LoginPage(driver);
			lp.setUserName(uname1);
			lp.setPassword(pass1);
			lp.clickLogin();
			
			// click on follow in navigation menu
			driver.findElement(By.xpath("//a[@id='followersNumber']")).click();	
			
			TransferEeedsPage transfereed= new TransferEeedsPage(driver);// create an object of transefr eeds page
			
			transfereed.clickonTransfereedsLink(); //click on transfer eeds link
			
			
			transfereed.enterAndTransferEeds("100");  //enter the amount and click on transfer 
			
			 driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//div[@id='TransdferModal']//div[@class='modal-content']"));// dialog window
				driver.findElement(By.xpath("//div[@class='form-group clearfix']/ul/li[2]/a[@id='btn_transfer']")).click();//confirm 
				
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='alert alert-danger text-center']"))));
				//Assertions
				String act=driver.findElement(By.xpath("//div[@class='alert alert-danger text-center']")).getText();
				if(act.contains("THE AMOUNT MUST BE BETWEEN "))
				{
					Assert.assertTrue(true);
					logger.info("TEst case for Negative Transfer eeds pass");
				}
				else
				{
					Assert.assertTrue(false);
					logger.info("TEst case for Negative Transfer eeds fail");
				}
		
	}
}
