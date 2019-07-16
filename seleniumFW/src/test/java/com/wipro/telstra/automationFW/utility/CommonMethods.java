package com.wipro.telstra.automationFW.utility;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wipro.telstra.automationFW.pageObjects.AddToCartPagePages;
import com.wipro.telstra.automationFW.pageObjects.LoginPagePages;
import com.wipro.telstra.automationFW.pageObjects.SearchPagePages;
import com.wipro.telstra.automationFW.setUp.BaseTestPage;


public class CommonMethods extends BaseTestPage {	

	public static SearchPagePages search = new SearchPagePages(driver);
	
	//Login to flipkart website
	public static void loginFlipkart() throws Exception {
		
		LoginPagePages login = new LoginPagePages(driver);
		
		login.textFieldEmail.sendKeys(UserName);
		login.textFieldPassword.sendKeys(passWord);
		login.buttonLogin.click();
		Thread.sleep(5000);
		//TelstraSynchronization.waitisElementClickable(driver, login.buttonMyAccount);
		System.out.println("Login Successfull");
		
	}
	
	//To generate number randomly
	public static int usingMathClass() {
		
		double randomDouble = Math.random();
		randomDouble = randomDouble * 23 + 1;
		int randomInt = (int) randomDouble;
		
		return randomInt;
	}
	
	//To remove items from cart if any present
	public static void clearCartAfterLogin() throws Exception {
		
		int size =search.buttonRemoveAll.size();
		
		System.out.println("Items in cart are "+size);
		
		if (search.buttonRemoveAll.size()!=0){		
			System.out.println("Clearing "+size+ " Cart items");
			
			for (WebElement ele : search.buttonRemoveAll) {
				
				if(size!=0) {
				WebElement element = driver.findElement(By.xpath("//div[text()='Remove']"));

				Wait<WebDriver> gWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
					        .pollingEvery(Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class,ElementClickInterceptedException.class);
				
				gWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Remove']")));
				ele.click();
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				
				WebElement element2 = driver.findElement(By.xpath("//div[@class='JbjX6r']/following-sibling::div/div/div[text()='Remove']"));
				
				
				Wait<WebDriver> gWait2 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				        .pollingEvery(Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class,ElementClickInterceptedException.class);
			   
				
			
				gWait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='JbjX6r']/following-sibling::div/div/div[text()='Remove']")));
				
				executor.executeScript("arguments[0].click()", element2);
				System.out.println("Item Removed succesfully");
				
				size--;
				
			}
			}	
		}
		else {
			System.out.println("Cart is empty");
			
		}
			
	
	}
	
		
	//For Java script click usage	
	public static void javaScriptExecutor(WebDriver driver, WebElement locator) {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", locator);
		
	}
	
	//Logging out the Flipkart app
	public static void logoutFlipkart() throws Exception {
	
		TelstraSynchronization.waitElementForVisible(driver, search.titleFlipkart);
	
		search.titleFlipkart.click();
		
		TelstraSynchronization.waitElementForVisible(driver, search.buttonMyAccount);
		
		Actions act = new Actions(driver);
	
		act.moveToElement(search.buttonMyAccount).build().perform();
	
		System.out.println("Hovered successfully");
	
		TelstraSynchronization.waitElementForVisible(driver, search.buttonLogout);
	
		search.buttonLogout.click();
	
		System.out.println("Logout successfully");
	}	
	
	//To switch between windows handle
	public static void switchWindow() {
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);

		}
		
		System.out.println("In windown handle "+driver.getTitle());
		
	}
	
	// Scrolling to bottom of page
	public static void scrollingToBottomofAPage(WebDriver driver, String url) {
		driver.navigate().to(url);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// Scrolling to top of page
	public static void scrollingToTopofAPage(WebDriver driver, String url) {
		driver.navigate().to(url);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250)", "");
	}



}