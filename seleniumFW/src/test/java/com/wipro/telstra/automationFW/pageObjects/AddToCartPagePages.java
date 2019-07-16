package com.wipro.telstra.automationFW.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.telstra.automationFW.setUp.BasePage;

public class AddToCartPagePages extends BasePage{

	public AddToCartPagePages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//*[text()='ADD TO CART']")
	public WebElement buttonAddToCart;
	
	@FindBy(xpath="//span[text()='Place Order']")
	public WebElement buttonPlaceOrder;
	
	@FindBy(xpath="//div[text()='Total Payable']/span")
	public WebElement finalAmountCheckOutPage;
	
	@FindBy(xpath="//div[@class='_1Ox9a7']/a")
	public WebElement productNameCheckOutPage;
	
	@FindBy(xpath="//span[text()='Cart']")
	public WebElement buttonCartIcon;
	
	@FindBy(xpath="//div[@class='_1Ox9a7']/a")
	public WebElement nameItemAddToCart;
	
	@FindBy(xpath="//div[@class='_1Ox9a7']/a")
	public WebElement costItemAddToCart;
	
	@FindBy(xpath="//span[text()='Remove']")
	public WebElement buttonRemove;
	
	@FindBy(xpath="//span[text()='Remove']")
	public WebElement buttonContinueCheckout;
	
}
