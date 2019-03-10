package com.TwoPlugs.Utilities;
// Listener class used to generate extent reports
import java.io.File;
import java.io.IOException;
import java.sql.Date;

import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	
	public ExtentHtmlReporter  htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
    public void onStart(ITestContext testContext)
    {
    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));
    	String repName="Test-Report-" + timeStamp + ".html";//save report with timestamp
    	htmlReporter = new ExtentHtmlReporter (System.getProperty("user.dir")+ "/test-output/"+repName);//specify location
    	htmlReporter.loadConfig(System.getProperty("user.dir") + "/extent-config.xml");//loaded this fle 
    	
    	extent = new ExtentReports();
    	extent.attachReporter(htmlReporter);
    	extent.setSystemInfo("Host name", "localhost");
    	extent.setSystemInfo("Environment", "QA");
    	extent.setSystemInfo("user", "Naseem");
    	
    	htmlReporter.config().setDocumentTitle("Two pLugs Test Project");
    	htmlReporter.config().setReportName("Functional test report");
          
    	htmlReporter.config().setTheme(Theme.DARK);
    	
    }
    
    public void onTestSuccess(ITestResult tr)
    {
    	logger= extent.createTest((tr.getName()));//create a new entry in the report
    	logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));//send the passed info
    }
    
    public void onTestFailure(ITestResult tr)
    {
    	logger=extent.createTest(tr.getName());
    	logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
    	String screenshotpath=System.getProperty("user.dir")+ "\\Screenshots\\"+tr.getName()+".png";// captures path of screenshot
    	
    	File f= new File(screenshotpath);
    	
    			if(f.exists())
    			{
    				try
    				{
    					logger.fail("Screenshot is below "+ logger.addScreenCaptureFromPath(screenshotpath));
    				
    				}
    				  catch (IOException e)
    				  {
    					  e.printStackTrace();
    					  
    				  }
    			}
    	
    }
      public void onTestSkipped(ITestResult tr)
      {
    	  logger= extent.createTest(tr.getName());
    	  logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
      }
      
      public void onFinish(ITestContext testContext)
      {
    	  extent.flush();
      }


}
