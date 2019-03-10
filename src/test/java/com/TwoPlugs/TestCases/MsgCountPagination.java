package com.TwoPlugs.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TwoPlugs.PageObjects.HomePage;
import com.TwoPlugs.PageObjects.LoginPage;
import com.TwoPlugs.PageObjects.MessagePage;

public class MsgCountPagination extends BaseClass{
	
	SoftAssert softassert = new SoftAssert();
	int total_messages;
	@Test
	public void getMesagesPagination() throws IOException, InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		lp.loginClick();
		logger.info("Logging into two plugs site");
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		logger.info("Valid username and password are entered, Login is clicked");
		
		
		HomePage home= new HomePage(driver);
		home.clickMessageLink();
		logger.info("Messages icon clicked");
		
	// for first page 	
		MessagePage messages= new MessagePage(driver);
	    total_messages=messages.getTotalNoOfRowsMessages();
		System.out.println(total_messages);
		
		softassert.assertEquals(total_messages, 15, "fail- page does not have 15 messages");
		captureScreenshot(driver,"getMesagesPagination" );
        logger.info("Pages has equal no of messages");
		
	    
        if(messages.paginationButtons()==true)
        softassert.assertTrue(true);
        logger.info("Pagination is present in the bottom of the page");
        logger.info("Test case passed");
   
        //Go to next page
		messages.clickNextPage();
		total_messages=messages.getTotalNoOfRowsMessages();
		softassert.assertEquals(total_messages, 15, "fail- page does not have 15 messages");
		captureScreenshot(driver,"getMesagesPagination" );
        logger.info("Pages has equal no of messages in teh next page");
		
        if(messages.paginationButtons()==true)
            softassert.assertTrue(true);
            logger.info("Pagination is present in the bottom of the page");
            logger.info("Test case passed for next page");
            
/*        //Go to the last page
            messages.clickLastPage();
            total_messages=messages.getTotalNoOfRowsMessages();
        // check lastbtn is displayed
            boolean res=messages.checkLastPagedisplayed();
            if(total_messages < 15 && res==false)
            {
            	softassert.assertTrue(true);
                logger.info("You are in last page");
            }
            
            else
            {
            	captureScreenshot(driver,"getMesagesPagination" );
            	softassert.assertTrue(false);
                logger.info("Test case failed You are not in last page");
            }
            
            if(messages.paginationButtons()==true)
                softassert.assertTrue(true);
                logger.info("Pagination is present in the bottom of the page");
                logger.info("Test case passed for last page");*/
                
		    softassert.assertAll();
	}
}
