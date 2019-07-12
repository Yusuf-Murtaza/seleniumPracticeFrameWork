package com.wipro.telstra.automationFW.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFileData {

	Properties prop = new Properties();
	InputStream input = null;

	public String testUrl;
	
	public static String passWord;
	public static String itemToSearch;
	public static String UserName;
	public static String browserToOpen;
	
	public ReadFileData() {
		try {
			String currnetlocation = System.getProperty("user.dir");
			input = new FileInputStream(currnetlocation + "/propertiesFile/application.properties");

			prop.load(input);
			
			testUrl = prop.getProperty("testUrl");
			UserName = prop.getProperty("userName");
			passWord = prop.getProperty("password");
			itemToSearch = prop.getProperty("search");
			browserToOpen= prop.getProperty("browser");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return testUrl;

	}

}