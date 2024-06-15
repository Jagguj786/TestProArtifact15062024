package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{
	
	//td[@class="cart_unit"]/ul/li[1]
	//td[@class='cart_unit']/span/span
	@FindBy(xpath="//li[@class=\"price special-price\"]") WebElement unitPriceEle;
	@FindBy(xpath="//span[@id=\"total_price\"]") WebElement totalPriceEle;
	//@FindBy(id="total_price")private WebElement totalPriceEle;
	////td//span[contains(text(),"Total")]//following::span[1]
	@FindBy(xpath="//span[text()='Proceed to checkout']") WebElement proceedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Double getUnitPrice() {
		
		String unitprice = unitPriceEle.getText();
		System.out.println("-------------------");
		System.out.println(unitprice);
		String unit=unitprice.replaceAll("[^a-zA-Z0-9]", unitprice);
		double finalunitPrice=Double.parseDouble(unit);
		System.out.println(finalunitPrice);
		return finalunitPrice/100;
		
	}
	
	public Double getTotalPrice() {
		
		String totalPrice=totalPriceEle.getText();
		System.out.println("-------------------");
		System.out.println(totalPrice);
		String tot=totalPrice.replaceAll("[^a-zA-Z0-9]", totalPrice);
		double finalTotalPrice=Double.parseDouble(tot);
		System.out.println(finalTotalPrice);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() {
		
		Action.click(driver, proceedToCheckOut);
		return new LoginPage();
		
	}
	
    public AddressPage clickOnCheckOut2() {
		
		Action.click(driver, proceedToCheckOut);
		return new AddressPage();
		
	}

	public AddressPage clickOnCheckOut1() {
		Action.click(driver, proceedToCheckOut);
		return new AddressPage();
	}
	
}
