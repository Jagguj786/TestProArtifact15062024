package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class AccountCreationPageTestdataProvider extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws InterruptedException {
		LaunchApp(browser);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
//	@Test(dataProvider="newAcountDetailsData", dataProviderClass=DataProviders.class)
//	public void verifyAccountCreationLandingPage(String email,String Gender,String fName,String lName,String passwd,String day,String month, String year) throws Throwable {
//		//,String salutation,String fName,String lName,String passwd,String day,String month, String year
//		
//		Log.startTestCase("-----verifyAccountCreationLandingPage-----");
//		indexPage= new IndexPage();
//		Log.info("user is going to click on SignIn");
//		loginPage=indexPage.clickOnSignIn();
//		Thread.sleep(3000);
//		accountCreationPage=loginPage.createNewAccount(email);
//		//accountCreationPage=loginPage.createNewAccount("TUYTy7465@gmail.com");
//		
//		boolean result=accountCreationPage.validateAccountCreationpage();
//		Assert.assertTrue(result);
//		
//		//accountCreationPage.createAccount("Mr", "fName", "lName", "Touy874*&wd", "12", "6", "1996");
//		accountCreationPage.createAccount(Gender, fName, lName, passwd, day, month, year);
//		
//	    homePage = accountCreationPage.validateRegistration();
//	    Thread.sleep(3000);
//	    boolean result2= homePage.ValidateHomePageAfterLogin();
//	    
//	    Assert.assertTrue(result2);
//	    
//	    boolean result3=homePage.accountCreationSuccessfully();
//	    Assert.assertTrue(result3);
//	    Log.endTestCase("-----verifyAccountCreationLandingPage-----");
//	}
	
	@Test(dataProvider="newAcountDetailsData", dataProviderClass=DataProviders.class)
	public void verifyAccountCreationLandingPage(HashMap<String,String> hashMapValue) throws Throwable {
		//,String salutation,String fName,String lName,String passwd,String day,String month, String year
		
		Log.startTestCase("-----verifyAccountCreationLandingPage-----");
		indexPage= new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		Thread.sleep(3000);
		accountCreationPage=loginPage.createNewAccount(hashMapValue.get("Email"));
		//accountCreationPage=loginPage.createNewAccount("TUYTy7465@gmail.com");
		
		boolean result=accountCreationPage.validateAccountCreationpage();
		Assert.assertTrue(result);
		
		//accountCreationPage.createAccount("Mr", "fName", "lName", "Touy874*&wd", "12", "6", "1996");
		accountCreationPage.createAccount(hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"));
		
	    homePage = accountCreationPage.validateRegistration();
	    Thread.sleep(3000);
	    boolean result2= homePage.ValidateHomePageAfterLogin();
	    
	    Assert.assertTrue(result2);
	    
	    boolean result3=homePage.accountCreationSuccessfully();
	    Assert.assertTrue(result3);
	    Log.endTestCase("-----verifyAccountCreationLandingPage-----");
	}

}


