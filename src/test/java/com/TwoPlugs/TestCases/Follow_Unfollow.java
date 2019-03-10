package com.TwoPlugs.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TwoPlugs.PageObjects.LoginPage;

public class Follow_Unfollow extends BaseClass{
	
	int noff, newff;
		@Test(priority=1)
		@Parameters({"unamep", "passp"})
		public void follow(String uname1, String pass1) throws InterruptedException
		{
			
			//Click on Login in menu
			driver.findElement(By.xpath
					("//body[@class='main-template']/div[@class='wrapper']/header/div[@class='container']/ul[@class='control-bar']/li[1]/a[1]")).click();
			//Call login page and send uname and pass
				LoginPage lp = new LoginPage(driver);
				lp.setUserName(uname1);
				lp.setPassword(pass1);
				lp.clickLogin();
			
				 String nof =driver.findElement(By.xpath("//*[@id='followingsNumber']")).getText();  // get no of followers from main page
				 noff=Integer.parseInt(nof);
				 
				// System.out.println(noff);
					// click on follow in navigation menu
					driver.findElement(By.xpath("//a[@id='followersNumber']")).click();	
					Thread.sleep(6000);
				
					
				    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//ul[@id='followed']//li[1]//div[1]//div[3]//ul[1]/li[@id='followIcon']/a")).click();//click on follow
					
					driver.findElement(By.xpath("//div[@id='followModal']//div[@class='modal-content']")); 
					driver.findElement(By.xpath("//*[@id='profile_btn_follow']/span")).click();//click on confirm
			
					//Assertion to check if you are in followers page
					SoftAssert softassert = new SoftAssert();
					String actual=driver.findElement(By.xpath("//span[contains(text(),'Followers')]")).getText();
					String expected="Followers";
					softassert.assertEquals(actual, expected, "Yor are in Followers page");
					 logger.info("You are in followers page");	
					 
				  //Assertion to check follow click works
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'You are now following user')]"))));
					String act=driver.findElement(By.xpath("//div[contains(text(),'You are now following user')]")).getText();
					String exp="You are now following user";
					softassert.assertEquals(act, exp);
					logger.info("Following success");
					
					driver.findElement(By.xpath("//img[@src='/newlayout/icons/logo.png']")).click();//Back to main user page
					Thread.sleep(4000);
					
					 String newf =driver.findElement(By.xpath("//*[@id='followingsNumber']")).getText();  // get no of followers from main page
					   newff=Integer.parseInt(newf);
					//  System.out.println(newff);
					  //Assertions
					        if(noff<newff)
					        {
					        	Assert.assertTrue(true);
					        	logger.info("No of followers has increased after follow");
					        }
					        else
					        {
					        	Assert.assertTrue(false);
					        	logger.info("Test case has failed for followers");
					        }
				softassert.assertAll();
				
				Thread.sleep(5000);
		}

	 @Test(priority =2, dependsOnMethods="follow")
		public void UnFollow() throws InterruptedException
		{
		 
		// click on follow in navigation menu
			driver.findElement(By.xpath("//a[@id='followersNumber']")).click();	
			
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//ul[@id='followed']//li[1]//div[1]//div[3]//ul[1]/li[@id='followIcon']/a")).click();//click on follow
			
			driver.findElement(By.xpath("//div[@id='followModal']//div[@class='modal-content']")); 
			driver.findElement(By.xpath("//*[@id='profile_btn_follow']/span")).click();//click on confirm
			
			
			//Assertion to check if you are in followers page
			SoftAssert softassert = new SoftAssert();
			String actual=driver.findElement(By.xpath("//span[contains(text(),'Followers')]")).getText();
			String expected="Followers";
			softassert.assertEquals(actual, expected, "Yor are in Followers page");
			 logger.info("You are in followers page");	
			 
		  //Assertion to check follow click works
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'You are no longer follow user')]"))));
			String act=driver.findElement(By.xpath("//div[contains(text(),'You are no longer follow user')]")).getText();
			String exp="You are no longer follow user";
			softassert.assertEquals(act, exp);
			logger.info("UnFollow test case success");
			
			
			driver.findElement(By.xpath("//img[@src='/newlayout/icons/logo.png']")).click();//Back to main user page
			Thread.sleep(4000);
			
			 String newf =driver.findElement(By.xpath("//*[@id='followingsNumber']")).getText();  // get no of followers from main page
			int   unf=Integer.parseInt(newf);
			//  System.out.println(unf);
			  //Assertions
			        if(unf<newff)
			        {
			        	Assert.assertTrue(true);
			        	logger.info("No of followers has decreased after unfollow");
			        }
			        else
			        {
			        	Assert.assertTrue(false);
			        	logger.info("test case fail for unfollowers");
			        }
			
		}


}
