package com.wipro.telstra.automationFW.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.telstra.automationFW.setUp.BasePage;

public class SearchPagePages extends BasePage{

	public SearchPagePages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@name='q']")
	public WebElement textFieldSearch;
		
	@FindBy(xpath="//button[@type='submit']")
	public WebElement buttonSearch;
	
	@FindBy(xpath="//div[@class='col col-7-12']//div[@class='_3wU53n']")
	public List<WebElement> searchAllResults;
	
	@FindBy(xpath="//span[text()='Cart']")
	public WebElement buttonCartIcon;
	
	@FindBy(xpath="//div[@class='JbjX6r']/following-sibling::div/div/div[text()='Remove']")
	public WebElement alertRemoveOK;
	
	@FindBy(xpath="//div[text()='Remove']")
	public WebElement buttonRemove;
	
	@FindBy(xpath="//div[text()='My Account']")
	public WebElement buttonMyAccount;
	
	@FindBy(xpath="//div[text()='Your cart is empty!']")
	public WebElement textEmptyCart;
	
	
	@FindBy(xpath="//*[@title='Flipkart']")
	public WebElement titleFlipkart;
	
	@FindBy(xpath="//div[text()='Logout']")
	public WebElement buttonLogout;
	
	@FindBy(xpath="//div[text()='Remove']")
	public List<WebElement> buttonRemoveAll;
	
	@FindBy(xpath="//div[@class='_1vC4OE _2rQ-NK']")
	public List<WebElement> searchAllResultsPrice;
}
