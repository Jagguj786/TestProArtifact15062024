package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	@FindBy(id="quantity_wanted") private WebElement quantity;
	//label[contains(text(),"Quantity")]//following::input[1]
	//@FindBy(xpath="//label[contains(text(),\"Quantity\")]//following::input[1]") private WebElement quantity;
	@FindBy(name="group_1") private WebElement size;
	@FindBy(xpath="//span[text()='Add to cart']") private WebElement addToCartBtn;
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i") private WebElement addToCartMessag;
	@FindBy(xpath="//span[contains(text(),\"Proceed to checkout\")]") private WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String quan) throws InterruptedException {
		Thread.sleep(1000);
		Action.type(quantity, quan);
	}
	
	public void enterSize(String unit) {
		Action.selectByVisibleText(unit, size);
	}
	
	public void clickOnAddToCartBtn() {
		
		Action.click(driver, addToCartBtn);
		
	}
	
	public boolean verifyAfterAddtoCartclick() {
		return Action.isDisplayed(driver, addToCartMessag);
		
	}
	
	public OrderPage clickOntheCheckOut() throws InterruptedException {
		//Action.fluentWait(driver, proceedToCheckOutBtn, 10);
		Thread.sleep(2000);
		Action.click(driver, proceedToCheckOutBtn);
		return new OrderPage();
	}
	
}
