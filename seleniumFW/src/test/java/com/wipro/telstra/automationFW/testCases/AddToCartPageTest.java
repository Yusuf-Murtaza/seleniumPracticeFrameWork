package com.wipro.telstra.automationFW.testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wipro.telstra.automationFW.pageObjects.AddToCartPagePages;
import com.wipro.telstra.automationFW.pageObjects.SearchPagePages;
import com.wipro.telstra.automationFW.setUp.BaseTestPage;
import com.wipro.telstra.automationFW.utility.CommonMethods;
import com.wipro.telstra.automationFW.utility.TelstraVerification;

import junit.framework.Assert;

public class AddToCartPageTest extends BaseTestPage {

	// Verify that User is able to add to cart for Flipkart
	@Test
	public void addToCart() throws Exception {
		
		AddToCartPagePages addCart = new AddToCartPagePages(driver);
		SearchPageTest.searchItems();
		
		CommonMethods.switchWindow();		
	
		addCart.buttonAddToCart.click();
		Thread.sleep(5000);
		
		addCart.buttonPlaceOrder.click();
		
		
		//CommonMethods.clearAddToCart();
	}

	// Verify that User is able to compare products name and price in Flipkart
	@Test
	public void productComparison() throws Exception {
		
		SearchPageTest search = new SearchPageTest();
		
		AddToCartPagePages addCart = new AddToCartPagePages(driver);
		SearchPageTest.searchItems();
		
		CommonMethods.switchWindow();		
	
		addCart.buttonAddToCart.click();
		Thread.sleep(5000);
		
		TelstraVerification.verifyText(addCart.productNameCheckOutPage, search.searchItemName);
		TelstraVerification.verifyText(addCart.finalAmountCheckOutPage, search.searchItemCost);
		addCart.buttonPlaceOrder.click();
		
		
	}
}


