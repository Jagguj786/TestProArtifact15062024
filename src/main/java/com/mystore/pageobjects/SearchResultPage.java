package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass{
	@FindBy(xpath="//*[@title=\"Printed Chiffon Dress\"]")   WebElement productLink;
	@FindBy(name="passwd")  WebElement password;
    
    
    public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
    
    public boolean productResultDisplayed() {
    	
    	return Action.isDisplayed(driver, productLink);
    	
    }
    
    public AddToCartPage clcikOnProduct() {
    	
    	Action.click(driver, productLink);
		return new AddToCartPage();
    	
    }
    
}
