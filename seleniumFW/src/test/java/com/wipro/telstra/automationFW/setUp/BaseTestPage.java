package com.wipro.telstra.automationFW.setUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.wipro.telstra.automationFW.listeners.TestListeners;
import com.wipro.telstra.automationFW.listeners.WebEventListener;
import com.wipro.telstra.automationFW.utility.ReadFileData;
//import com.wipro.wdb.SLog;

public class BaseTestPage extends ReadFileData {

	public WebDriver edriver;

	public WebDriverWait wait;
	public static EventFiringWebDriver driver;
	
	public WebEventListener eventListener;
	public String currnetlocation = System.getProperty("user.dir");
	public String downloadFilepath = currnetlocation + "/Downloads/";
	public static int tccount = 0;
	
	@BeforeMethod
	public void openBrowser() {
		tccount++;
		try {

			if (browserToOpen.equalsIgnoreCase("Firefox")) {
				System.out.println("Launching Firefox browser");
				System.setProperty("webdriver.gecko.driver", currnetlocation + "/Drivers/geckodriver.exe");
				edriver = new FirefoxDriver();
				edriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} else if (browserToOpen.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", currnetlocation + "/Drivers/chromedriver1.exe");
				edriver = new ChromeDriver();
			
				edriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} else if (browserToOpen.equalsIgnoreCase("IE")) {
				System.out.println("Launching IE browser");
				System.setProperty("webdriver.ie.driver", currnetlocation + "/Drivers/IEDriverServer.exe");
				edriver = new InternetExplorerDriver();
			} else if (browserToOpen.equalsIgnoreCase("Edge")) {
				System.out.println("Launching Microsoft Edge browser");
				System.setProperty("webdriver.edge.driver", currnetlocation + "/Drivers/MicrosoftWebDriver.exe");
				edriver = new EdgeDriver();
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());

		}

		driver = new EventFiringWebDriver(edriver);
		eventListener = new WebEventListener();
		driver.register(eventListener);
		driver.get(getUrl());
		driver.manage().window().maximize();
		

	}

	@AfterMethod
	public void tear() {
		driver.quit();

	}

	@AfterSuite
	public void createReport() {
		System.out.println("Number of tC executed : " + tccount);

		int testcount = TestListeners.count;
		System.out.println("Number of Test Method from TL  =" + testcount);
		
	}

	
	public WebDriver getDriver() {
		return driver;
	}

}
