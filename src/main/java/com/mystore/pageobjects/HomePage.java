package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//span[text()='My wishlists']") private WebElement myWishList;
	@FindBy(xpath = "//span[text()='Order history and details']")private WebElement orderHistory;
	@FindBy(xpath = "//p[text()='Welcome to your account. Here you can manage all of your personal information and orders.']")private WebElement ele;
	@FindBy(xpath="//*[contains(text(),\"Your account has been created\")]") private WebElement accCreationMsg;
	@FindBy(id="search_query_top") WebElement searchProductBox;
	@FindBy(name="submit_search") WebElement searchBtn;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean ValidateHomePageAfterLogin() {
		
		boolean status = Action.isDisplayed(driver, ele);
		return status;
		
	}
	
	public boolean orderHistory() {
		
		return Action.isDisplayed(driver, orderHistory);
		
	}
	
	public String getCurrentURL() {
		
		String homePageURL=Action.getCurrentURL(driver);
		return homePageURL;
		
	}
	
	public boolean accountCreationSuccessfully() {
		
		return Action.isDisplayed(driver, accCreationMsg);
		
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(driver, searchBtn);
		return new SearchResultPage();
		
	}
	
}
