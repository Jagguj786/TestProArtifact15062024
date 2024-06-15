package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class AccountCreationPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		LaunchApp(); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyAccountCreationLandingPage() throws Throwable {
		
		indexPage= new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		Thread.sleep(3000);
		
		accountCreationPage=loginPage.createNewAccount("Te657654uaewri7347@gmail.com");
		
		boolean result=accountCreationPage.validateAccountCreationpage();
		Assert.assertTrue(result);
		
		accountCreationPage.createAccount("Mr", "Test", "Salesforce", "Testing*1234", "7", "4", "1994");
		
		
	    homePage = accountCreationPage.validateRegistration();
	    Thread.sleep(3000);
	    boolean result2= homePage.ValidateHomePageAfterLogin();
	    
	    Assert.assertTrue(result2);
	    
	    boolean result3=homePage.accountCreationSuccessfully();
	    Assert.assertTrue(result3);
	    
	}
	
	@Test
	public void verifyErrorMsgIfgivingexisingemail() throws Throwable {
		
		indexPage= new IndexPage();
		//Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		
		Thread.sleep(3000);
		loginPage.errorMsgVerify();
		
	
	}	
	
	@Test
	public void verifyErrorMsgwhenemailnotgiven() throws Throwable {
		
		indexPage= new IndexPage();
		//Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		
		Thread.sleep(3000);
		loginPage.verifyerrormsgIfNoMailisgiven();
		
	
	}

}
