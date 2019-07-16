package com.wipro.telstra.automationFW.testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wipro.telstra.automationFW.pageObjects.AddToCartPagePages;
import com.wipro.telstra.automationFW.pageObjects.SearchPagePages;
import com.wipro.telstra.automationFW.setUp.BaseTestPage;
import com.wipro.telstra.automationFW.utility.CommonMethods;
import com.wipro.telstra.automationFW.utility.TelstraSynchronization;
import com.wipro.telstra.automationFW.utility.TelstraVerification;

import junit.framework.Assert;


public class AddToCartPageTest extends BaseTestPage {

	
	// Verify that User is able to add items to cart and compare products name and price from search page with checkout page in Flipkart
		@Test
		public void addToCartNew() throws Exception {
			
			AddToCartPagePages cart = new AddToCartPagePages(driver);
			SearchPagePages search = new SearchPagePages(driver);
			CommonMethods.loginFlipkart();
			TelstraSynchronization.waitisElementClickable(driver, cart.buttonCartIcon);
			cart.buttonCartIcon.click();
			CommonMethods.clearCartAfterLogin();
			int count=1;
			String searchItemName = null, searchItemCost = null;
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

			CommonMethods.switchWindow();
			
			TelstraSynchronization.waitElementForVisible(driver, cart.buttonAddToCart);
			System.out.println("Add cart is "+cart.buttonAddToCart.isDisplayed());
			
			cart.buttonAddToCart.click();
			System.out.println("Clicked add to cart button");
			
			TelstraSynchronization.waitElementForVisible(driver, cart.productNameCheckOutPage);
			TelstraVerification.verifyText(cart.productNameCheckOutPage, searchItemName);
			
			TelstraSynchronization.waitElementForVisible(driver, cart.finalAmountCheckOutPage);
			TelstraVerification.verifyText(cart.finalAmountCheckOutPage, searchItemCost);
			
			
			TelstraSynchronization.waitElementForVisible(driver, cart.buttonPlaceOrder);
			cart.buttonPlaceOrder.click();
			TelstraSynchronization.waitElementForVisible(driver, cart.buttonContinueCheckout);
			cart.buttonContinueCheckout.click();
			System.out.println("Items added to cart successfully!!!");
			
		}
}


