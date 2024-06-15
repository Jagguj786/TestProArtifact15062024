package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	
@FindBy(xpath="//*[contains(text(),'Your order on My Shop is complete.')]") private WebElement confirmMsg;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getConfirmMessage() {
		
		String cnfMsgText = confirmMsg.getText();
		return cnfMsgText;
		
		}
    public void validateConfirmMsg() {
		
		String expCnfMsg = confirmMsg.getText();
		String actCnfMsg = "Your order on My Shop is complete.";
		System.out.println(expCnfMsg);
		
		Assert.assertEquals(actCnfMsg, expCnfMsg, "Both are not equal");
		}

}
