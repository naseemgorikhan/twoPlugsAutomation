package com.TwoPlugs.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.TwoPlugs.Utilities.ReadConfig;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	
	public  static Logger logger;
	
	//Create an object of readconfig to read from config 
		ReadConfig readconfig= new ReadConfig();
		public String baseURL=readconfig.getApplicationURL();
		public String username=readconfig.getusername();
		public String password=readconfig.getpassword();
	

@BeforeClass
@Parameters({"browser"})	
public void setup(String br) throws InterruptedException
{
	
	if(br.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", 
			System.getProperty("user.dir")+ "//Drivers//chromedriver.exe" );
	
	//mention the below chrome option to solve timeout exception issue
	//ChromeOptions options = new ChromeOptions();
	//options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		     driver = new ChromeDriver();
		  
	}
	
	else
		if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir")+ "//Drivers//geckodriver.exe" );
				     driver = new FirefoxDriver();
		}
	
	     driver.get(baseURL);
	   //  driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	 //    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	   //  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		        logger = Logger.getLogger("two plugs");
				PropertyConfigurator.configure("log4j.properties");
}


@AfterClass
public void tearDown()
{
	driver.quit();
}

public void captureScreenshot(WebDriver driver, String tname) throws IOException
{
	TakesScreenshot ts= (TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir")+"/screenshots/" + tname+ ".png");
	FileUtils.copyFile(source, target);
	System.out.println("screenshots taken");
	
	
}

}
