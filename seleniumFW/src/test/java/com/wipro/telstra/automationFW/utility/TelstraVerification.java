package com.wipro.telstra.automationFW.utility;

import java.io.File;
import java.util.List;

//import org.apache.velocity.test.BaseTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.wipro.telstra.automationFW.setUp.BasePage;


public class TelstraVerification extends BasePage {
	public TelstraVerification(WebDriver name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	public static SoftAssert softAssert = new SoftAssert();
	static String currnetlocation = System.getProperty("user.dir");
	public static String downloadPath = currnetlocation + "/FileDownloads";

//Comparing two lists as string	
	public static void verifyTwoList(String actList, String expList) {
		if (actList.equals(expList)) {
			Reporter.log("PASS : All elemenmts present " + expList.toString());
			System.out.println("PASS : All elemenmts present " + expList.toString());
		} else {
			Reporter.log("FAIL : All elemenmts not present Actual List " + actList.toString() + "\n Expected List"
					+ expList);
			System.out.println("FAIL : All elemenmts not present Actual List :" + actList.toString()
					+ "\n Expected List" + expList);
		}
	}

	// Comparing two lists
	public static void verifyTwoLists(List actList, List expList) {
		if (actList.equals(expList)) {
			Reporter.log("PASS : All elemenmts present " + expList.toString());
			System.out.println("PASS : All elemenmts present " + expList.toString());
		} else {
			Reporter.log("FAIL : All elemenmts not present Actual List " + actList.toString() + "\n Expected List"
					+ expList);
			System.out.println("FAIL : All elemenmts not present Actual List :" + actList.toString()
					+ "\n Expected List" + expList);
		}
	}

	//Verifying actual and expected text
	public static void verifyText(WebElement locator, String expectedText) throws NoSuchElementException {
		String actualText;
		try {
			actualText = locator.getText();
			if (actualText.equals(expectedText)) {
				Reporter.log("Passed : Actual Text:= [" + actualText + "] Expected Text:= [" + expectedText + "]");
				System.out
						.println("Passed : Actual Text:= [" + actualText + "] Expected Text:= [" + expectedText + "]");
				// softAssert.assertEquals(actualText, expectedText);
			} else {
				Reporter.log("Failed : Actual Text:= [" + actualText + "] Expected Text:= [" + expectedText + "]");
				System.out
						.println("Failed : Actual Text:= [" + actualText + "] Expected Text:= [" + expectedText + "]");
				// softAssert.assertEquals(actualText, expectedText);
				softAssert.assertAll();
				throw new Exception("Expected string not matched" + actualText);
			}
		} catch (Exception error) {
			error.printStackTrace();
			Reporter.log(error.getMessage());
		}
	}

	//Verifying actual and expected string
	public static void verifyString(String actualText, String expectedText) {

		try {
			if (actualText.equals(expectedText)) {
				Reporter.log("Passed : Actual Text:= [" + actualText + "] Expected Text:= [" + expectedText + "]");
				System.out
						.println("Passed : Actual Text:= [" + actualText + "] Expected Text:= [" + expectedText + "]");

			} else {
				Reporter.log("Failed : Actual Text:= [" + actualText + "] Expected Text:= [" + expectedText + "]");
				System.out
						.println("Failed : Actual Text:= [" + actualText + "] Expected Text:= [" + expectedText + "]");

				softAssert.assertAll();
				throw new Exception("Expected string not matched" + actualText);
			}
		} catch (Exception error) {
			error.printStackTrace();
			Reporter.log(error.getMessage());
		}
	}


// Method to check attribute of class
	public static void verifyHasClass(WebDriver driver, WebElement element, String value) {
		String classes = element.getAttribute("class");

		if (classes.contains(value)) {
			Reporter.log("Passed : Element := [" + element.getText() + "] is Highlighted");
			System.out.println("Passed : Element:= [" + element.getText() + "] is Highlighted");

		} else {

			Reporter.log("Failed : Element:= [" + element.getText() + "] is not Highlighted");
			System.out.println("Failed : Element:= [" + element.getText() + "] is not Highlighted");

		}

	}

	public static void verifyElementEnabledUsingClass(WebDriver driver, WebElement element, String value) {
		String classes = element.getAttribute("class");

		if (classes.equals(value)) {
			Reporter.log("Passed : Element := [" + element.getText() + "] is Enabled");
			System.out.println("Passed : Element:= [" + element.getText() + "] is Enabled");

		} else {

			Reporter.log("Failed : Element:= [" + element.getText() + "] is not Enabled");
			System.out.println("Failed : Element:= [" + element.getText() + "] is not Enabled");

		}

	}

	// Method to check attribute of class
	public static void verifyHasClassInactive(WebDriver driver, WebElement element, String value) {
		String classes = element.getAttribute("class");
		for (String c : classes.split("-")) {
			if (c.equals(value)) {
				Reporter.log("Failed : Actual Class:= [" + classes + "] Expected Class:= [" + value + "]");
				System.out.println("Failed : Actual Class:= [" + classes + "] Expected Class:= [" + value + "]");
				softAssert.assertTrue(true);
			}
		}

		Reporter.log(" Passed: Actual Class:= [" + classes + "] Expected Class:= [" + value + "]");
		System.out.println("Passed : Actual Class:= [" + classes + "] Expected Class doesnot have := [" + value + "]");
		softAssert.assertTrue(false);
	}

	public static void verifyElementPresent(WebDriver driver, WebElement locator) throws Exception {
		try {

			if (locator.isDisplayed()) {
				softAssert.assertTrue(true);
				Reporter.log(locator.getAttribute("class") + "PASS Element is Displayed");
				System.out.println(locator.getAttribute("class") + "PASS Element is Displayed");
				// logger.log(LogStatus.PASS,locator.toString() + "Element is Displayed");
			}

		} catch (NoSuchElementException error) {
			softAssert.assertTrue(false);
			Reporter.log(locator.getAttribute("class") + " Element is not Displayed");
			// logger.log(LogStatus.FAIL,locator.toString() + " Element is not Displayed");
			System.out.println(locator.getAttribute("class") + " Element is not Displayed");
			throw new Exception(locator.getAttribute("value") + "Element is not Displayed");

		}

	}


	public static void verifyDbCount(int actCount, int dbCount) {

		if (actCount == dbCount) {
			System.out.println("Passed : Number of Threshould count present in UI ='" + actCount
					+ "' matched with DB count " + dbCount);
			Reporter.log(
					"Passed : Number of Threshould count present in UI '" + actCount + "' matched with DB " + dbCount);
			softAssert.assertTrue(true);
		} else {
			System.out.println("Failed : Number of Threshould count present in UI ='" + actCount
					+ "' matched with DB count" + dbCount);
			Reporter.log("Failed : Number of Threshould count present in UI = '" + actCount
					+ "' is not matched with DB count" + dbCount);
			softAssert.assertTrue(false);
		}

	}


	// To verify Alert present
	public static void verifyIsAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			softAssert.assertTrue(true);
			Reporter.log("Alert is Present");
		} catch (NoAlertPresentException Ex) {
			softAssert.assertTrue(false);
			Reporter.log("Alert is not Present");
		}

	}

	public static void verifyAttribute(WebDriver driver, WebElement locator, String value, String expected)
			throws Exception {

		try {
			String actValue = locator.getAttribute(value);
			if (actValue.equalsIgnoreCase(expected)) {
				softAssert.assertTrue(true);
				Reporter.log("Attributes are matched");
				System.out.println("Attributes are matched");
			} else {

				softAssert.assertTrue(false);
				Reporter.log("Attributes are not matched");
				System.out.println("Attributes are matched");
			}
		} catch (Exception e) {
			throw new Exception("No such element present");
		}
	}

	public static void verifyIsEnable(WebDriver driver, WebElement locator) {
		try {
			if (locator.isEnabled()) {
				Reporter.log("Failed :" + locator.toString() + "is enabled");
				System.out.println("Element is enabled");
				softAssert.assertTrue(false);
			} else {
				Reporter.log("Pass :" + locator.toString() + "is disabled");
				System.out.println("Element is not enabled");
				softAssert.assertTrue(true);
			}

		} catch (Exception e) {

		}

	}

	public static void verifyAttribute(WebDriver driver, WebElement locator, String expected) throws Exception {

		try {
			String actValue = locator.getAttribute("placeholder");
			if (actValue.equalsIgnoreCase(expected)) {
				softAssert.assertTrue(true);
				Reporter.log("Attributes are matched");
			} else {

				softAssert.assertTrue(false);
				Reporter.log("Attributes are not matched");
			}
		} catch (Exception e) {
			throw new Exception("No such element present");
		}
	}
	
	public static void compareString(String first, String second) throws Exception {

		if (first.equals(second)) {
			System.out.println("Values are equal");
		}
		
		else
			System.out.println("Values are not equal");
		
	}
	

	// To display invalid/non existing elements from list

	public static void verifyComparedList(List<String> expectedList, List<String> sourceList, String listName) {

		try {
			for (String expecteditem : expectedList) {
				if (!sourceList.contains(expecteditem)) {
					System.out.println("Not present in " + listName + " list:" + expecteditem);
					Reporter.log("Failed : Below items not present " + listName + " list : " + expecteditem);
					softAssert.assertTrue(false);
				} else {
					Reporter.log("Passed : All items  present " + listName + " list : " + expecteditem);
					softAssert.assertTrue(true);
				}
			}
		} catch (Exception e) {

		}

	}

	// To verify element is clickable
	public static void verifyIsClickable(WebDriver driver, WebElement locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable((By) locator));
			System.out.println("Element is clickable " + locator.toString());
			Reporter.log("Passed : Element is clickable " + locator.toString());
			softAssert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("Element is not clickable " + locator.toString());
			Reporter.log("Failed :Element is not clickable " + locator.toString());
			softAssert.assertTrue(false);
		}
	}


	// Check the file from a specific directory
	public static void isFileDownloaded(WebDriver driver, String fileName) {
		String filePath = "C:\\Users\\yu251666\\Downloads";
		File dir = new File(filePath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName)) {
				System.out.println("PASS :File downloaded successfully " + fileName);
				Reporter.log("Passed : File downloaded successfully");
				break;
			} else {
				//System.out.println("File not downloaded " + fileName);
				Reporter.log("Failed : File not downloaded");

			}

		}

	}

	/* Get the latest file from a specific directory */
	public  File getLatestFilefromDir(WebDriver driver, String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

// Check the file from a specific directory with extension
	public boolean isFileDownloaded_Ext(WebDriver driver, String ext) {
		String downloadPath = "C:\\Users\\ve40007843\\Downloads";
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}

		for (int i = 1; i < files.length; i++) {
			if (files[i].getName().contains(ext)) {
				flag = true;
			}
		}
		return flag;
	}
}
