package com.TwoPlugs.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;  //propertries class object to load and read forn config file
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");//connect to config properties path
		
		
		try {
			 FileInputStream fis= new FileInputStream(src);  //open file read mode
			 prop= new Properties();
			 prop.load(fis);//load teh file 

		    }
		catch(Exception e)
		{
			System.out.println("Esception is" +e.getMessage() );
		}
	}
	
	
	//Create different methods to reaad the environrment variables
	
	public String getApplicationURL()
	{
		String url= prop.getProperty("baseurl");
		return url;
	}
	

	
	public String getusername()
	{
		String uname=prop.getProperty("username");
		return uname;
	}
	
	public String getpassword()
	{
		String pass=prop.getProperty("password");
		return pass;
	}
	
	public String getchromepath()
	{
		String cpath=prop.getProperty("chromepath");
		return cpath;
	}
	
	public String getfirefoxpath()
	{
		String fpath=prop.getProperty("firefoxpath");
		return fpath;
	}
}
