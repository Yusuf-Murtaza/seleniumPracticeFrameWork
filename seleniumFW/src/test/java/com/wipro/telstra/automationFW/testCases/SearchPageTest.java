package com.wipro.telstra.automationFW.testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wipro.telstra.automationFW.pageObjects.LoginPagePages;
import com.wipro.telstra.automationFW.pageObjects.SearchPagePages;
import com.wipro.telstra.automationFW.setUp.BaseTestPage;
import com.wipro.telstra.automationFW.utility.CommonMethods;
import com.wipro.telstra.automationFW.utility.TelstraSynchronization;
import com.wipro.telstra.automationFW.utility.TelstraVerification;

import junit.framework.Assert;

public class SearchPageTest extends BaseTestPage {

	public static String searchItemName;
	public static String searchItemCost;
	
	// Verify that User is able to search items in Flipkart, select 1 item randomly and get the name and price
	@Test
	public static void searchItems() throws Exception {
		
		SearchPagePages search = new SearchPagePages(driver);
		CommonMethods.loginFlipkart();
		
		int count=1;
		
		TelstraSynchronization.waitisElementClickable(driver, search.textFieldSearch);
		search.textFieldSearch.sendKeys(itemToSearch);
		search.buttonSearch.click();
		
		int randVal = CommonMethods.usingMathClass();
		System.out.println("Value of random j is "+randVal);
		List<WebElement> searchResults = search.searchAllResults;
		List<WebElement> searchResultsPrice = search.searchAllResultsPrice;
		System.out.println("Size is "+searchResults.size());
		
		for(WebElement i: searchResults) {
			
			if (count==randVal) {
				System.out.println("Camera selected randomly which is below--- ");
				
				System.out.println(searchResults.get(randVal).getText());
				searchItemName =searchResults.get(randVal).getText();
				System.out.println("Item name is "+searchItemName);
				searchItemCost=searchResultsPrice.get(randVal).getText();
				System.out.println("Item cost is "+searchItemCost);
				
				searchResults.get(randVal).click();
				System.out.println("Item clicked succesfully");
				
				break;
			}
			
			count++;
			
		}

	}


}
