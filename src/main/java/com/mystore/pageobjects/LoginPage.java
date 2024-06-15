package com.mystore.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;




public class LoginPage extends BaseClass{
	
	@FindBy(name="email")   WebElement userName;
	@FindBy(name="passwd")  WebElement password;
    @FindBy(id="SubmitLogin") WebElement signInBtn;
	@FindBy(name="email_create") WebElement emailForNewAccount;
	@FindBy(name="SubmitCreate") WebElement createNewAccountBtn;
	@FindBy(xpath="//*[contains(text(),\"An account using this email address has already been registered. Please enter a valid password or request a new one.\")] ") WebElement ErrorMsg;
	@FindBy(xpath="//*[contains(text(),\"Invalid email address.\")]") WebElement inValiderror;
	////*[contains(text(),"An account using this email address has already been registered. Please enter a valid password or request a new one.")] 
	
	//HomePage homePage;
	//Action action=new Action();
	//Action act=new Action();
	public LoginPage() {
		PageFactory.initElements(driver, this);
	} 
	
	public HomePage login(String uName,String pswd,HomePage homePage) throws Exception {

		//System.out.println("Test");
		//Action.scrollByVisibilityOfElement(driver, userName);
//		Action.type(userName, uName);
//		Action.type(password, pswd);
//		Action.click(driver, signInBtn);
//		
//		Thread.sleep(2000);
//		homepage=new HomePage();
//		return homepage;
		//return new HomePage();
		
		
		//Action.scrollByVisibilityOfElement(driver, userName);
		Action.type(userName, uName);
		//Action.type(userName, prop.getProperty("username"));
		Action.type(password, pswd);
		//Action.type(password, prop.getProperty("password"));
		Action.JSClick(driver, signInBtn);
		Thread.sleep(2000);
		homePage=new HomePage();
		return homePage;
	}
	
	public AccountCreationPage createNewAccount(String email) throws InterruptedException {
		
		Action.type(emailForNewAccount, email);
		System.out.println("Before");
		Action.click(driver, createNewAccountBtn);
		System.out.println("After");
		Thread.sleep(3000);
		return new AccountCreationPage();
		//TestS76ua12786@gmail.com
		
//		if(ErrorMsg.isDisplayed()) {
//		String actText = ErrorMsg.getText();
//		String expText ="n account using this email address has already been registered. Please enter a valid password or request a new one.";
//		Assert.assertEquals(actText, expText, "-----Both are not Equal-----");
//		
//		}
		
}
	
public AddressPage login1(String uName,String pswd) {
		
		Action.type(userName, uName);
		Action.type(password, pswd);
		Action.click(driver, signInBtn);
		return new AddressPage();
		
	}

public void errorMsgVerify() throws InterruptedException {
	
	
	Action.type(emailForNewAccount, "TestS76ua12786@gmail.com");
	Action.click(driver, createNewAccountBtn);
	Thread.sleep(3000);
	
	String actText = ErrorMsg.getText();
	String expText ="An account using this email address has already been registered. Please enter a valid password or request a new one.";
	
	//Assert.assertEquals(actText, expText);
	Assert.assertEquals(actText, expText, "-----Both are not Equal-----");
	
	
}

public void verifyerrormsgIfNoMailisgiven() throws InterruptedException {
	
	Action.click(driver, createNewAccountBtn);
	Thread.sleep(3000);
	String act=inValiderror.getText();
	String exp="Invalid email address.";
	Assert.assertEquals(act, exp, "-----Both are not Equal-----");
	
}

}