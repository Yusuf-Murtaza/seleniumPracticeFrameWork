package com.wipro.telstra.automationFW.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.telstra.automationFW.setUp.BasePage;

public class LoginPagePages extends BasePage{

	public LoginPagePages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String expAuthoriseSite = "Authorise Sites";
	
	
	
	@FindBy(xpath="//input[contains(@class,'2zrpKA') and @type='text']")
	public WebElement textFieldEmail;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement textFieldPassword;
	
	@FindBy(xpath="//button/span")
	public WebElement buttonLogin;
	
	@FindBy(xpath="//div[text()='My Account']")
	public WebElement buttonMyAccount;
	
	@FindBy(xpath="//div[text()='Logout']")
	public WebElement buttonLogout;
	
	@FindBy(xpath="//li[contains(@class,'multiselect-item-checkbox')]/div")
	public List<WebElement> dropdownSiteAllValues;
	
	
}
