package com.wipro.telstra.automationFW.testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wipro.telstra.automationFW.pageObjects.LoginPagePages;
import com.wipro.telstra.automationFW.setUp.BaseTestPage;
import com.wipro.telstra.automationFW.utility.CommonMethods;
import com.wipro.telstra.automationFW.utility.TelstraSynchronization;
import com.wipro.telstra.automationFW.utility.TelstraVerification;

import junit.framework.Assert;

public class LoginPageTest extends BaseTestPage {

	// Verify that User is able to login to Flipkart website
	
	@Test
	public void login() throws Exception {
		LoginPagePages login = new LoginPagePages(driver);
		
		CommonMethods.loginFlipkart();
		
		TelstraSynchronization.waitElementForVisible(driver, login.buttonMyAccount);
	}
	
}
