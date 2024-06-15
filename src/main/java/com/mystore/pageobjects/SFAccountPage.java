package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SFAccountPage extends BaseClass{
	@FindBy(xpath="//input[@value=\" New \"]") private WebElement newBtn;
	@FindBy(xpath = "//li[@id=\"Account_Tab\"]//following::a[1]")private WebElement aacountTabBtn;
	@FindBy(xpath = "//p[text()='Welcome to your account. Here you can manage all of your personal information and orders.']")private WebElement ele;
	@FindBy(xpath="//*[contains(text(),\"Your account has been created\")]") private WebElement accCreationMsg;
	@FindBy(id="search_query_top") WebElement searchProductBox;
	@FindBy(name="submit_search") WebElement searchBtn;
	
	
	
	public SFAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	

}
