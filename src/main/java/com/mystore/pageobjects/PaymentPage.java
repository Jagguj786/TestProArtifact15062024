package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass{
	//@FindBy(xpath="//span[contains(text(),'I confirm my order')]") private WebElement confirmOrderBtn;
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]") private WebElement bankWireMethod;
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]") private WebElement payByCheckMethod;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage clickOnPaymentMethod() {
		Action.click(driver, bankWireMethod);
		return new OrderSummaryPage();
	}

}
