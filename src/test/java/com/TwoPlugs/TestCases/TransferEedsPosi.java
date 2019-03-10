package com.TwoPlugs.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TwoPlugs.PageObjects.LoginPage;
import com.TwoPlugs.PageObjects.TransferEeedsPage;

public class TransferEedsPosi extends BaseClass {

		@Test
	//	@Parameters({"unamep", "passp"})
		public void transeferEedsPosi() throws InterruptedException, IOException
		{
			String amount_to_transfer="1";
			int amt_tras=Integer.parseInt(amount_to_transfer);
			
			//Click on Login in menu
			driver.findElement(By.xpath
					("//body[@class='main-template']/div[@class='wrapper']/header/div[@class='container']/ul[@class='control-bar']/li[1]/a[1]")).click();
			//Call login page and send uname and pass
				LoginPage lp = new LoginPage(driver);
				lp.setUserName(username);
				lp.setPassword(password);
				lp.clickLogin();
				
				// click on follow in navigation menu
				driver.findElement(By.xpath("//a[@id='followersNumber']")).click();	
				
				TransferEeedsPage transfereed= new TransferEeedsPage(driver);// create an object of transefr eeds page
				
				Thread.sleep(4000);
				String uname2= driver.findElement(By.xpath("//*[@id='followed']/li[1]/div/div[2]/a")).getText();
				System.out.println("uname" + uname2);
				
				transfereed.clickonTransfereedsLink(); //click on transfer eeds link
			
				
				transfereed.enterAndTransferEeds(amount_to_transfer);  //enter the amount and click on transfer 
			
				 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//div[@id='TransdferModal']//div[@class='modal-content']"));// dialog window
				driver.findElement(By.xpath("//div[@class='form-group clearfix']/ul/li[2]/a[@id='btn_transfer']")).click();//confirm 
				
			//	Thread.sleep(4000);
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'Credit Transfer was successful')]"))));
				
				//Assertions
				
				//Thread.sleep(4000);
				String act=driver.findElement(By.xpath("//div[contains(text(),'Credit Transfer was successful')]")).getText();
				String exp="Credit Transfer was successful";
				SoftAssert softassert = new SoftAssert();
				softassert.assertEquals(act, exp, " Transfer eeds success");
				logger.info("transfer eeds success");
				
				//Back to transaction page
				driver.findElement(By.xpath("//span[contains(text(),'Transactions')]")).click();
				Thread.sleep(5000);
				
				String sender=driver.findElement(By.xpath("/html/body/div[7]/div[1]/table[2]/tbody/tr[1]/td[2]")).getText();// sent person name
				String receiver=driver.findElement(By.xpath("/html/body/div[7]/div[1]/table[2]/tbody/tr[1]/td[3]")).getText();// received person name
				String amt = driver.findElement(By.xpath("/html/body/div[7]/div[1]/table[2]/tbody/tr[1]/td[5]")).getText();// amount sent
				
				System.out.println(sender  + " " + receiver + " " + amt);
				System.out.println(amt.length());
				String am1= amt.substring(2,3);
				int am2=Integer.parseInt(am1);
				System.out.println(am2);
				//am2=9;
		  	System.out.println("uname1 " + username);
			     //Assertion to check if teh transaction appears on page
				if(receiver.equals(uname2)  && sender.equalsIgnoreCase(username) && am2==amt_tras)
						{
					      softassert.assertTrue(true);
					      logger.info("trasaction page shows the transaction done- Test case pass");
						}
				else
				{
					captureScreenshot(driver, "transeferEedsPosi");
					softassert.assertTrue(false);
				      logger.info("trasaction page does not shows the transaction done test case failed");
				}
					
				
		}
		}
