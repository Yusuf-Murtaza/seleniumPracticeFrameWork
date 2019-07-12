package com.wipro.telstra.automationFW.listeners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import java.util.List;

import org.codehaus.plexus.util.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wipro.telstra.automationFW.setUp.BaseTestPage;


public class TestListeners implements ITestListener{

	private WebDriver driver ;
	protected static ExtentReports reports;
	public static ExtentTest logger;
	public static  int count = 0;
	List<ITestNGMethod> passedtests = new ArrayList<ITestNGMethod>();
	List<ITestNGMethod> failedtests = new ArrayList<ITestNGMethod>();
	List<ITestNGMethod> skippedtests = new ArrayList<ITestNGMethod>();
	
	String currnetlocation = System.getProperty("user.dir");
	//String filePath = currnetlocation + "\\ScreenShots\\";
	String filePath = "D:\\Diversey\\Automation\\ScreenShots\\";
	private static String fileSeperator = System.getProperty("file.separator");
	List<String> recipients  = Arrays.asList("venkatesh.hc@diversey.com");
	//,"jumpala.shirisha@diversey.com","samir.mohanty@diversey.com"
	public String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date());
	 
	JSONParser parser = new JSONParser();
		
	
	public void onTestStart(ITestResult result) {
		String methodName = result.getName().toString().trim();
		System.out.println("Started Test Method" +methodName);
		logger = reports.startTest(result.getMethod().getMethodName());
		logger.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
		count++;
		System.out.println("Number of Test Method" +count);
	}
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test case PAssed "+result.getTestName());
		logger.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
		passedtests.add(result.getMethod());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error " + result.getName() + " test has failed *****");
		String methodName = result.getName().toString().trim();
		takeScreenShot(methodName);
		failedtests.add(result.getMethod());
	}

	public void takeScreenShot(String methodName) {
		// get the driver
		BaseTestPage base = new BaseTestPage();
		driver=base.getDriver();
		String fileName = new Date().getTime() + ".png";
		//String fileName = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new
		// Date())+ ".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test method name
		try {
			FileUtils.copyFile(scrFile, new File(filePath + methodName + fileName));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		logger.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
		skippedtests.add(result.getMethod());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		String fileName =System.getProperty("user.dir") + "\\test-output\\"+ new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms").format(new Date()) + "Reports.html";
		reports = new ExtentReports(fileName);
		System.out.println("$Reports file name : "+fileName);
		context.setAttribute("fileName", fileName);
	}

	public void onFinish(ITestContext context) {
		IResultMap passed = context.getPassedTests();
		System.out.println("Passed tests: " + passed);
		System.out.println("Failed tests:" + context.getFailedTests()); 
		String fileName = (String) context.getAttribute("fileName");
		reports.endTest(logger);
		reports.flush();
		
		/*try {
			JSONParser parser = new JSONParser();
			Object object = parser.parse(new FileReader(currnetlocation + "\\propertiesFile\\Users.json"));
			JSONObject jsonObject = (JSONObject)object;
			JSONArray recipients = (JSONArray)jsonObject.get("recipients");
			System.out.println("%%%%%"+recipients);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
	//	EmailReport.sendPDFReportByGMail("testdiverseywipro@gmail.com", "D!versey2018", recipients, "IntelliCare Sanity Report  "+String.valueOf( timeStamp), "",fileName);
		
		 }

}
