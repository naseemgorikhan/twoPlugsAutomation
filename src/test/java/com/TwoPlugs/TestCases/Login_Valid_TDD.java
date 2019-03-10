package com.TwoPlugs.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.TwoPlugs.PageObjects.LoginPage;
import com.TwoPlugs.Utilities.XLUtils;

public class Login_Valid_TDD extends BaseClass {
	
@Test(dataProvider="loginV")
public void LoginValidData(String uname1, String pass1)
{
	//Click on Login in menu
			driver.findElement(By.xpath
					("//body[@class='main-template']/div[@class='wrapper']/header/div[@class='container']/ul[@class='control-bar']/li[1]/a[1]")).click();
	//Call login page and send uname and pass
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(uname1);
	lp.setPassword(pass1);
	lp.clickLogin();
	
	//Assertions
		  String actualurl=  driver.getCurrentUrl();
	      String expectedurl="https://qatest.twoplugs.com/home";
        
	      Assert.assertEquals(actualurl, expectedurl, "Login valid");
	      logger.info("Login success");
	      
	      //log out to test the next input
	         Actions action = new Actions(driver);
	        action.moveToElement(driver.findElement(By.xpath("//ul/li/a[@href='#']/span[@class='help']"))).click().build().perform();
	        Actions action1= new Actions(driver);
	        action1.moveToElement(driver.findElement(By.xpath("//a[@href='/signout']"))).click().build().perform();
	        
	
	
}



@DataProvider(name="loginV")
public String[][] readDatafromExcel() throws IOException
{
	String path=System.getProperty("user.dir")+"/src/main/java/com/TwoPlugs/TestData/Logindatav.xlsx";
	int rowcount=XLUtils.getRowCount(path, "Sheet1");
	int colcount= XLUtils.getCellCount(path, "Sheet1", 1);
	System.out.println(rowcount + "  " + colcount);
	String mydata[][]= new String[rowcount-1][colcount];
	  for(int i=1;i<rowcount;i++)
	  {
		  for(int j=0; j<colcount;j++)
		  {
			  mydata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			 
		  }
		  
	  }
	  return mydata;	
}
}
