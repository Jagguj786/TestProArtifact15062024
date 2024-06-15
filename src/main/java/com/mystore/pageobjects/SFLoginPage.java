package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SFLoginPage extends BaseClass{
	
	@FindBy(xpath="//input[@id=\"username\"]") private WebElement userName;
	@FindBy(xpath = "//input[@id=\"password\"]")private WebElement password;
	@FindBy(xpath = "//input[@id=\"Login\"]")private WebElement login;
	@FindBy(xpath="//span[contains(text(),\"Start your free trial. No credit card required, no software to install.\")]") private WebElement homePageMsg;
	@FindBy(id="search_query_top") WebElement searchProductBox;
	@FindBy(name="submit_search") WebElement searchBtn;
	//@FindBy(xpath="//*[@id=\"start-your-free-trial-no-credit-card-required-no-software-to-install\"]/span/text()") private WebElement homePageMsg;
	//*[@id="start-your-free-trial-no-credit-card-required-no-software-to-install"]/span/text()
	
	
	
	public SFLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public SFHomePage login(String uName,String pswd,SFHomePage sfhomepage) {
		
		Action.type(userName, uName);
		Action.type(password, pswd);
		Action.click(driver, login);
		Action.implicitWait(driver, 5);
		
		return sfhomepage;
	}
	
	public void verifyLoginPage() throws InterruptedException {
		
		Thread.sleep(5000);
		Action.type(userName, "jhdfiytrwiy76457");
		Action.switchToFrameByName(driver, "marketing");
		//Action.switchToFrameById(driver, "marketing");
		Thread.sleep(2000);
		String ActMsg = homePageMsg.getText();
		System.out.println(ActMsg);
		String ExpMsg = "Start your free trial. No credit card required, no software to install.";
		
		Assert.assertEquals(ExpMsg, ActMsg, "Both are not equal");
		//Action.switchToFrameByName(driver, null);
		Action.implicitWait(driver, 5);
		Action.switchToDefaultFrame(driver);
		Action.click(driver, login);
		Thread.sleep(3000);
		
	}
	
	

}
