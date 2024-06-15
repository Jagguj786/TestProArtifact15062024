package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass{
	@FindBy(xpath="//span[text()='Proceed to checkout']") WebElement proceedToCheckOutBtn;
	@FindBy(xpath="//label[text()='Choose a delivery address:']") WebElement verifyAddressPageText;
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ShippingPage clickOnChectOut() {
		Action.click(driver, proceedToCheckOutBtn);
		return new ShippingPage();
	}
	
	public boolean verifyAddressPage() {
		boolean result=Action.isDisplayed(driver, verifyAddressPageText);
		String act = verifyAddressPageText.getText();
		System.out.println(act);
		String exp = "Choose a delivery address:";
		System.out.println(exp);
		Assert.assertEquals(act, exp, "Both are not equal");
		return result;
		
	}

}
