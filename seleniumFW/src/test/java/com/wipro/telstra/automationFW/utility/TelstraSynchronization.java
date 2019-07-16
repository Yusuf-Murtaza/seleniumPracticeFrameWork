package com.wipro.telstra.automationFW.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class TelstraSynchronization {
	
		public static void waitElementForVisible(WebDriver driver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(locator));
		Reporter.log(locator.toString() + ": Loaded successfully");
	}

		public static void waitElementListForVisible(WebDriver driver, List<WebElement> locator) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfAllElements(locator));
			Reporter.log(locator.toString() + ": Loaded successfully");
		}
		
	public static void waitElement(WebDriver driver, WebElement locator) {
		long time = System.currentTimeMillis();
		long sysTime = System.currentTimeMillis() + 5000;

		while (true && time < sysTime) {
			try {
				if (locator.isDisplayed()) {
					Reporter.log(locator.toString() + ": Loaded successfully");
					break;
				}
			} catch (Exception e) {

			}

		}

	}
	
	public static void waitisElementClickable(WebDriver driver, WebElement locator){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void waitIsElementVisible(WebDriver driver, By locator){
	WebDriverWait wait = new WebDriverWait(driver, 60);
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void waitForinvisibility(WebDriver driver,By locator){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String text = ((WebElement) locator).getText();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
			
		
	}
	
	public static boolean isElementPresent(WebElement element) {
		
		try {
			if (element!= null) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			System.out.println("Error occured");
			return false;
		}
}


}
