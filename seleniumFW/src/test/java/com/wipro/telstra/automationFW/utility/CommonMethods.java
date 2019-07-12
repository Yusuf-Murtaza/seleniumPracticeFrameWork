package com.wipro.telstra.automationFW.utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wipro.telstra.automationFW.pageObjects.AddToCartPagePages;
import com.wipro.telstra.automationFW.pageObjects.LoginPagePages;
import com.wipro.telstra.automationFW.pageObjects.SearchPagePages;
import com.wipro.telstra.automationFW.setUp.BaseTestPage;


public class CommonMethods extends BaseTestPage {
	
	public static Actions action;
	public static String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//	public static String ThresholdName = "T" + timeStamp;
	public static WebDriverWait wait = new WebDriverWait(driver, 30);
	public static int invalidImageCount = 0;

	
/*	public static void setTimeout(Runnable runnable, int delay) {
		new Thread(() -> {
			try {
				Thread.sleep(delay);
				runnable.run();
			} catch (Exception e) {
				System.err.println(e);
			}
		}).start();
	}
*/
	public static void loginFlipkart() throws Exception {
		
		LoginPagePages login = new LoginPagePages(driver);
		
		login.textFieldEmail.sendKeys(UserName);
		login.textFieldPassword.sendKeys(passWord);
		login.buttonLogin.click();
		Thread.sleep(5000);
		System.out.println("Login Successfull");
		
	}
	
	public static int usingMathClass() {
		double randomDouble = Math.random();
		randomDouble = randomDouble * 24 + 1;
		int randomInt = (int) randomDouble;
		System.out.println(randomInt);
		return randomInt;
	}
	
	public static void setTimeoutSync(Runnable runnable, int delay) {
		try {
			Thread.sleep(delay);
			runnable.run();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public static void useJavaScriptClick(WebDriver driver, WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click -->" + element.getText());

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
				driver.quit();
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			throw new ElementNotVisibleException("Element not Visible to click");
			// System.out.println("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element " + e.getStackTrace());
		}
	}



// To accept alert
	public static void acceptAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().accept();

		} catch (NoAlertPresentException Ex) {
			Reporter.log(Ex.toString());
		}
	}

//To check alert present or not
	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;

		} catch (NoAlertPresentException Ex) {
			Reporter.log(Ex.toString());
			return false;
		}

	}

	public static boolean isDialogPresent(WebDriver driver) {
		try {
			driver.getTitle();
			return false;
		} catch (UnhandledAlertException e) {
			// Modal dialog showed
			return true;
		}
	}

	public static void clearAddToCart() throws Exception {
		
		AddToCartPagePages cart = new AddToCartPagePages(driver);
		cart.buttonRemove.click();
		System.out.println("Card cleared succesfully");
		Thread.sleep(6000);
	}
	
	public static void clearCartAfterLogin() throws Exception {
		
		SearchPagePages search = new SearchPagePages(driver);
		
		//search.buttonCartIcon.click();
		driver.findElement(By.xpath("//span[text()='Cart']")).click();
		int size =search.buttonRemoveAll.size();
		//System.out.println("Size is "+size);
		
		if (search.buttonRemoveAll.size()!=0){		
			System.out.println("Clearing "+size+ "Cart items");
			
			for (WebElement ele : search.buttonRemoveAll) {
				//TelstraSynchronization.waitisElementClickable(driver, ele);
			//for(int i =0;i<size;i++) {
				Thread.sleep(5000);
				//search.buttonRemoveAll.get(i).click();
				driver.findElement(By.xpath("//div[text()='Remove']")).click();
				Thread.sleep(5000);
				//TelstraSynchronization.waitisElementClickable(driver, search.alertRemoveOK);
				//search.alertRemoveOK.click();
				driver.findElement(By.xpath("//div[@class='JbjX6r']/following-sibling::div/div/div[text()='Remove']")).click();
				System.out.println("Item Removed succesfully");
				
				//TelstraVerification.verifyIsAlertPresent(driver);
			}
			
		}
		else {
			System.out.println("Cart is empty");
		}
			
	
	}
	
	public static void logoutFlipkart() throws Exception {
		
		
		LoginPagePages login = new LoginPagePages(driver);
		
		login.buttonMyAccount.click();
		Thread.sleep(5000);
		login.buttonMyAccount.click();
		
		TelstraSynchronization.waitElementForVisible(driver, login.buttonLogout);
		login.buttonLogout.click();
		System.out.println("Logout succesfully!!!");
	}
	
	public static void switchWindow() {
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    //System.out.println("I am in "+driver.getTitle());
		}
		
		//driver.switchTo().window("CDwindow-8EEBDC6CB33E81514B15112D83F76AE5");
		
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
	
	public static void scrollingToSpecificCoordinates() {
		//driver.navigate().to(url);
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250)", "");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,15000)");
	}

	// To perform right click operation
	public void rightClick(WebDriver driver, WebElement element) {

		try {
			action = new Actions(driver).contextClick(element);
			action.build().perform();
			System.out.println("Sucessfully Right clicked on the element");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable " + e.getStackTrace());
		}

	}

	// To perform drag and drop operation
	public void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
		try {
			if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
				Actions action = new Actions(driver);
				action.dragAndDrop(sourceElement, destinationElement).build().perform();
			} else {
				System.out.println("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + sourceElement + "or" + destinationElement
					+ "is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Error occurred while performing drag and drop operation " + e.getStackTrace());
		}
	}

	public void doubbleClick(WebElement driver, String locator) {

		WebElement element = driver.findElement(By.id(locator));
		action.doubleClick(element).perform();

	}

// Move to element
	public void moveToElement(WebElement driver, WebElement locator) {
		action.moveToElement(locator).click().perform();

	}

//Verify images loaded or not
/*	public static void verifyimageActive(WebElement imgElement) {

		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);

			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
//Performs a context-click (Right Click )at the current mouse location
	public void rightClick(WebElement driver, WebElement locator) {
		try {
			action.contextClick(locator);
			action.build().perform();

			System.out.println("Sucessfully Right clicked on the element");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + locator + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + locator + " was not clickable " + e.getStackTrace());
		}

	}

	// Select value from dropdown by Text

	public static void select_Option_In_DropDown_ByVisibleText(WebElement element, String elementToSelect) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(elementToSelect);

		} catch (NoSuchElementException e) {
			System.out.println("Option value not find in dropdown");

		}
	}

	// Select value from dropdown by value

	public static void select_Option_In_DropDown_ByValue(WebElement element, String elementToSelect) {
		try {
			Select select = new Select(element);
			select.selectByValue(elementToSelect);
		} catch (NoSuchElementException e) {
			System.out.println("Option value not find in dropdown");

		}
	}

	public static void select_Option_In_DropDown_ByValue(WebElement element, int indexVal) {
		try {
			Select select = new Select(element);
			select.selectByIndex(indexVal);
		} catch (NoSuchElementException e) {
			System.out.println("Option value not find in dropdown");
		}
	}

	// To convert webElements to List

	public static List<String> convertWebElementToList(List<WebElement> selectOptions) {
		List<String> webPageList = new ArrayList<String>();
		for (WebElement item : selectOptions) {
			String element = item.getText();
			element = item.getText().trim();

			if (element != null && !element.isEmpty() && element != " ")
				webPageList.add(item.getText().trim());
		}
		// System.out.println(webPageList);
		return webPageList;
	}
	
	public static void select_Option_In_DropDown_WithoutSelectTag(WebDriver driver, WebElement dropdownClick, List<WebElement> dropDownOrgValueFullList, String text)
	{
		
		  Actions action = new Actions(driver); 
		  
		  action.moveToElement(dropdownClick);
		  
		  List<WebElement> options = dropDownOrgValueFullList; 
		  for(WebElement option : options) 
		  { 
			  //System.out.println(option.getText());
			  if(option.getText().equals(text)) 
			  {
				  //System.out.println("*****Match found******"); 
				  option.click();
				  break;
			  } 
		  }
	}

	/*public static void veriyfURLStatus(String URL) {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		try {
			HttpResponse response = client.execute(request);
			// We can also check for 404 status code like
			if (response.getStatusLine().getStatusCode() != 200)
				ReportsTestCases.invalidLinksCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

}